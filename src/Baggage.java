import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Tintin on 2017. 10. 11..
 */

public class Baggage {
	
	private List<Item> items;
	private int h;
	private int w;
	private int[][] layout;
	
	
	public Baggage(int h, int w, List l) {
		this.items = new ArrayList<>();
		layout = new int[h][w];
		this.h = h;
		this.w = w;
		this.items = l;
	}
	
	// FF
	public void calculateLayoutFF() {
	
	}
	
	// FFD
	public void calculateLayoutFFD() {
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i));
		}
		System.out.println();
		items.sort(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o2.size() - o1.size();
			}
		});
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i));
		}
	}
	
	
	public void printLayout(){
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(layout[i][j]);
				if (j+1 != w) System.out.print('\t');
			}
			System.out.println();
		}
	}
}
