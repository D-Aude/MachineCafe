package repositories;

public class EmailNotifierRepository implements EmailNotifier {

	@Override
	public void notifyMissingDrink(String drink) {
		System.out.println("Notification envoye concernant : " + drink);
		
	}

}
