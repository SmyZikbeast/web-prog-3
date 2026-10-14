package tools;

import resources.Point;
import resources.Submission;

public class Checker {
    private static int id = 0;
    public static Submission check(Point point, long start){
        Submission result = new Submission(id++, point, 0, hit(point));
        result.setScriptTime((int) (System.nanoTime() - start));
        return result;
    }

    private static String hit(Point point){
        float x = point.getX();
        float y = point.getY();
        float r = point.getR();
        if (x <= 0 && y >= 0 && x >= -r && y <= r){
            return "hit";
        }
        if (x <= 0 && y <= 0 && y >= -r*x/2.0-r/2.0){
            return "hit";
        }
        if (x >= 0 && y <= 0 && Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)){
            return "hit";
        }
        return "miss";
    }
}
