package com.example.chessgame.model;


public class Index {
    private  int row;
    private  int column;

    public Index(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "[I: " + row + " " + column + "]\n";
    }



    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Index theObject)) return false;
        return column == theObject.getColumn() && row == theObject.getRow();
    }
}
