import java.awt.*;
import java.awt.event.*;

import javax.swing.event.MouseInputAdapter;


public class Board extends MouseAdapter{
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

    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();
    }

    public int getRowClicked(int mx,int my){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // x x x x ( )
                if(my>=(board[i][j].getRow()-1)*squareLength+90
                && my<= (board[i][j].getRow()-1)*90+squareLength+1){
                    return board[i][j].getRow();
                }

            }
        }
        return-1;

    }

    public int getColClicked(int mx,int my){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // x x x x ( )
                if(mx>=(board[i][j].getCol()-1)*squareLength+100
                && mx<= (board[i][j].getCol()-1)*95+squareLength+1){
                    return board[i][j].getCol();
                }

            }
        }
        return-1;

    }


    
}
