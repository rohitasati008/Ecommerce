import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ServiceImpl implements  Service{
HashMap<String, Integer> productRepo = new HashMap<>();
HashMap<String, ArrayList<String>> productUser = new HashMap<>();
HashMap<String, ArrayList<String>> userProduct = new HashMap<>();
HashSet<String> blockedUser  = new HashSet<>();


public void add(String product)
{
	if(!productRepo.containsKey(product))
	productRepo.put(product,1);
	else
	{
		int k = productRepo.get(product);
		productRepo.put(product, k+1);
	}
	for(String key : productRepo.keySet())
	{
		System.out.println("item " + key + " value :" +productRepo.get(key));
	}
}
public void purchase(String user , String product) throws BlockedUserException
{
	if(!blockedUser.contains(user))
	{	
	if(!productUser.containsKey(product))
	{
	ArrayList<String> userInfo =  new ArrayList<>() ;
	userInfo.add(user);
	productUser.put(product,userInfo);
}
	else
	{
		ArrayList<String> userInfo = productUser.get(product);
		if(!userInfo.contains(user))
		userInfo.add(user);
		productUser.put(product, userInfo);
	}
	if(!userProduct.containsKey(user))
	{
	ArrayList<String> userInfo = new ArrayList<>() ;
	
	userInfo.add(product);
	productUser.put(user,userInfo);
}
	else
	{
		
		ArrayList<String> userInfo = productUser.get(user);
		if(userInfo.contains(product))
		userInfo.add(product);
		productUser.put(user, userInfo);
	}
	}
	else
		throw new BlockedUserException();
}
public void block(String user)
{
	if(!blockedUser.contains(user))
	blockedUser.add(user);
}
public void returnProduct(String user , String product)
		{
	     if(!blockedUser.contains(user))
	     {
	    	 if(productRepo.containsKey(product))
	    	 {
	    	int k = productRepo.get(product);
	    	if(k>0)
	    		k--;
	    	productRepo.put(product, k);
	    	 }
	    	 if(userProduct.containsKey(user))
	    	 {
	    		 ArrayList<String> items = userProduct.get(user);
	    		 if(items.contains(product))
	    		 {
	    			 items.remove(product);
	    		 }
	    	 }
	    	 if(productUser.containsKey(product))
	    	 {
	    		 ArrayList<String> items = productUser.get(product);
	    		 if(items.contains(user))
	    		 {
	    			 items.remove(user);
	    		 }
	    	 }
	     }
	     
		}
public String maxProductSell()
{
	int Maxsize = 0;
	String maxProduct = null ;
	for(String arr : productUser.keySet())
	{
	int size = productUser.get(arr).size();
	if(size>Maxsize)
	{
		maxProduct = arr;
		Maxsize = size;
	
	}
	}
	return maxProduct;
	
}

}