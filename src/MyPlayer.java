import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public int col1;
    public int col2;
    public int col3;

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        printBoards();
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

    public void printResultBoards(int a, int b, int c){

        for(int loopc = c-1; loopc >= 0; loopc --){
            System.out.println("resultboard: " + a + b + loopc);
        }

        for(int loopb = b-1; loopb >= 0; loopb --){
            if(loopb < c){
                System.out.println("resultboard: " + a + loopb + loopb);
            }
            else{
                System.out.println("resultboard: " + a + loopb + c);
            }
        }

        for(int loopa = a-1; loopa >= 1; loopa --){
            if(loopa < b || b < c){
                System.out.println("resultboard: " + a + loopa + loopa);
            }
            else{
                System.out.println("resultboard: " + loopa + b + c);
            }
        }
        System.out.println("**************************************************************************************************");
    }

    public void winningBoards(){

    }

}




