import java.util.Collection;

public class Homework7Test {

	public static void main(String[] args) {
		
		int size = 5;
		Board board = new Board(size);
		board.addPiece(0, 0);
		board.addPiece(1, 1);
		board.addPiece(1, 3);
		
		System.out.println("Board");
		System.out.println("-----");
		System.out.println(board);

		
		Collection<Board> successors = board.getSuccessors();
		System.out.println("Successors (" + successors.size() + ")");
		System.out.println("----------");
		for (Board successor : successors) {
			System.out.println(successor);
		}

	}

}
