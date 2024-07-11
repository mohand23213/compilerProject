package application;
import java.util.ArrayList;
import java.util.Arrays;

public class data {
	ArrayList<String> terminals;
	String[] x= {
			"module","begin","end","const","var","integer","real","char",
			"procedure","mod","div","readint","readreal","readchar",
			"readln","writeint","writereal","writechar","writeln",
			"if","then","end","else","while","do","end","loop","until","exit","call","name","integer-value","real-value"
			,"=","|=","<","<=",">",">=",",","/","*","-","+","(",")",";",":",".",":="
			};
	data(){
		terminals=new ArrayList<>(Arrays.asList(x));
	}
}