package homework4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * 
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

	/** The maze */
	private TwoDimGrid maze;

	public Maze(TwoDimGrid m) {
		maze = m;
	}

	/** Wrapper method. */
	public boolean findMazePath() {
		return findMazePath(1, 2); // (0, 0) is the start point.
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
	public boolean findMazePath(int x, int y) {
		// COMPLETE HERE FOR PROBLEM 1
		if (x < 0 || y < 0 || x > maze.getNCols() - 1 || y > maze.getNRows() - 1) {
			return false;
		} else {
			boolean open_square = maze.getColor(x, y) == NON_BACKGROUND;
			if (!(open_square)) {
				return false;
			} else {
				if (x == 0 && y == 0) {
					return true;
				} else {
					try {
						return findMazePath(x, y - 1) || findMazePath(x - 1, y) || findMazePath(x + 1, y) || findMazePath(x, y + 1);
					} catch (StackOverflowError t) {
						return false;
					}
				}
			}
		}
	}

	private static void addAllElem(ArrayList<ArrayList<PairInt>> result, ArrayList<ArrayList<PairInt>> array) {
		if (array != null) {
			/*
			for (int i = 0; i < array.size(); i++) {
				ArrayList<PairInt> data = array.get(i);
				if (data != null) {
					result.add(data);
				}
			}
			*/
			result.addAll(array);
		}
	}

	public ArrayList<ArrayList<PairInt>> findAllMazePathsHelper(int x, int y) {
		if (x < 0 || y < 0 || x > maze.getNCols() - 1 || y > maze.getNRows() - 1) {
			return null;
		} else {
			boolean open_square = maze.getColor(x, y) == NON_BACKGROUND;
			if (!(open_square)) {
				return null;
			} else {
				ArrayList<ArrayList<PairInt>> array = new ArrayList<ArrayList<PairInt>>();
				ArrayList<PairInt> newPairArrayList = new ArrayList<PairInt>();
				PairInt newPair = new PairInt(x, y);
				newPairArrayList.add(newPair);
				array.add(newPairArrayList);
				if (x == 0 && y == 0) {
					return null;
				} else {
					try {
						addAllElem(array, findAllMazePathsHelper(x, y - 1));
						addAllElem(array, findAllMazePathsHelper(x - 1, y));
						addAllElem(array, findAllMazePathsHelper(x + 1, y));
						addAllElem(array, findAllMazePathsHelper(x, y + 1));
						return array;
					} catch (StackOverflowError t) {
						return null;
					}
				}
			}
		}
	}

	/*
	 * public ArrayList<PairInt> findAllMazePathsHelper(ArrayList<PairInt> result,
	 * int x, int y) { if (!(findMazePath(x,y))) { return null; } else { PairInt
	 * current = new PairInt(x, y); result.add(current); if (x == 0 && y == 0) {
	 * //add the current to the arraylist return result; } else { //check all sides
	 * try { ArrayList<PairInt> solution = findAllMazePathsHelper(result, x - 1, y -
	 * 1); result.addAll(findAllMazePathsHelper(result, x, y - 1));
	 * result.addAll(findAllMazePathsHelper(result, x + 1, y - 1));
	 * result.addAll(findAllMazePathsHelper(result, x - 1, y));
	 * result.addAll(findAllMazePathsHelper(result, x + 1, y));
	 * result.addAll(findAllMazePathsHelper(result, x - 1, y + 1));
	 * result.addAll(findAllMazePathsHelper(result, x, y + 1));
	 * result.addAll(findAllMazePathsHelper(result, x + 1, y + 1)); return array; }
	 * catch (StackOverflowError t) { return null; } } } }
	 */

	// ADD METHOD FOR PROBLEM 2 HERE
	/*
	public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
		// COMPLETE HERE FOR PROBLEM 1
		return findAllMazePathsHelper(x, y);
	}
	*/
	
	public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
		if (x == 0 && y == 0) {
			ArrayList<PairInt> newSolution = new ArrayList<PairInt>(trace);
			result.add(newSolution);
		} else {
			if (!((y - 1) < 0 || (y - 1) > maze.getNRows() - 1)) {
				if (maze.getColor(x, y - 1) != PATH && maze.getColor(x, y - 1) == NON_BACKGROUND) {
					maze.recolor(x,  y - 1, PATH);
					PairInt newPair = new PairInt(x, y - 1);
					trace.add(newPair);
					findMazePathStackBased(x, y - 1, result, trace);
					maze.recolor(x,  y - 1, NON_BACKGROUND);
				}
			}
			if (!((x - 1) < 0 || (x - 1) > maze.getNCols() - 1)) {
				if (maze.getColor(x - 1, y) != PATH && maze.getColor(x - 1, y) == NON_BACKGROUND) {
					maze.recolor(x - 1,  y, PATH);
					PairInt newPair = new PairInt(x - 1, y);
					trace.add(newPair);
					findMazePathStackBased(x - 1, y, result, trace);
					maze.recolor(x - 1,  y, NON_BACKGROUND);
				}
			}
			if (!((x + 1) < 0 || (x + 1) > maze.getNCols() - 1)) {
				if (maze.getColor(x + 1, y) != PATH && maze.getColor(x + 1, y) == NON_BACKGROUND) {
					maze.recolor(x + 1,  y, PATH);
					PairInt newPair = new PairInt(x + 1, y);
					trace.add(newPair);
					findMazePathStackBased(x + 1, y, result, trace);
					maze.recolor(x + 1,  y, NON_BACKGROUND);
				}
			}
			if (!((y + 1) < 0 || (y + 1) > maze.getNRows() - 1)) {
				if (maze.getColor(x, y + 1) != PATH && maze.getColor(x, y + 1) == NON_BACKGROUND) {
					maze.recolor(x,  y + 1, PATH);
					PairInt newPair = new PairInt(x, y + 1);
					trace.add(newPair);
					findMazePathStackBased(x, y + 1, result, trace);
					maze.recolor(x,  y + 1, NON_BACKGROUND);
				}
			}
		}
	}
	
	public ArrayList <ArrayList <PairInt >> findAllMazePaths(int x, int y) {
		ArrayList <ArrayList <PairInt >> result = new ArrayList <>();
		if (findMazePath(x,y)) {
			Stack <PairInt > trace = new Stack <>();
			findMazePathStackBased(x, y, result, trace);
		}
		System.out.println(result.size());
		return result;
	}

	public String findAllMazePathsString(int x, int y) {
		ArrayList<ArrayList<PairInt>> resultList = findAllMazePaths(x, y);
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
		return findAllMazePathsString(1, 2);
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
