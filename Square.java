public class Square {
    private Piece piece;
    private int row;
    private int col;
    public Square(){
        row=-1;
        col=-1;
        piece=new Piece(" ",-1,-1);

    }

    public Square(int row,int col,Piece piece){
        this.row=row;
        this.col=col;
        this.piece=piece;

    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "Square [row=" + row + ", col=" + col + "]";
    }

    
}
