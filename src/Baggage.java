import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tintin on 2017. 10. 11..
 * Random thought
 */


public class Baggage {
	
	private int height;
	private int width;
	private Node root;
	private int[][] output;
	
	public Baggage(int height, int width) {
		root = new Node(0, 0, height, width);
		output = new int[height][width];
		this.height = height;
		this.width = width;
	}
	
	// FirstFitDecrement, mohó
	public void fit(List<Item> items) {
		sort(items);
		
		List<Item> usedItems = new ArrayList<>();
		
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			
			// Try to find a place
			boolean found = findPlace(item);
			// If did not find, rotate and try again
			if (!found) {
				item.rotate();
				found = findPlace(item);
			}
			if (found) {
				usedItems.add(item);
				addOutput(item);
				// buildOutput(usedItems);
			} else {
				System.out.println("ERROR");
			}
		}
		/*Node next = root;
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			height = item.getHeight();
			width = item.getWidth();
			next = findNode(next, height, width);
			if (next != null) {
				item.setX(next.x);
				item.setY(next.y);
				next = splitNode(next, height, width, item);
			} else {
				i--;
				item.rotate();
			}
		}*/
	}
	
	private void addOutput(Item item) {
		for (int i = 0; i < item.getHeight(); i++) {
			for (int j = 0; j < item.getWidth(); j++) {
				output[item.getX() + j][item.getY() + i] = item.getIndex();
			}
		}
	}
	
	private void buildOutput(List<Item> usedItems) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				output[height][width] = 0;
			}
		}
		for (Item usedItem : usedItems) {
			for (int i = 0; i < usedItem.getHeight(); i++) {
				for (int j = 0; j < usedItem.getWidth(); j++) {
					output[usedItem.getX() + j][usedItem.getY() + i] = usedItem.getIndex();
				}
			}
		}
	}
	
	private boolean findPlace(Item item) {
		boolean found = false;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				found = isFit(i, j, item);
			}
		}
		return found;
	}
	
	private void sort(List<Item> items) {
		//items.sort((o1, o2) -> Math.max(o2.getWidth(), o2.getHeight()) - Math.max(o1.getWidth(), o1.getHeight()));
		items.sort((o1, o2) -> o2.size() - o1.size());
	}
	
	/*private Node findNode(Node root, int h, int w) {
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
		else
			return null;
	}*/
	
	/**
	 * Checks if an item can be placed on the given coordinates
	 *
	 * @param x    coordinate x
	 * @param y    coordinate y
	 * @param item item to be checked
	 * @return true if the item could be fitted, false otherwise
	 */
	private boolean isFit(int x, int y, Item item) {
		int itemHeight = item.getHeight();
		int itemWidth = item.getHeight();
		
		for (int i = 0; i < itemHeight; i++) {
			for (int j = 0; j < itemWidth; j++) {
				if (output[i][j] != 0) {
					return false;
				}
			}
		}
		if (x + itemWidth > this.width || y + itemHeight > this.height) {
			return false;
		}
		return true;
	}
	/*
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
	}*/
	
	public void printOutput() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(output[i][j]);
				if (j + 1 != width) System.out.print('\t');
			}
			System.out.println();
		}
	}
}
