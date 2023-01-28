import java.awt.*;
import java.awt.event.*;

public class Board {
    public static final int squareLength=200;
    private Square[][] board;
    private Square winner;
    private TicTacToe logic;
    private String currentTurn;
    private int rows,cols,movesMade;
    private boolean winnerFound;
    private String playerChoice;

    public Board(){
        board=new Square[3][3];
        logic=new TicTacToe();
        rows=board.length;
        cols=board[0].length;
        currentTurn=" ";
        winner=null;
        winnerFound=false;
        movesMade=0;
        playerChoice="";


    }

    public void update(){

    }

    public void draw(Graphics g){
        g.setFont(new Font ("Arial",Font.BOLD,180));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j]==null)
                board[i][j]=new Square();
            }
            
        }
    }


    
}
