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
		int numrows = maze.getNRows();
		int numcols = maze.getNCols();
		boolean[][] selected = new boolean[numcols][numrows];
		for (int i=0; i < selected.length; i++) {
			for (int j=0; j < selected[i].length; j++) {
				//System.out.println(i);
				//System.out.println(j);
				if (maze.getColor(i, j) != BACKGROUND) {
					selected[i][j] = true;
				} else {
					selected[i][j] = false;
				}
			}
		}
		boolean solution = findMazePath(0, 0); // (0, 0) is the start point.
		restore();
		for (int i=0; i < selected.length; i++) {
			for (int j=0; j < selected[i].length; j++) {
				if (selected[i][j]) {
					maze.recolor(i, j, NON_BACKGROUND);
				}
			}
		}
		return solution;
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
		if (x < 0 || y < 0 || x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || maze.getColor(x, y) != NON_BACKGROUND) {
			return false;
		}
		if (y == maze.getNRows() - 1 && x == maze.getNCols() - 1) {
			maze.recolor(x, y, PATH);
			return true;
		}
		maze.recolor(x, y, TEMPORARY);
		if (findMazePath(x, y - 1) || findMazePath(x - 1, y) || findMazePath(x + 1, y) || findMazePath(x, y + 1)) {
			maze.recolor(x, y, PATH);
			return true;
		} else {
			return false;
		}
	}
	
	public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
		PairInt newPair = new PairInt(x, y);
		if (y == maze.getNRows() - 1 && x == maze.getNCols() - 1) {
			ArrayList<PairInt> newSolution = new ArrayList<PairInt>();
			trace.push(newPair);
			newSolution.addAll(trace);
			result.add(newSolution);
			trace.pop();
		} else if (!(x < 0 || y < 0 || x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || maze.getColor(x, y) != NON_BACKGROUND)) {
			trace.push(newPair);
			maze.recolor(x,y,TEMPORARY);
            findMazePathStackBased(x, y-1, result, trace);
            findMazePathStackBased(x, y+1, result, trace);
            findMazePathStackBased(x-1, y, result, trace);
            findMazePathStackBased(x+1, y, result, trace);
            maze.recolor(x, y, NON_BACKGROUND);
            trace.pop();
		}
	} //
	
	public ArrayList <ArrayList <PairInt >> findAllMazePaths(int x, int y) {
		ArrayList <ArrayList <PairInt >> result = new ArrayList <>();
		if (findMazePath()) {
			Stack <PairInt > trace = new Stack <>();
			findMazePathStackBased(x, y, result, trace);
			//System.out.println(result.size());
		}
		return result;
	}

	public String findAllMazePathsString(int x, int y) {
		ArrayList<ArrayList<PairInt>> resultList = findAllMazePaths(x, y);
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
		return findAllMazePathsString(0, 0);
	}
	
	public ArrayList<PairInt> findMazePathMin(int x, int y){
    	ArrayList<ArrayList<PairInt>> allMazePaths = findAllMazePaths(x, y);
    	if (allMazePaths.size() != 0) {
    		int min = allMazePaths.get(0).size();
        	ArrayList<PairInt> shortestPath = allMazePaths.get(0);
        	for(int i = 0; i<allMazePaths.size(); i++) {
        		if(min > allMazePaths.get(i).size()) {
        			shortestPath = allMazePaths.get(i);
        		}
        	}
        	for (PairInt currentpair: shortestPath) {
        		maze.recolor(currentpair.getX(), currentpair.getY(), PATH);
        	}
        	return shortestPath;
    	} else {
    		return new ArrayList<PairInt>();
    	}
    }
	
	public String findMazePathMinString(int x, int y) {
		ArrayList<PairInt> resultList = findMazePathMin(x, y);
		StringBuilder resultStr = new StringBuilder();
		resultStr.append("[");
		int resultListSize = resultList.size();
		for (int i = 0; i < resultListSize; i++) {
			resultStr.append(resultList.get(i).toString());
			if (i < resultListSize - 1) {
				resultStr.append(",");
			}
		}
		resultStr.append("]");
		return resultStr.toString();
	}
	
	public String findMazePathMin() {
		return findMazePathMinString(0, 0);
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
