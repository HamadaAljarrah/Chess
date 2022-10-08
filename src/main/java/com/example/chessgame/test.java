package com.example.chessgame;

import com.example.chessgame.model.Board;
import com.example.chessgame.model.Index;

    public class test {

        private test(){}


        public static Index checkIfCollision(Index src, Index dest, Board board){
            boolean isHorizontalMove = src.getRow() == dest.getRow();
            boolean isRight = isHorizontalMove && src.getColumn() < dest.getColumn();
            boolean isLeft = isHorizontalMove && src.getColumn() > dest.getColumn();

            boolean isVertical = !isHorizontalMove;
            boolean isUp = isVertical && src.getRow() > dest.getRow();
            boolean isDown = isVertical && src.getRow() < dest.getRow();;

            boolean isDiagonal = src.getRow() != dest.getRow() && src.getColumn() != dest.getColumn();
            boolean rightDown = isDiagonal && src.getColumn() < dest.getColumn() && src.getRow() < dest.getRow();
            boolean rightUp = isDiagonal && src.getColumn() < dest.getColumn() && src.getRow() > dest.getRow();
            boolean leftDown = isDiagonal && src.getColumn() > dest.getColumn() && src.getRow() < dest.getRow();
            boolean leftUp = isDiagonal && src.getColumn() > dest.getColumn() && src.getRow() > dest.getRow();


            Index index = null;

            if(isHorizontalMove){
                if(isRight){
                    System.out.println("Right");
                    for (int i = (src.getColumn()+1); i <= dest.getColumn(); i++) {
                        if(board.getBlocks().get(dest.getRow()).get(i).hasPiece()){
                            if(src.getRow()!= dest.getRow() && src.getColumn()!= dest.getColumn())continue;
                            index = new Index(src.getRow(), i);
                            break;
                        }
                    }
                }
                if(isLeft){
                    System.out.println("Left");
                    for (int i = dest.getColumn(); i < src.getColumn(); i++) {
                        if(board.getBlocks().get(dest.getRow()).get(i).hasPiece()){
                            if(src.getRow()!= dest.getRow() && src.getColumn()!= dest.getColumn())continue;
                            index = new Index(src.getRow(), i);
                            break;
                        }
                    }
                }
            }
            if(isVertical){
                if(isUp){
                    System.out.println("Up");
                    for (int i = dest.getRow(); i < src.getRow(); i++) {
                        if(board.getBlocks().get(i).get(dest.getColumn()).hasPiece()){
                            if(src.getRow()!= dest.getRow() && src.getColumn()!= dest.getColumn())continue;
                            index = new Index(i, src.getColumn());
                            break;
                        }
                    }
                }
                if(isDown){
                    System.out.println("Down");
                    for (int i = (src.getRow()+1); i <= dest.getRow(); i++) {
                        if(board.getBlocks().get(i).get(dest.getColumn()).hasPiece()){
                            if(src.getRow()!= dest.getRow() && src.getColumn()!= dest.getColumn())continue;
                            index = new Index(i, src.getColumn());
                            break;
                        }
                    }
                }

            }
//        if(isDiagonal){
//            if(leftUp){
//                System.out.println("leftUp");
//                for (int i = dest.getColumn(); i < src.getColumn(); i++) {
//                    if(board.getBlocks().get(src.getRow()).get(i).hasPiece()){
//                        index = new Index(src.getRow(), i);
//                        break;
//                    }
//                }
//            }
//            if(leftDown){
//                System.out.println("leftDown");
//
//            }
//            if(rightUp){
//                System.out.println("rightUp");
//            }
//            if(rightDown){
//                System.out.println("rightDown");
//            }
//        }

            return index;
        }
    }


