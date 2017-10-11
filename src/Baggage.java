import java.util.List;

/**
 * Created by Tintin on 2017. 10. 11..
 */

public class Baggage {
	
	private List<Item> items;
	private int h;
	private int w;
	private Node root;
	private Node[][] matrix;
	private int[][] output;
	
	public Baggage(int h, int w, List l) {
		matrix = new Node[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				matrix[i][j] = new Node(i, j, 0, 0);
			}
		}
		root = new Node(0, 0, h, w);
		output = new int[h][w];
		this.h = h;
		this.w = w;
		this.items = l;
	}
	
	// FirstFitDecrement
	public void fit() {
		//items.sort((o1, o2) -> Math.max(o2.getW(),o2.getH()) - Math.max(o1.getW(),o1.getH()));
		items.sort((o1, o2) -> o2.size() - o1.size());
		
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			Node n = findNode(root, item.getH(), item.getW());
			if (n != null) {
				item.setX(n.x);
				item.setY(n.y);
				n = splitNode(n, h, w, item);
				root = n;
			}
		}
	}
	
	private Node findNode(Node root, int h, int w) {
		// Ha használva van, akkor rekurzió
		if (root.used) {
			Node next = this.findNode(root.right, h, w);
			if (next == null) {
				next = this.findNode(root.down, h, w);
			}
			return next;
		}
		// Ha nincs, és belefér, akkor megvan
		else if ((w <= root.w) && (h <= root.h))
			return root;
			// Egyébként hiba
		else
			return null;
	}
	
	private Node splitNode(Node n, int h, int w, Item i) {
		Node node = new Node(n.x, n.y, n.h, n.w);
		node.used = true;
		System.out.println("volt split");
		node.index = i.getIndex();
		node.down = new Node(node.x, node.y + h, node.w, node.h - h);
		node.right = new Node(node.x + w, node.y, node.w - w, h);
		return node;
	}
	
	public void printOutput() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				output[i][j] = matrix[i][j].index;
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(output[i][j]);
				if (j+1 != w) System.out.print('\t');
			}
			System.out.println();
		}
	}
}
