package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chess = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                //imprime o tabuleiro
                UI.printBoard(chess.getPieces());
                System.out.println();
                System.out.print("Origem: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Destino destino: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chess.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
