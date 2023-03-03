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
        turn=player2;
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

            winType="rows";
            return board[0][i];
        }
    }

    //check diogonal wins
    




return null;
    }






    }
