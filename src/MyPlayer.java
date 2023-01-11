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

    Point theMove = new Point(0,0);



    public MyPlayer() {
        columns = new int[3];
        losingBoard.add(new Board(1, 0, 0, new Point(0,0)));
        printBoards();

        for(Board wBoard : winningBoard) {
            System.out.println(wBoard.move);
        }

    }


    public Point move(Chip[][] pBoard) {

        gameBoard = pBoard;

        columns = checkChips(gameBoard);

        System.out.println("MyPlayer Move");

        int column = 0;
        int row = 0;

        row = theMove.x;
        column = theMove.y;


        for(Board wBoard : winningBoard) {
            if(wBoard.boardList.get(0) == columns[0]
                    &&
                    wBoard.boardList.get(1) == columns[1]
                    &&
                    wBoard.boardList.get(2) == columns[2]){

                row = wBoard.move.x;
                column = wBoard.move.y;

                System.out.println("MyPlayer Move" + wBoard.move.x + "," + wBoard.move.y);

            }
        }
        Point myMove = new Point(row, column);

        return myMove;
    }




    public int[] checkChips(Chip[][] gameBoard) {
        int[] cols = new int[3];
        for(int c = 0; c < 3; c++){
            for(int r = 0; r <3; r++){
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

        Point theMove = new Point(3,3);

        foundLoser = false;
        for (int loopc = c - 1; loopc >= 0; loopc--){
            System.out.println("resultboard: " + a + b + loopc + " (" +  loopc + ", " + 2 + ")");

            for (Board lBoard : losingBoard) {
                if (lBoard.boardList.get(0) == a && lBoard.boardList.get(1) == b && lBoard.boardList.get(2) == loopc) {
                    System.out.println("found losing board");
                    foundLoser = true;
                    theMove.setLocation(loopc,2);
                }
            }
        }
        for (int loopb = b - 1; loopb >= 0; loopb--) { // second col
            if (loopb < c) {
                System.out.println("resultboard: " + a + loopb + loopb + " (" +  loopb + ", " + 1 + ")");
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == a && lBoard.boardList.get(1) == loopb && lBoard.boardList.get(2) == loopb) {
                        System.out.println("found losing board");
                        foundLoser = true;
                        theMove.setLocation(loopb,1);

                    }
                }
            } else {
                System.out.println("resultboard: " + a + loopb + c + " (" +  loopb + ", " + 1 + ")");
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == a && lBoard.boardList.get(1) == loopb && lBoard.boardList.get(2) == c) {
                        System.out.println("found losing board");
                        foundLoser = true;
                        theMove.setLocation(loopb,1);

                    }
                }
            }
        }
        for(int loopa = a-1; loopa >= 1; loopa --){ // first col
            if(loopa < b && loopa < c){
                System.out.println("resultboard: " + loopa + loopa + loopa + " (" +  loopa + ", " + 0 + ")");
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == loopa && lBoard.boardList.get(1) == loopa && lBoard.boardList.get(2) == loopa){
                        System.out.println("found losing board");
                        foundLoser = true;
                        theMove.setLocation(loopa,0);

                    }
                }

            }
            else if(loopa < b){
                System.out.println("resultboard: " + loopa + loopa + c + " (" +  loopa + ", " + 0 + ")");
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == loopa && lBoard.boardList.get(1) == loopa && lBoard.boardList.get(2) == c){
                        System.out.println("found losing board");
                        foundLoser = true;
                        theMove.setLocation(loopa,0);

                    }
                }
            }
            else{
                System.out.println("resultboard: " + loopa + b + c + " (" +  loopa + ", " + 0 + ")");
                for (Board lBoard : losingBoard) {
                    if (lBoard.boardList.get(0) == loopa && lBoard.boardList.get(1) == b && lBoard.boardList.get(2) == c){
                        System.out.println("found losing board");
                        foundLoser = true;
                        theMove.setLocation(loopa,0);
                    }
                }
            }
        }


        System.out.println("**************************************************************************************************");

        if(foundLoser == false){
            losingBoard.add(new Board(a,b,c, theMove));
        }
        else{
            winningBoard.add(new Board(a,b,c, theMove));
            System.out.println("added this move to winning boards: " + theMove);
            for(Board wBoard : winningBoard) {
                System.out.println(wBoard.move);
            }
        }
    }
}