package au.com.nab.maze;

import au.com.nab.constants.Constants.Numeric;
import au.com.nab.maze.constants.Facing;

public class MazeGame {

	private final String fileName;
	
	public MazeGame(final String fileName) {
		this.fileName = fileName;
	}
	
	public void play() {
		Maze maze = new Maze(fileName);
		Cursor cursor = new Cursor(maze.getStartPoint(), Facing.EAST);
		cursor.explore(maze);
		maze.printPath();
	}
	
	
	public static void main(String[] args) {
		new MazeGame(args[Numeric.ZERO]).play();
	}
}
