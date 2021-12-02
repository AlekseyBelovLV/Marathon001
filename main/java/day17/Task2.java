package day17;

public class Task2 {
    public static void main(String[] args) {
        String[][] chessBoard = new String[8][8];

        fillChessBoardKramnikKasparov2000(chessBoard);
        fillChessBoardEmpty(chessBoard);
        print(chessBoard);

    }
    private static void fillChessBoardKramnikKasparov2000(String[][] chessBoard) {
        chessBoard[0][0] = ChessPiece.ROOK_BLACK.getStr();
        chessBoard[0][6] = ChessPiece.KING_BLACK.getStr();
        chessBoard[0][5] = ChessPiece.ROOK_BLACK.getStr();
        chessBoard[1][1] = ChessPiece.ROOK_WHITE.getStr();
        chessBoard[1][4] = ChessPiece.PAWN_BLACK.getStr();
        chessBoard[1][5] = ChessPiece.PAWN_BLACK.getStr();
        chessBoard[1][7] = ChessPiece.PAWN_BLACK.getStr();
        chessBoard[2][0] = ChessPiece.PAWN_BLACK.getStr();
        chessBoard[2][2] = ChessPiece.KNIGHT_BLACK.getStr();
        chessBoard[2][6] = ChessPiece.PAWN_BLACK.getStr();
        chessBoard[3][0] = ChessPiece.QUEEN_BLACK.getStr();
        chessBoard[3][3] = ChessPiece.BISHOP_WHITE.getStr();
        chessBoard[4][3] = ChessPiece.BISHOP_BLACK.getStr();
        chessBoard[4][4] = ChessPiece.PAWN_WHITE.getStr();
        chessBoard[5][4] = ChessPiece.BISHOP_WHITE.getStr();
        chessBoard[5][5] = ChessPiece.PAWN_WHITE.getStr();
        chessBoard[6][0] = ChessPiece.PAWN_WHITE.getStr();
        chessBoard[6][3] = ChessPiece.QUEEN_WHITE.getStr();
        chessBoard[6][5] = ChessPiece.PAWN_WHITE.getStr();
        chessBoard[6][7] = ChessPiece.PAWN_WHITE.getStr();
        chessBoard[7][6] = ChessPiece.KING_WHITE.getStr();
        chessBoard[7][5] = ChessPiece.ROOK_WHITE.getStr();

    }

    private static void fillChessBoardEmpty(String[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if(chessBoard[i][j] == null) { chessBoard[i][j] = ChessPiece.EMPTY.getStr(); }
            }
        }
    }

    private static void print(String[][] chessBoard) {
        System.out.println();
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
    }

}
