package resources;

public class Submission {
    int id;
    Point point;
    int scriptTime;
    String result;

    public Submission(int id, Point point, int scriptTime, String result) {
        this.id = id;
        this.point = point;
        this.scriptTime = scriptTime;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getScriptTime() {
        return scriptTime;
    }

    public void setScriptTime(int scriptTime) {
        this.scriptTime = scriptTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
