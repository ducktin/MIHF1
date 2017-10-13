/**
 * Created by Tintin on 2017. 10. 11..
 * Random thought
 */
// in baggage
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

public class Node {
	boolean used;
	int index;
	Node parent;
	Node down;
	Node right;
	int x;
	int y;
	int w;
	int h;
	
	public Node(int x, int y, int h, int w) {
		used = false;
		index = 0;
		parent = null;
		down = null;
		right = null;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
}
