import java.util.Scanner;


public class TicTacToe {
    private Scanner scan;
    private String[][] board;
    private String player1,player2;
    private int movesMade;
    private int rows,columns;
    public TicTacToe(){
        scan=new Scanner(System.in);
        board=new String[3][3];
        player2="O";
        player1="X";
        movesMade=0;
        rows=board.length;
        columns=board[0].length;

    }

    public void run(){
        System.out.println();
        String input=player1;
        String playAgainStatus="";
        boolean endgGame=false;
        setUpBoard();
        do {
            displayUpdateBoard();
            makeMove(input);
            input=changeTurns(input);
            movesMade++;
            if(movesMade==9 && winner().equals(" ")){
                displayUpdateBoard();
                System.out.println("TIE!");
                playAgainStatus=askToPlayAgain();
            }else if(movesMade<=9 && !winner().equals(" ")){
                displayUpdateBoard();
                System.out.println("The winner of this game is \'"+winner()+"\'");
                playAgainStatus=askToPlayAgain();

            }

            if(playAgainStatus.equalsIgnoreCase("No")){
                endgGame=true;
            }else if(playAgainStatus.equalsIgnoreCase("Yes")){
                playAgainStatus="";
                setUpBoard();
                movesMade=0;
                input=player1;

            }
            
        } while (!endgGame);

        System.out.println("\n\nThanks for playing! ");
        System.out.print("\n\n\n");

    }

    public void setUpBoard(){
        System.out.println("\nWELCOME TO THE TICTACTOE!");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j]=" ";
            }
        }
    }

    public void displayUpdateBoard(){
        System.out.print("\n");
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("["+board[i][j]+"]");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public String changeTurns(String turn){
        if(turn==player1){
            turn=player2;
        }else{
            turn= player1;
        }

        return turn;
    }

    public void makeMove(String move){
        boolean moveMade=false;
        int playerRow=0,playerColumn=0;
        do{
            System.out.println("player with \'"+move+"\'enter a row number(1,2 or 3):" );
            playerRow=scan.nextInt();

            System.out.println("player with \'"+move+"\'enter a column number(1,2 or 3):" );
            playerColumn=scan.nextInt();

            if((playerRow>=1 && playerRow<=rows)&&
            (playerColumn>=1 && playerColumn<=columns)&&
            board[playerRow-1][playerColumn-1].equals(" ")){
                board[playerRow-1][playerColumn-1]=move;
                moveMade=true;

            }else{
                System.out.println("invalid input , please try again");
            }

        }while(!moveMade);
    }

    public String winner(){
        //check row
        for (int i = 0; i < rows; i++) {
            if(board[i][0].equals(board[i][1])&&
            board[i][1].equals(board[i][2])&&
            board[i][0].equals(board[i][2])){
                return board[i][0];
            }
        }

        //check column
        for (int i = 0; i < rows; i++) {
            if(board[0][i].equals(board[1][i])&&
            board[1][i].equals(board[2][i])&&
            board[0][i].equals(board[2][i])){
                return board[0][i];
            }
        }
        //check diogonal
        if((board[0][0].equals(board[1][1])&&
        board[0][0].equals(board[2][2])&&
        board[1][1].equals(board[2][2]))){
            return board[0][0];

        }
        if((board[0][2].equals(board[1][1])&&
         (board[1][1].equals(board[2][0]))&&
        (board[0][2].equals(board[2][0])))){
            return board[0][2];
        }
        return " ";
    }

    public String askToPlayAgain(){
        String statusCall=" ";

        while(!(statusCall.equalsIgnoreCase("Yes")||
        statusCall.equalsIgnoreCase("No") )
        && !statusCall.equals("")){

            System.out.println("would you like to play again(yes/no)");
            statusCall=scan.next();
        }
        return statusCall;
    }




    public static void main(String[] args) throws Exception {
        
        TicTacToe ttt=new TicTacToe();
        ttt.run();
    }


}
