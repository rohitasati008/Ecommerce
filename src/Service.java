import java.util.ArrayList;

public interface Service {
	public void add(String product);
	 
	public void purchase(String user , String product) throws BlockedUserException ;
	 
	public void block(String user);
	 
	public void returnProduct(String user , String product);
			 
	public String maxProductSell();
	 
}
