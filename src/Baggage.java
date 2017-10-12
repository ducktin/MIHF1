import java.util.List;

/**
 * Created by Tintin on 2017. 10. 11..
 * Random thought
 */

public class Baggage {
	
	private int h;
	private int w;
	private Node root;
	private int[][] output;
	
	public Baggage(int h, int w) {
		root = new Node(0, 0, h, w);
		output = new int[h][w];
		this.h = h;
		this.w = w;
	}
	
	// FirstFitDecrement
	public void fit(List<Item> items) {
		sort(items);
		
		Node next = root;
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			h = item.getH();
			w = item.getW();
			next = findNode(next, h, w);
			if (next != null) {
				item.setX(next.x);
				item.setY(next.y);
				next = splitNode(next, h, w, item);
			} else {
				i--;
				item.rotate();
			}
		}
	}
	
	private void sort(List<Item> items) {
		//items.sort((o1, o2) -> Math.max(o2.getW(), o2.getH()) - Math.max(o1.getW(), o1.getH()));
		items.sort((o1, o2) -> o2.size() - o1.size());
	}
	
	private Node findNode(Node root, int h, int w) {
		// Ha használva van, akkor rekurzió
		if (root.used) {
			Node next = this.findNode(root.down, h, w);
			if (next == null) {
				next = this.findNode(root.right, h, w);
			}
			System.out.println("found one");
			return next;
		}
		// Ha nincs, és belefér, akkor megvan
		else if ((w <= root.w) && (h <= root.h)) {
			System.out.println("found one");
			return root;
		}
			// Egyébként hiba
		else
			return null;
	}
	
	private Node splitNode(Node node, int h, int w, Item item) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				output[i][j] = item.getIndex();
			}
		}
		node.used = true;
		node.index = item.getIndex();
		node.down = new Node(node.x, node.y + h, node.h - h, node.w);
		node.right = new Node(node.x + w, node.y, h, node.w - w);
		return node;
	}
	
	public void printOutput() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(output[i][j]);
				if (j+1 != w) System.out.print('\t');
			}
			System.out.println();
		}
	}
}
