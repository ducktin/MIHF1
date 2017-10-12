import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tintin on 2017. 10. 12..
 * Random thought
 */
public class Reader {
	
	Baggage readInput(InputStream inputStream) {
		Scanner reader = new Scanner(inputStream);
		
		int h = reader.nextInt();
		int w = reader.nextInt();
		
		reader.close();
		
		return new Baggage(h, w);
	}
	
	List<Item> readItems(InputStream inputStream) {
		Scanner reader = new Scanner(inputStream);
		
		int N = reader.nextInt();
		
		List<Item> items = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			int h = reader.nextInt();
			int w = reader.nextInt();
			
			items.add(new Item(h, w, i));
		}
		
		reader.close();
		
		return items;
	}
}
