import java.util.ArrayList;
import java.util.Collections;

class GetPath {
    public static void setPath(int i, int j, ArrayList<Point> path) {
        path.add(new Point(i,j));
    }

    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {
        setPath(r,c,path);
        if (r == 0 && c == 0) {
            Collections.reverse(path);
            return  true;
        }
        if (grid[r][c] != 1) {
            if (c!=0 && grid[r][c-1] == 0) {
                return getPath(r,c-1,path,grid);
            } else if (r!=0 && grid[r-1][c] == 0) {
                return getPath(r-1,c,path,grid);
            }
        }

        return false;
    }
}

class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

}


public class TestRobot {

    public static void main(String[] args) {

        final int [][] grid0 = {
                {0,0,0,0},
                {0,0,1,0},
                {0,0,0,1},
                {0,1,0,0}
        };


        ArrayList<Point> path = new ArrayList<>();

        boolean success = GetPath.getPath(3,2,path, grid0);

        System.out.println(success);
        if (success)
            System.out.println(path);
        path.clear();


        final int [][] grid = {
                {0,0,0,0},
                {0,0,1,0},
                {0,1,0,1},
                {0,1,0,0}
        };

        success = GetPath.getPath(3,2,path, grid);

        System.out.println(success);
        if (success)
            System.out.println(path);
        path.clear();


    }


}

