import java.awt.*;
import java.awt.event.*;


public class Board extends MouseAdapter{
    public static final int squareLength=200;
    private Square[][] board;
    private Square winner;
    private TicTacToeAPI logic;
    private String currentTurn;
    private int rows,cols,movesMade;
    private boolean winnerFound;
    private String playerChoice;

    public Board(){
        board=new Square[3][3];
        logic=new TicTacToeAPI();
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
                board[i][j]=new Square(i+1,j+1,new Piece(currentTurn,-1,-1));

                g.setColor(Color.WHITE);
                g.fillRect(i*squareLength+100,j*squareLength+90,squareLength,squareLength);
                ((Graphics2D)g).setStroke(new BasicStroke(4));
                g.setColor(Color.BLACK);
                g.drawRect(i*squareLength+100,j*squareLength+90,squareLength+1,squareLength+1);
                g.drawString(board[i][j].getPiece().getValue(), i*squareLength+95+(squareLength/5), j*squareLength+160+(squareLength/2));


            }
            
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.BOLD,60));
        g.drawString("Welcome to Tic-Tac-Toe!",50,60);

    }

    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();

        if(getRowClicked(mx, my)!=-1&&getColClicked(mx, my)!=-1&&!winnerFound){
            int squareRow=getRowClicked(mx, my);
            int squareCol=getColClicked(mx, my);
            if(board[squareCol-1][squareRow-1].getPiece().getValue().equals(" "));
            {
                currentTurn=logic.changeTurns(currentTurn);

            }
            if(board[squareCol-1][squareRow-1].getPiece().getValue().equals(" "));
            {
                board[squareCol-1][squareRow-1].setPiece(new Piece(currentTurn,squareRow,squareCol));
                movesMade++;                
            }

            //winner=logic.winner(board,rows,cols);

        }
    }

    public int getRowClicked(int mx,int my){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // x x x x ( )
                if(my>=(board[i][j].getRow()-1)*squareLength+90
                && my<= (board[i][j].getRow()-1)*squareLength+90+squareLength+1){
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
                && mx<= (board[i][j].getCol()-1)*squareLength+95+squareLength+1){
                    return board[i][j].getCol();
                }

            }
        }
        return-1;

    }


    
}
