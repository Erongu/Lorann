package model;

public class SpriteLOL {	
    String Type;
    int X;
    int Y;
    public SpriteLOL(String type, int x, int y)
    {
        Type=type;
        X=x;
        Y=y;
    }
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
}
