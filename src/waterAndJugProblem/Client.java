package waterAndJugProblem;

public class Client {

	public static void main(String[] args) {
		ISolution g = new GCDSolution();
		ISolution d = new DynamicSolution();
		for (int x = -1; x < 20; x++) {
			for (int y = -1; y < 20; y++) {
				for (int z = -1; z < 25; z++) {
					boolean gs = g.canMeasureWater(x, y, z);
					boolean ds = d.canMeasureWater(x, y, z);
					if (gs != ds) {
						System.out.printf(
								"Disagree on (%d,%d,%d) gs = %b, ds = %b %n"
								, x, y, z, gs, ds);
						
					}
				}
			}
		}
		System.out.println("All tests complete");
	}
}
