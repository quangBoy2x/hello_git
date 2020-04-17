package SODOKU;

public class Node {
    private int row;
    private int column;
    private int value;
    private int zone;


    public Node(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.zone=this.getZone();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public boolean isValidate()
    {
        if(this.value!=0)return true;
        return false;
    }
    public int getZone() {
        if (this.row >= 0 && this.row <= 2) {
            if (this.column
                    >= 0 && this.column <= 2)
                this.zone = 1;
            else if (this.column > 2 && this.column <= 5)
                this.zone = 2;
            else if (this.column > 5 && this.column <= 8)
                this.zone = 3;
        } else if (this.row >= 3 && this.row <= 5) {
            if (this.column >= 0 && this.column <= 2)
                this.zone = 4;
            else if (this.column > 2 && this.column <= 5)
                this.zone = 5;
            else if (this.column > 5 && this.column <= 8)
                this.zone = 6;
        } else if (this.row >= 6 && this.row <= 8) {
            if (this.column >= 0 && this.column <= 2)
                this.zone = 7;
            else if (this.column > 2 && this.column <= 5)
                this.zone = 8;
            else if (this.column > 5 && this.column <= 8)
                this.zone = 9;
        }
        return this.zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

}
