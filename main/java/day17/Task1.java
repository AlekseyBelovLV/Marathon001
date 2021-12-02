package day17;

public class Task1 {
    public static void main(String[] args) {
        ChessPiece pw = ChessPiece.PAWN_WHITE;
        ChessPiece rb = ChessPiece.ROOK_BLACK;

        String[] chess = new String[8];
            for(int i = 0; i < 4; i++) { chess[i] = pw.getStr(); }
            for(int j = 4; j < 8; j++) { chess[j] = rb.getStr(); }
            for(String i : chess) { System.out.print(i + " "); }
    }
}