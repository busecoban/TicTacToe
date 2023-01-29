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

                g.setColor(Color.WHITE);
                g.fillRect(i*squareLength+100,j*squareLength+90,squareLength,squareLength);
                ((Graphics2D)g).setStroke(new BasicStroke(4));
                g.setColor(Color.BLACK);
                g.drawRect(i*squareLength+100,j*squareLength+90,squareLength+1,squareLength+1);
                g.drawString(board[i][j].getPiece().getValue(), i*squareLength+95+(squareLength/5), j*squareLength+100+(squareLength/2));


            }
            
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.BOLD,60));
        g.drawString("Welcome to Tic-Tac-Toe!",50,60);
        
    }


    
}
