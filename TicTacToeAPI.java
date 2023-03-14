import java.awt.*;
public class TicTacToeAPI {
    private String player1,player2;
    private String winType;

    public TicTacToeAPI(){
        player1="O";
        player2="X";
        winType=" ";

        
    }

    public String changeTurns(String turn){
        if(turn.equals(" ")){
         return player1;
        }else if(turn.equals(player1)){
        turn=player2;
        }
        else{
        turn=player1;
        }
        return turn;



    }


    public Square winner(Square[][] board,int rows,int cols){
        //check colums wins

        for(int i=0;i<rows;i++){
            if((board[i][0].getPiece().getValue().equals(board[i][1].getPiece().getValue()))&&
            (board[i][1].getPiece().getValue().equals(board[i][2].getPiece().getValue()))&&
            (board[i][0].getPiece().getValue().equals(board[i][1].getPiece().getValue()))&&
            !(board[i][0].getPiece().getValue().equals(" "))&&
            !(board[i][1].getPiece().getValue().equals(" "))&&
            !(board[i][2].getPiece().getValue().equals(" "))){

                winType="column";
                return board[i][0];
            }
        }
    

    //check rows wins

    for(int i=0;i<cols;i++){
        if((board[0][i].getPiece().getValue().equals(board[1][i].getPiece().getValue()))&&
        (board[1][i].getPiece().getValue().equals(board[2][i].getPiece().getValue()))&&
        (board[0][i].getPiece().getValue().equals(board[1][i].getPiece().getValue()))&&
        !(board[0][i].getPiece().getValue().equals(" "))&&
        !(board[1][i].getPiece().getValue().equals(" "))&&
        !(board[2][i].getPiece().getValue().equals(" "))){

            winType="row";
            return board[0][i];
        }
    }

    //check diogonal wins
    if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])
    && board[0][2].getPiece()!=null){
        winType="diogonal";
        return board[0][2];
    }

    if(board[0][0].equals(board[2][2]) && board[0][0].equals(board[2][0])
    && board[0][2].getPiece()!=null){
        winType="diogonal";
        return board[0][0];
    }
    return null;
    




    }

    public void drawWinPath(Graphics G,Square winner,int squareLength){
        G.setColor(Color.CYAN);
        ((Graphics2D)G).setStroke(new BasicStroke(8));

        if(winType.equals("diogonal")){

            if(winner.getCol()-1==0){
                G.drawLine(
                (winner.getCol()-1)*squareLength+100,
                (winner.getRow()-1)*squareLength+90,
                squareLength*3+100,
                squareLength*3+90);

            }else if(winner.getCol()-2==2){
                G.drawLine((winner.getCol()-1)*squareLength+100+squareLength,
                (winner.getRow()-1)*squareLength+90,
                100,
                squareLength*3+90);
            }


        }else if(winType.equals("row")){
            G.drawLine((winner.getRow()-1*squareLength)+100,
            (winner.getCol()-1)*squareLength+200,
            squareLength*3+100,
            (winner.getCol()-1)*squareLength+200);


        }else if(winType.equals("column")){
            G.drawLine((winner.getRow()-1)*squareLength+200,
            (winner.getCol()-1)*squareLength+90,
            (winner.getRow()-1)*squareLength+200,
            squareLength*3+90);
        }
    }


    /* 
    public void gameResult(Graphics G,String result){
        G.setFont(new Font("Arial",Font.BOLD,75));
        if(result.equals("TIE")){

        }
    }
    */






    }
