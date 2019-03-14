package au.com.nab.maze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import au.com.nab.constants.Constants.Numeric;
import au.com.nab.maze.constants.CellType;
import au.com.nab.maze.factory.CellFactory;
import au.com.nab.maze.model.Cell;
import au.com.nab.maze.model.Coordinate;

public class Maze {
	
	private static final Logger LOGGER = Logger.getLogger(Maze.class);
	
	private final String fileName;
	private Cell[][] maze;
	private Coordinate startPoint;
	private Coordinate endPoint;

	public Maze(String fileName) {
		this.fileName = fileName;
		init();
	}

	public Coordinate getStartPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printPath() {
		// TODO Auto-generated method stub
		
	}
	
	public int getHeight() {
		return maze.length;
	}
	
	public int getWidth() {
		return maze[Numeric.ZERO].length;
	}

	private void init() {
		Path path = Paths.get(fileName);
		if (!Files.exists(path)) {
			throw new IllegalArgumentException("File " + fileName + " does not exist!");
		} 
		else {
			try {
				List<String> lines = Files.readAllLines(path);
				final int rowSize = lines.size();
				final int columnSize = lines.get(Numeric.ZERO).length();
				maze = new Cell[rowSize][columnSize];
				
				for (int rowIndex = Numeric.ZERO; rowIndex < rowSize; rowIndex++) {
					String line = lines.get(rowIndex);
					if (line.length() != columnSize) {
						throw new IllegalArgumentException("Incorrect width! Expecting: " + getWidth() + ", but got: " + line.length());
					} 
					else {
						for (int columnIndex = Numeric.ZERO; columnIndex < columnSize; columnIndex++) {
							Cell cell = CellFactory.makeCell(line.charAt(columnIndex));
							maze[rowIndex][columnIndex] = cell;
							if (CellType.START.equals(cell.getCellType())) {
								startPoint = new Coordinate(rowIndex, columnIndex);
							}
							else if (CellType.END.equals(cell.getCellType())) {
								endPoint = new Coordinate(rowIndex, columnIndex);
							}
						}
					}
				}
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
				throw new RuntimeException(e);
			}
			
		}
	}
}
