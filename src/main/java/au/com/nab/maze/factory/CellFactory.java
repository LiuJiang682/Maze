package au.com.nab.maze.factory;

import au.com.nab.maze.constants.CellType;
import au.com.nab.maze.model.Cell;

public class CellFactory {

	private static final char EMPTY = ' ';
	private static final char START = 'S';
	private static final char END = 'F';
	private static final char WALL = '#';
	
	private CellFactory() {
	}
	
	public static Cell makeCell(final char ch) {
		Cell cell = null;
		switch (ch) {
			case EMPTY:
				cell = new Cell(CellType.EMPTY);
				break;
			case START:
				cell = new Cell(CellType.START);
				break;
			case END:
				cell = new Cell(CellType.END);
				break;
			case WALL:
				cell = new Cell(CellType.WALL);
				break;
			default:
				throw new IllegalArgumentException("Unknown cell type: " + ch);
		}
		return cell;
	}
}
