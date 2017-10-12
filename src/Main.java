import java.util.List;

/**
 * Created by Tintin on 2017. 10. 11..
 * Random thought
 */
public class Main {
    public static void  main(String [] args) {
	    Reader reader = new Reader();
	
	    Baggage baggage = reader.readInput(System.in);
	    List<Item> items = reader.readItems(System.in);
	
	    baggage.fit(items);
	    baggage.printOutput();
    }
	
}
