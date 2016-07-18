package waterAndJugProblem;

import java.util.LinkedList;
import java.util.Queue;

public class DynamicSolution implements ISolution {

    private int maxX;
    private int maxY;
    private boolean[][] foundValues;
    private Queue<int[]> processList;
    
    private boolean admissible(int x, int y) {
        return 
            x >= 0 &&
            y >= 0 &&
            x <= maxX &&
            y <= maxY;
    }
    
    private int[] fill1(int x, int y) {
        return new int[] {maxX, y};
    }
    private int[] fill2(int x, int y) {
        return new int[] {x, maxY};
    }
    private int[] empty1(int x, int y) {
        return new int[] {0, y};
    }
    private int[] empty2(int x, int y) {
        return new int[] {x, 0};
    }
    private int[] pour1to2(int x, int y) {
        if (x + y > maxY) {
            return new int[] {x - (maxY - y), maxY};
        }
        return new int[] {0, x + y};
    }
    private int[] pour2to1(int x, int y) {
        if (x + y > maxX) {
            return new int[] {maxX, y - (maxX - x)};
        }
        return new int[] {x + y, 0};
    }

    @Override
    public boolean canMeasureWater(int x, int y, int z) {
        // Init
    	if (z < 0) return false;
    	if (z > x + y) return false;
    	if (x < 0 || y < 0) return false;
        this.maxX = x;
        this.maxY = y;
        processList = new LinkedList<int[]>();
        processList.offer(new int[] {0,0});
        foundValues = new boolean[x+1][y+1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                foundValues[i][j] = false;
            }
        }
        // Work
        while (!processList.isEmpty()) {
            int[] l = processList.poll();
            int currentX = l[0];
            int currentY = l[1];
            if (foundValues[currentX][currentY]) {
                continue;
            }
            foundValues[currentX][currentY] = true;
            if (currentX == z || 
            		currentY == z ||
            		(currentX + currentY) == z) {
            	return true;
            }
            int[][] candidates = new int[][] {
                fill1(currentX, currentY),
                fill2(currentX, currentY),
                empty1(currentX, currentY),
                empty2(currentX, currentY),
                pour1to2(currentX, currentY),
                pour2to1(currentX, currentY),
            };
            for (int[] candidate : candidates) {
                if (admissible(candidate[0], candidate[1])) {
                    processList.offer(candidate);
                }
            }
        }
        return false;
    }


}
