package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class parser {
	ArrayList<ProductionRule> productions;
	parser(ArrayList<ProductionRule> productions){
		this.productions=productions;
	}
    public ArrayList<String> check(String[] tokens) {
        Stack<Token> stack = new Stack<Token>();
        stack.push(new Token("module-decl'"));
        int index = 0;
        while (!stack.isEmpty()) {
            Token top = stack.peek();//get the top of the stack without pop
            if(top.value.compareTo("$")==0) {
            	if(tokens.length==index) {
                	return new ArrayList(Arrays.asList(true));///the code checked
            	}
            	else {
            		return new ArrayList(Arrays.asList(false,index,"unexpected text!  "+tokens[index]));///the module ended but there is a code 
            	}
            }
            if (top.isTerminal()) {
                if (index < tokens.length && (top.value.equals(tokens[index])  || ((top.value.equals("name") && isEnglishString(tokens[index])))   || (top.value.equals("integer-value") && isNumericString(tokens[index])) || (top.value.equals("real-value") && isRealValue(tokens[index])) )) {
                	stack.pop();
                    index++;
                } else {

                	return new ArrayList(Arrays.asList(false,index,"expected "+top.value)); // Terminal mismatch
                }
            } else {
                if (index < tokens.length) {
                    String lookahead = tokens[index];
                    ProductionRule rule = production(top,new Token(lookahead));
                    if (rule != null && rule.firsts!=null) {
                        stack.pop();
                        List<Token> right = rule.right;
                        for (int i = right.size() - 1; i >= 0; i--) {
                            if (!right.get(i).value.equals("λ")) {
                                stack.push(right.get(i));
                            }
                        }
                    } else {
                    	return new ArrayList(Arrays.asList(false,index,"unexpected text!"+tokens[index])); // No rule matches
                    }
                } else {
                	return new ArrayList(Arrays.asList(false,index,"unexpected text!")); // Input exhausted
                }
            }
        }
    	return new ArrayList(Arrays.asList(false,index,"undefined Text!")); // All input consumed
    }
    ProductionRule production(Token left,Token right) {
    	for(ProductionRule p:productions) {
    		if(p.left.value.compareTo(left.value)==0) {
    			if(p.firsts.contains(right) || (p.firsts.contains(new Token("name")) && isEnglishString(right.value) && !(right).isTerminal()   ) ||  (p.firsts.contains(new Token("integer-value")) && isNumericString(right.value))  ||   (p.firsts.contains(new Token("real-value")) && isRealValue(right.value))) {
    				return p;
    			}
    			
    		}
    	}
    	return new ProductionRule(right, null, null);
    }
    public boolean isEnglishString(String input) {
    	char c = input.charAt(0);
        // Check if the character is outside the range of English characters
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
            return false;
        }
        return true;
    }
    public static boolean isNumericString(String input) {
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
    public boolean isRealValue(String input) {
        // Define the regular expression pattern
        String pattern = "\\d(\\d)*\\.\\d(\\d)*";

        // Check if the input matches the pattern
        return input.matches(pattern);
    }
}
