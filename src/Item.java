/**
 * Created by Tintin on 2017. 10. 11..
 */
public class Item{
	
	private int h;
	private int w;
	private int x;
	private int y;
	private int index;
	
	public Item(int h, int w, int i) {
		this.h = h;
		this.w = w;
		
		this.index = i;
	}
	
	public int getIndex() {
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
		int temp = this.h;
        this.h = w;
        this.w = temp;
    }
	
	@Override
	public String toString() {
		return "Item{" +
				"h=" + h +
				", w=" + w +
				", index=" + index +
				'}';
	}
	
	public int size(){
        return h*w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
