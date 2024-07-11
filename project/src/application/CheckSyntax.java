package application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckSyntax {
	public String CheckSyntaxMethod(String code) {
		//Initialize the parser which will examine the code and give it the production Rules
		parser p=new parser(new fillFirst().productions);
		////divide the text into separate pieces depending on some keys
        String[] tokens = code.split("\\s+|(?=[-(){};:=<>|,/*+.])|(?<=[-(){};:=<>|,/*+.])");
        
        //fix array used to fix errors for example my code divide depending on . so if
        //3.14 it will become 3 . 14 so fix array rewrite it in a good way
        tokens=fixArray(tokens);
        
        
        tokens = Arrays.stream(tokens).filter(token -> !token.isEmpty()).toArray(String[]::new);
        ///check the errors
        ArrayList result=(p.check(tokens));
        
        ///extract the result from the result ArrayList
        return extractResult(result,code,tokens);
	}
	String extractResult(ArrayList result,String code,String[] tokens) {
		String originalCode=code;
		
		////check if the check return true which mean correct code!
		if((boolean)result.get(0)==true) {
			return "you code has no syntax errors!";
		}
		///return incorrect code result
		else {
			///set of command to determine the location of error
			for(int i=0;i<Math.min((int)result.get(1), tokens.length);i++) {
				code=code.trim();
				code=code.substring(tokens[i].length());
			}
			String resultString="";
			code=code.replaceAll("\\r?\\n", "");
			resultString+="Syntax Error"+ getSyntaxErrorLocation(originalCode,(int)result.get(1)) +" -----> "+code.substring(0, Math.min(20, code.length()))+"....";
			resultString+="\n";
			resultString+=result.get(2);
			return resultString;
		}
	}

     String [] fixArray (String[] x) {
    	ArrayList<String> text=new ArrayList(Arrays.asList(":","<",">","|"));
    	ArrayList<String> newString=new ArrayList<String>();
    	for(int i=0;i<x.length;i++) {
    		if(x[i].contains("=")) {
    			String s="";
    			s+="=";
    			if(i!=0 && text.contains(x[i-1])) {
    				s=x[i-1]+s;
    				newString.remove(newString.size()-1);
    			}
    			newString.add(s);
    		}
    		else if(x[i].contains(".")) {
    			String s="";
    			s+=".";
    			if((i!=0 && isNumericString(x[i-1]+""))) {
    				s=x[i-1]+s;
    				newString.remove(newString.size()-1);
    			}
    			if(i!=x.length-1 && isNumericString(x[i+1])) {
    				s=s+x[i+1];
    				i++;
    			}
    			newString.add(s);
    		}
    		else if(x[i].contains("mod")) {
    			//we split depending on mod word but module it has mod so we fix it here
    			int index=x[i].indexOf("mod");
    			if(x[i].length()>=4 && (     (index==0 && isNumericString(x[i].charAt(4)+""))     ||   (isNumericString(x[i].charAt(0)+""))   )) {
    				String[] arr = x[i].split("(?<=mod)|(?=mod)");
    				for(String part:arr) {
    					newString.add(part);
    				}
    			}
    			else {
        			newString.add(x[i]);
    			}
			}
    		else if(x[i].contains("div")) {
    			//we split depending on div word but divide it has div so we fix it here
    			int index=x[i].indexOf("div");
    			if(x[i].length()>=4 && (     (index==0 && isNumericString(x[i].charAt(4)+""))     ||   (isNumericString(x[i].charAt(0)+""))   )) {
    				String[] arr = x[i].split("(?<=div)|(?=div)");
    				for(String part:arr) {
    					newString.add(part);
    				}
    			}
    			else {
        			newString.add(x[i]);
    			}
			}
    		else {
    			newString.add(x[i]);
    		}
    	}
    	return newString.toArray(new String[0]);
    }
    public boolean isNumericString(String input) {
        // Iterate over each character in the string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Check if the character is not a digit
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public String getSyntaxErrorLocation(String code,int tokenIndex) {
    	///get the error location depending on the index of the token return from the result of the check function
    	String[] x=code.split("\\r?\\n");
    	
    	for(int i=0;i<x.length;i++) {
    		
    		if(x[i].length()==0)continue;
    		String[] tokens = x[i].trim().split("\\s+|(?=[-(){};:=<>|,/*+.])|(?<=[-(){};:=<>|,/*+.])");
            tokens=fixArray(tokens);
            
        	System.out.println(x[i]);
            if(tokens.length>tokenIndex) {
            	return " Line "+(1+i);
            }
            tokenIndex-=tokens.length;
    	}
    	return " Line "+(x.length+1);
    }
}
