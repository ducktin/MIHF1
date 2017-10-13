import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tintin on 2017. 10. 11..
 * Random thought
 */
public class Main {
	static List<Item> items;
	
	public static void  main(String [] args) {
		
		Baggage baggage = readInput();
		
		baggage.fit(items);
		baggage.printOutput();
	}
	
	private static Baggage readInput() {
		Scanner reader = new Scanner(System.in);
		
		int baggageH = reader.nextInt();
		int baggageW = reader.nextInt();
		int N = reader.nextInt();
		
		items = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int h = reader.nextInt();
			int w = reader.nextInt();
			items.add(new Item(h, w, i + 1));
		}
		
		Baggage baggage = new Baggage(baggageH, baggageW);
		
		reader.close();
		return baggage;
	}
	
}
