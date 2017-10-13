/**
 * Created by Tintin on 2017. 10. 11..
 * Random thought
 */
public class Item{
	
	private int height;
	private int width;
	private int x;
	private int y;
	private int index;
	
	public Item(int height, int width, int i) {
		this.height = height;
		this.width = width;
		
		this.index = i;
	}
	
	int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void rotate() {
		int temp = this.height;
		this.height = width;
		this.width = temp;
	}
	
	@Override
	public String toString() {
		return "Item{" +
				"height=" + height +
				", width=" + width +
				", index=" + index +
				'}';
	}
	
	public int size(){
		return height * width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
}
