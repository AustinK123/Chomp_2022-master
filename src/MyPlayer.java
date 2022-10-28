import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public int a;
    public int b;
    public int c;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        printBoards();
        printResultBoards();
    }

    public Point move(Chip[][] pBoard) {


        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;

    }
//100 200 300 110 210 310 220 320 330 111 211 311 221 321 331 222 322 332 333

    public void printBoards(){
        int boardnum = 1;
        for(int columnOne = 1; columnOne <= 3; columnOne++){
            for(int columnTwo = 0; columnTwo <= columnOne; columnTwo++){
                for(int columnThree = 0;columnThree <= columnTwo; columnThree++){
//                    if(columnOne >= columnTwo && columnTwo >= columnThree){
//                    columnOne = a;
//                    columnTwo = b;
//                    columnThree = c;
                        System.out.println(boardnum + " - board: " + columnOne + columnTwo + columnThree);
                        boardnum++;
//                    }
                }
            }
        }
        System.out.println("***********************");
    }

    public void printResultBoards(){
        int a = 3;
        int b = 3;
        int c = 3;
        for(int loopc = 0; loopc <= 3; loopc ++){
            System.out.println("resultboard: " + a + b + (c-loopc));
        }
        c = 3;
        for(int loopb = 0; loopb <= 3; loopb ++){
            if(loopb < c){
                System.out.println("resultboard: " + a + b + (b-loopb));
            }
        }
    }

}




