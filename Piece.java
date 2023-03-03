public class Piece {
    private String value;
    private int row;
    private int col;
   
    @Override
    public String toString() {
        return "Piece [value=" + value + "]";
    }

    public boolean equals(Object o){
        if(!(o instanceof Piece))
        return false;

        Piece p=(Piece) o;

        if(getValue().equals(p.getValue()))
        return true;

        return false;


    }



    public Piece(String value ,int row,int col){
        this.value=value;
        this.row=row;
        this.col=col;

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    
}
