package au.com.nab.maze.model;

import au.com.nab.maze.constants.CellType;

public class Cell {

	private CellType cellType;
	private boolean visited;
	
	public Cell(final CellType cellType) {
		this(cellType, false);
	}
	
	public Cell (final CellType cellType, final boolean visited) {
		this.cellType = cellType;
		this.visited = visited;
	}

	public CellType getCellType() {
		return cellType;
	}

	public boolean isVisited() {
		return visited;
	}
}
