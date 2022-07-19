package boardgame;

public class Board {
	private Integer rows;
	private Integer cols;
	private Piece[][] pieces;
	
	public Board() {
		
	}
	public Board(Integer rows, Integer cols) {
		if (rows < 1 || cols < 1) {
			throw new BoardException("Error Starting Board! (min. 1 row and 1 col)");
		}
		this.rows = rows;
		this.cols = cols;
		pieces = new Piece[rows][cols];
	}
	public Integer getRows() {
		return rows;
	}
	public Integer getCols() {
		return cols;
	}
	public Piece piece(Integer row, Integer col) {
		if (!positionExists(row, col)) {
			throw new BoardException("Position not found on the Board!");
		}
		return pieces[row][col];
	}
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not found on the Board!");
		}
		return pieces[position.getRow()][position.getCol()];
	}
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on postion!");
		}
		pieces[position.getRow()][position.getCol()] = piece;
		piece.position = position;
	}
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not found on the Board!");
		}
		if (piece(position) == null) {
			return null;	
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getCol()] = null;
		return aux;
	}
	private boolean positionExists(Integer row, Integer col) {
		return row >= 0 && row < rows && col >= 0 && col < cols;
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCol());
	}
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not found on the Board!");
		}
		return piece(position) != null;
	}
}
