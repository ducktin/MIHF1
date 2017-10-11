import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tintin on 2017. 10. 11..
 */
public class Main {
    public static void  main(String [] args) {
        Baggage baggage = readInput();
	    
        baggage.calculateLayoutFFD();
        
        //baggage.printLayout();
        
	    /*System.out.println(baggage.getH() + ", " + baggage.getW());
	    System.out.print("O:(");
	    for (int i = 0; i < baggage.getItems().size(); i++) {
		    System.out.print("("+baggage.getItems().get(i).getH()+", "+baggage.getItems().get(i).getW()+")");
	    }
	    System.out.println(")");*/
    }
    
    private static Baggage readInput(){
	    Scanner reader = new Scanner(System.in);
	    
	    int baggageH = reader.nextInt();
	    int baggageW = reader.nextInt();
	    int N = reader.nextInt();
	    
		List<Item> items = new ArrayList<>();
	    
	    for (int i = 0; i < N; i++) {
		    int h = reader.nextInt();
		    int w = reader.nextInt();
		    items.add(new Item(h,w));
	    }
	
	    Baggage baggage = new Baggage(baggageH, baggageW, items);
	
	    reader.close();
	    return baggage;
    }
	
	/*class Baggage {
		
		private List<Item> items;
		private int h;
		private int w;
		private int[][] layout;
		
		
		public List<Item> getItems() {
			return items;
		}
		
		public Baggage(int h, int w) {
			this.items = new ArrayList<>();
			layout = new int[h][w];
			this.h = h;
			this.w = w;
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
	}*/
}
