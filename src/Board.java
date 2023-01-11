import java.awt.*;
import java.util.ArrayList;

public class Board {

    public ArrayList<Integer> boardList = new ArrayList<>();
    public Point move;

    public Board(int cola, int colb, int colc, Point m){
        boardList.add(cola);
        boardList.add(colb);
        boardList.add(colc);
        move = m;
    }

}
