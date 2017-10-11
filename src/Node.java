/**
 * Created by Tintin on 2017. 10. 11..
 */
public class Node {
	boolean used;
	int index;
	Node down;
	Node right;
	int x;
	int y;
	int w;
	int h;
	
	public Node(int x, int y, int h, int w) {
		used = false;
		index = 0;
		down = null;
		right = null;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
}
