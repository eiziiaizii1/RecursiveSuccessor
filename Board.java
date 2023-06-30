//AZİZ ÖNDER 22050141021

import java.util.*;

public class Board {
	private final static int X = 0;
	private final static int Y = 1;
	private final static int neighbors[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public final int size;
	private final Set<Integer> pieces = new TreeSet<>();

	Board(int size) {
		this.size = size;
	}

	Board(Board board) {
		this.size = board.size;
		this.pieces.addAll(board.pieces);
	}

	Board(int size, int[] xs, int[] ys) {
		this.size = size;

		for (int i = 0; i < xs.length; i++) {
			addPiece(xs[i], ys[i]);
		}
	}

	public boolean isInside(int x, int y) {
		return x >= 0 && x < size && y >= 0 && y < size;
	}

	public boolean hasPiece(int x, int y) {
		if (isInside(x, y)) {
			int key = y * size + x;
			return pieces.contains(key);// student code
		} else
			return false;
	}

	public void addPiece(int x, int y) {
		if (isInside(x, y)) {
			int key = y * size + x;
			// student code
			pieces.add(key);
		}
	}

	public void removePiece(int x, int y) {
		if (isInside(x, y)) {
			int key = y * size + x;
			// student code
			pieces.remove(key);
		}
	}

	public Collection<Board> getSuccessors() {
		// student code
		Set<Board> succBoardSet = new HashSet<>();
		for (Integer num : pieces) {
			for (int i = 0; i < neighbors.length; i++) {
				int x= num % size + neighbors[i][X];
				int y= num / size + neighbors[i][Y];
				if(this.isInside(x, y)) {
					Board succBoard= new Board(this);
					succBoard.addPiece(x, y);
					succBoardSet.add(succBoard);
				}
			}
		}
		return succBoardSet;
	}

	@Override
	public int hashCode() {
		return pieces.hashCode() + size;
	}

	@Override
	public boolean equals(Object o) {
		// student code
		if (this == o) {
			return true;
		}
		if (o instanceof Board) {
			Board otherVal = (Board) o;
			return this.pieces.equals(otherVal.pieces) && this.size == otherVal.size;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				if (hasPiece(x, y))
					sb.append("#");
				else
					sb.append(".");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

}
