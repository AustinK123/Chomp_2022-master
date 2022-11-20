import java.awt.*;
import java.util.ArrayList;


public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public int col1;
    public int col2;
    public int col3;

    boolean foundLoser = false;

    public ArrayList<Board> losingBoard = new ArrayList<>();
    public ArrayList<Board> winningBoard = new ArrayList<>();

    public MyPlayer() {
        columns = new int[10];
        losingBoard.add(new Board(1, 0, 0));
        printBoards();
    }
    public Point move(Chip[][] pBoard) {


        System.out.println("MyPlayer Move");

        gameBoard = pBoard;

        columns = checkChips(gameBoard);

        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        Point myMove = new Point(row, column);
        return myMove;

    }
    public int[] checkChips(Chip[][] gameBoard) {
        int[] cols = new int[10];
        for(int c = 0; c < 10; c++){
            for(int r = 0; r <10; r++){
                if(gameBoard[r][c].isAlive == true){
                    cols[c]++;
                }
            }
        }


        return cols;
    }
    public void printBoards(){
        int boardnum = 1;
        for(int columnOne = 1; columnOne <= 3; columnOne++){
            for(int columnTwo = 0; columnTwo <= columnOne; columnTwo++){
                for(int columnThree = 0;columnThree <= columnTwo; columnThree++){

                        System.out.println(boardnum + " - board: " + columnOne + columnTwo + columnThree);
                        boardnum++;

                        col1 = columnOne;
                        col2 = columnTwo;
                        col3 = columnThree;

                    printResultBoards(col1,col2,col3);
                }
            }
        }
        System.out.println("***********************");
    }
    public void printResultBoards(int a, int b, int c) {

        foundLoser = false;

        for (int loopc = c - 1; loopc >= 0; loopc--){
            System.out.println("resultboard: " + a + b + loopc);

            for (Board lBoard : losingBoard) {
                if (lBoard.boardList.get(0) == a && lBoard.boardList.get(1) == b && lBoard.boardList.get(2) == loopc) {
                    System.out.println("found losing board");
                    foundLoser = true;
                }
            }

        }
        for (int loopb = b - 1; loopb >= 0; loopb--) { // second col
            if (loopb < c) {
                System.out.println("resultboard: " + a + loopb + loopb);
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == a && lBoard.boardList.get(1) == loopb && lBoard.boardList.get(2) == loopb) {
                        System.out.println("found losing board");
                        foundLoser = true;
                    }
                }
            } else {
                System.out.println("resultboard: " + a + loopb + c);
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == a && lBoard.boardList.get(1) == loopb && lBoard.boardList.get(2) == c) {
                        System.out.println("found losing board");
                        foundLoser = true;
                    }
                }
            }
        }
        for(int loopa = a-1; loopa >= 1; loopa --){ // first col
            if(loopa < b && loopa < c){
                System.out.println("resultboard: " + loopa + loopa + loopa);
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == loopa && lBoard.boardList.get(1) == loopa && lBoard.boardList.get(2) == loopa){
                        System.out.println("found losing board");
                        foundLoser = true;
                    }
                }

            }
            else if(loopa < b){
                System.out.println("resultboard: " + loopa + loopa + c);
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == loopa && lBoard.boardList.get(1) == loopa && lBoard.boardList.get(2) == c){
                        System.out.println("found losing board");
                        foundLoser = true;
                    }
                }
            }
            else{
                System.out.println("resultboard: " + loopa + b + c);
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == loopa && lBoard.boardList.get(1) == b && lBoard.boardList.get(2) == c){
                        System.out.println("found losing board");
                        foundLoser = true;
                    }
                }
            }
        }


        System.out.println("**************************************************************************************************");

        if(foundLoser == false){
            losingBoard.add(new Board(a,b,c));
        }
        else{
            winningBoard.add(new Board(a,b,c));
        }
    }
}