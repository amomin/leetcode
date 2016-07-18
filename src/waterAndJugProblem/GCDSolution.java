package waterAndJugProblem;

public class GCDSolution implements ISolution {

	private int gcd(int smaller, int larger) {
		if (smaller == 0) return larger;
		return gcd(larger % smaller, smaller);
	}
	
	@Override
	public boolean canMeasureWater(int x, int y, int z) {
		if (x < 0 || y < 0) return false;
		if (z < 0) return false;
		if (z == 0) return true;
		if (z > x + y) return false;
		int mn = Math.min(x, y);
		int mx = Math.max(x, y);
		if (mn == 0) {
			if (z == 0) return true;
			if (z == mx) return true;
			return false;
		}
		return z % gcd(mn, mx) == 0;
	}
}
