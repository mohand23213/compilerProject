package application;
import java.util.ArrayList;

public class ProductionRule {
	///each production rule has left token and right tokens and first tokens
    Token left;
    ArrayList<Token> right;
    ArrayList<Token> firsts;

    // Constructor
    public ProductionRule(Token left, ArrayList<Token> right,ArrayList<Token> first) {
        this.left = left;
        this.right = right;
        this.firsts = new ArrayList<>();
        this.firsts=first;
    }

	@Override
	public String toString() {
		return "ProductionRule [left=" + left + ", right=" + right +"------->firsts"+firsts+ "]";
	}
	boolean isEqualTokenWithLeftSide(Token token) {
		return left.value.compareTo(token.value)==0;
	}
}