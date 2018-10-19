package homework4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * 
 * @author Koffman and Wolfgang
 **/
public class MazeOld implements GridColors {

	/** The maze */
	private TwoDimGrid maze;

	public MazeOld(TwoDimGrid m) {
		maze = m;
	}

	/** Wrapper method. */
	public boolean findMazePath() {
		return findMazePath(0, 0, maze.getNCols() - 1, maze.getNRows() - 1); // (0, 0) is the start point.
	}

	/**
	 * Attempts to find a path through point (x, y).
	 * 
	 * @pre Possible path cells are in BACKGROUND color; barrier cells are in
	 *      ABNORMAL color.
	 * @post If a path is found, all cells on it are set to the PATH color; all
	 *       cells that were visited but are not on the path are in the TEMPORARY
	 *       color.
	 * @param x The x-coordinate of current point
	 * @param y The y-coordinate of current point
	 * @return If a path through (x, y) is found, true; otherwise, false
	 */
	public boolean findMazePath(int startx, int starty, int x, int y) {
		// COMPLETE HERE FOR PROBLEM 1
		if (x < 0 || y < 0 || x > maze.getNCols() - 1 || y > maze.getNRows() - 1) {
			return false;
		} else {
			boolean open_square = maze.getColor(x, y) == NON_BACKGROUND;
			if (!(open_square)) {
				return false;
			} else {
				if (x == startx && y == starty) {
					return true;
				} else {
					try {
						return findMazePath(startx, starty, x, y - 1) || findMazePath(startx, starty, x - 1, y) || findMazePath(startx, starty, x + 1, y) || findMazePath(startx, starty, x, y + 1);
					} catch (StackOverflowError t) {
						return false;
					}
				}
			}
		}
	}
	
	public void findMazePathStackBased(int startx, int starty, int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
		PairInt newPair = new PairInt(x, y);
		trace.push(newPair);
		if (x == startx && y == starty) {
			ArrayList<PairInt> newSolution = new ArrayList<PairInt>();
			while (trace.size() > 0) {
				newSolution.add(trace.pop());
			}
			//trace = new Stack<PairInt>();
			result.add(newSolution);
		} else {
			if (!((y - 1) < 0 || (y - 1) > maze.getNRows() - 1)) {
				if (maze.getColor(x, y - 1) != PATH && maze.getColor(x, y - 1) == NON_BACKGROUND) {
					maze.recolor(x,  y - 1, PATH);
					findMazePathStackBased(startx, starty, x, y - 1, result, trace);
					maze.recolor(x,  y - 1, NON_BACKGROUND);
				}
			}
			if (!((x - 1) < 0 || (x - 1) > maze.getNCols() - 1)) {
				if (maze.getColor(x - 1, y) != PATH && maze.getColor(x - 1, y) == NON_BACKGROUND) {
					maze.recolor(x - 1,  y, PATH);
					findMazePathStackBased(startx, starty, x - 1, y, result, trace);
					maze.recolor(x - 1,  y, NON_BACKGROUND);
				}
			}
			if (!((x + 1) < 0 || (x + 1) > maze.getNCols() - 1)) {
				if (maze.getColor(x + 1, y) != PATH && maze.getColor(x + 1, y) == NON_BACKGROUND) {
					maze.recolor(x + 1,  y, PATH);
					findMazePathStackBased(startx, starty, x + 1, y, result, trace);
					maze.recolor(x + 1,  y, NON_BACKGROUND);
				}
			}
			if (!((y + 1) < 0 || (y + 1) > maze.getNRows() - 1)) {
				if (maze.getColor(x, y + 1) != PATH && maze.getColor(x, y + 1) == NON_BACKGROUND) {
					maze.recolor(x,  y + 1, PATH);
					findMazePathStackBased(startx, starty, x, y + 1, result, trace);
					maze.recolor(x,  y + 1, NON_BACKGROUND);
				}
			}
		}
	} //
	
	public ArrayList <ArrayList <PairInt >> findAllMazePaths(int startx, int starty, int x, int y) {
		ArrayList <ArrayList <PairInt >> result = new ArrayList <>();
		if (findMazePath(startx, starty, x,y)) {
			Stack <PairInt > trace = new Stack <>();
			findMazePathStackBased(startx, starty, x, y, result, trace);
		}
		System.out.println(result.size());
		return result;
	}

	public String findAllMazePathsString(int startx, int starty, int x, int y) {
		ArrayList<ArrayList<PairInt>> resultList = findAllMazePaths(startx, starty, x, y);
		System.out.println(resultList.size());
		StringBuilder resultStr = new StringBuilder();
		resultStr.append("[");
		int resultListSize = resultList.size();
		for (int i = 0; i < resultListSize; i++) {
			resultStr.append("[");
			int resultListListSize = resultList.get(i).size();
			for (int j = 0; j < resultListListSize; j++) {
				resultStr.append(resultList.get(i).get(j).toString());
				if (j < resultListListSize - 1) {
					resultStr.append(",");
				}
			}
			resultStr.append("]");
			if (i < resultListSize - 1) {
				resultStr.append(",");
			}
		}
		resultStr.append("]");
		return resultStr.toString();
	}

	public String findAllMazePaths() {
		return findAllMazePathsString(0, 0, maze.getNCols() - 1, maze.getNRows() - 1);
	}

	// ADD METHOD FOR PROBLEM 3 HERE

	/* <exercise chapter="5" section="6" type="programming" number="2"> */
	public void resetTemp() {
		maze.recolor(TEMPORARY, BACKGROUND);
	}
	/* </exercise> */

	/* <exercise chapter="5" section="6" type="programming" number="3"> */
	public void restore() {
		resetTemp();
		maze.recolor(PATH, BACKGROUND);
		maze.recolor(NON_BACKGROUND, BACKGROUND);
	}
	/* </exercise> */
}
/* </listing> */
