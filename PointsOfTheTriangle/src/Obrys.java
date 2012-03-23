// Klasa przechowuj¹ca obrys w ogólnoœci czworok¹t w którym zawarty jest badany trójk¹t
public class Obrys {

	private int xmin;
	private int xmax;
	private int ymin;
	private int ymax;
	
	Obrys(int xmin, int xmax, int ymin, int ymax ){
	this.setXmax(xmax);
	this.setXmin(xmin);
	this.setYmax(ymax);
	this.setYmin(ymin);
	}

	public int getXmin() {
		return xmin;
	}

	public void setXmin(int xmin) {
		this.xmin = xmin;
	}

	public int getXmax() {
		return xmax;
	}

	public void setXmax(int xmax) {
		this.xmax = xmax;
	}

	public int getYmin() {
		return ymin;
	}

	public void setYmin(int ymin) {
		this.ymin = ymin;
	}

	public int getYmax() {
		return ymax;
	}

	public void setYmax(int ymax) {
		this.ymax = ymax;
	}
	
}
