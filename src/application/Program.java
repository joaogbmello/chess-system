package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chess = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chess.getCheckMate()) {
            try {
                UI.clearScreen();
                //imprime o tabuleiro
                UI.printMatch(chess, captured);
                System.out.println();
                System.out.print("Origem: ");
                ChessPosition source = UI.readChessPosition(sc);

                //exibe as possições possíveis de mover determinada peça
                boolean[][] possibleMoves = chess.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chess.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Destino: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chess.performChessMove(source, target);

                if (capturedPiece != null){
                    captured.add(capturedPiece);
                }

            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(chess, captured);
        sc.close();
    }
}
