package com.example.chessgame.model;

public class Collision {

    private Collision(){}


    public static int getNumOfStraightBlockingPieces(Index src, Index dest, Board board){
        int numOfBlockingPieces = 0;
        boolean isHorizontalMove = src.getRow() == dest.getRow() && src.getColumn()!= dest.getColumn();
        boolean isRight = isHorizontalMove && src.getColumn() < dest.getColumn();
        boolean isLeft = isHorizontalMove && src.getColumn() > dest.getColumn();
        boolean isVertical = src.getColumn() == dest.getColumn() && src.getRow()!= dest.getRow();;
        boolean isUp = isVertical && src.getRow() > dest.getRow();
        boolean isDown = isVertical && src.getRow() < dest.getRow();;

        if(isHorizontalMove){
            if(isRight){
                System.out.println("Right");
                for (int i = (src.getColumn()+1); i <= dest.getColumn(); i++) {
                    if(board.getBlocks().get(dest.getRow()).get(i).hasPiece()){
                        numOfBlockingPieces++;
                    }
                }
            }
            if(isLeft){
                System.out.println("Left");
                for (int i = dest.getColumn(); i < src.getColumn(); i++) {
                    if(board.getBlocks().get(dest.getRow()).get(i).hasPiece()){
                        numOfBlockingPieces++;
                    }
                }
            }
        }
        if(isVertical){
            if(isUp){
                System.out.println("Up");
                for (int i = dest.getRow(); i < src.getRow(); i++) {
                    if(board.getBlocks().get(i).get(dest.getColumn()).hasPiece()){
                        numOfBlockingPieces++;
                    }
                }
            }
            if(isDown){
                System.out.println("Down");
                for (int i = (src.getRow()+1); i <= dest.getRow(); i++) {
                    if(board.getBlocks().get(i).get(dest.getColumn()).hasPiece()){
                        numOfBlockingPieces++;
                    }
                }
            }
        }
        return numOfBlockingPieces;
    }

    public static int getNumOfDiagonalBlockingPieces(Index src, Index dest, Board board){
        int numOfBlockingPieces = 0;
        boolean isDiagonal = src.getRow() != dest.getRow() && src.getColumn() != dest.getColumn();
        boolean rightDown = isDiagonal && src.getColumn() < dest.getColumn() && src.getRow() < dest.getRow();
        boolean rightUp = isDiagonal && src.getColumn() < dest.getColumn() && src.getRow() > dest.getRow();
        boolean leftDown = isDiagonal && src.getColumn() > dest.getColumn() && src.getRow() < dest.getRow();
        boolean leftUp = isDiagonal && src.getColumn() > dest.getColumn() && src.getRow() > dest.getRow();

        if(isDiagonal){
            if(leftUp){
                System.out.println("leftUp");
                int x = src.getRow();
                for (int i = (src.getColumn()-1); i >= dest.getColumn(); i--) {
                    if(board.getBlocks().get(--x).get(i).hasPiece()){
                            numOfBlockingPieces++;
                    }
                }
            }
            if(leftDown){
                System.out.println("leftDown");
                int x = src.getRow();
                for (int i = (src.getColumn()-1); i >= dest.getColumn(); i--) {
                    if(board.getBlocks().get(++x).get(i).hasPiece()){
                        numOfBlockingPieces++;
                    }
                }

            }
            if(rightUp){
                System.out.println("rightUp");
                int x = src.getRow();
                for (int i = (src.getColumn()+1); i <= dest.getColumn(); i++) {
                    if(board.getBlocks().get(--x).get(i).hasPiece()){
                        numOfBlockingPieces++;
                    }
                }
            }
            if(rightDown){
                System.out.println("rightDown");
                int x = src.getRow();
                for (int i = (src.getColumn()+1); i <= dest.getColumn(); i++) {
                    if(board.getBlocks().get(++x).get(i).hasPiece()){
                        numOfBlockingPieces++;
                    }
                }
            }
        }

        return numOfBlockingPieces;
    }
    public static boolean canEat(Index src, Index dest, Board board){
        boolean isEnemy =
                board.getBlocks().get(dest.getRow()).get(dest.getColumn()).hasPiece() &&
                board.getBlocks().get(dest.getRow()).get(dest.getColumn()).getPiece().getColor() !=
                board.getBlocks().get(src.getRow()).get(src.getColumn()).getPiece().getColor();

        return isEnemy && getNumOfStraightBlockingPieces(src, dest, board) == 1
                || isEnemy && getNumOfDiagonalBlockingPieces(src, dest, board) == 1;
    }

}


