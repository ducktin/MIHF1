/**
 * Created by Tintin on 2017. 10. 11..
 */
public class Item{

    public Item(int h, int w) {
        this.h = h;
        this.w = w;
    }

    private int h;
    private int w;
    
    public void rotate(){
        int temp = this.h;
        this.h = w;
        this.w = temp;
    }
	
	@Override
	public String toString() {
		return "H: "+h+" W: "+w;
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
