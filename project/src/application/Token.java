package application;
public class Token {
	//each token has value which is string
	data d=new data();
    @Override
	public String toString() {
		return "Token [value=" + value + "]";
	}

	String value;

    // Constructor
    public Token(String value) {
        this.value = value;
    }

    // Method to check if the token is terminal (always returns true)
    public boolean isTerminal() {
        return d.terminals.contains(value);
    }
    @Override
    public boolean equals(Object obj) {
        return  ((Token) obj).value.compareTo(value)==0;
    }
}