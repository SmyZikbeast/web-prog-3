package resources;

public class Point {
    float x;
    float y;
    float r;

    public Point(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
}
