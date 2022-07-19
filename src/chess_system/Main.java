package chess_system;

import chess.ChessMatch;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Chess!");
		
		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
	}

}
