package pascalsTriangle1;

import java.util.List;

public class Client {

	public static void main(String[] args) {

		Solution s = new Solution();
		List<List<Integer>> l = s.generate(15);
		for (int i = 0; i < 15; i++) {
			System.out.printf("%2d:", i + 1);
			for (int j = 0; j < i + 1; j++) {
				System.out.printf("%d", l.get(i).get(j));
				if (j < i)
					System.out.printf(",");
			}
			System.out.printf("%n");
		}
	}

}
