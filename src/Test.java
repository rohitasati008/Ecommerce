
public class Test {
static Service s = new ServiceImpl();
public static void main(String[] args) {
	s.add("apple");
	s.add("pen");
	//s.block("rohit");
	try {
		s.purchase("rohit", "apple");
		s.purchase("aman", "pen");
		s.purchase("rohit", "pen");
	} catch (BlockedUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	s.add("charger");
	System.out.println(s.maxProductSell());
}
}
