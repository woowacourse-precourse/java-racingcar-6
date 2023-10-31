package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {

	public static List<Integer> move(List<Integer> count, int size) {
		for (int i = 0; i < size; i++) {
			int random = 0;
			int tmp = 0;
			initCount(count, size);

			random = Randoms.pickNumberInRange(0, 9);
			tmp = count.get(i) + moveOrNot(random);
			count.set(i, tmp);
		}
		return count;
	}

	private static List<Integer> initCount(List<Integer> cnt, int n) {
		for (int j = 0; j < n; j++) {
			cnt.add(0);
		}
		return cnt;
	}

	private static int moveOrNot(int num) {
		int go = 0;

		if (num >= 4)
			go = num;
		return go;
	}

	public static int findMax(List<Integer> position) {
		int max = Integer.MIN_VALUE;

		for (int i : position) {
			max = Math.max(max, i);
		}
		return max;
	}

	public static List<Integer> findIndexes(List<Integer> p, int max) {
		List<Integer> indexList = new ArrayList<Integer>();
		int index = p.indexOf(max);

		while (index != -1) {
			index = p.indexOf(max);
			indexes(p, indexList, index);
		}
		return indexList;
	}

	private static void indexes(List<Integer> p, List<Integer> index, int current) {
		if (current != -1) {
			index.add(current);
			p.set(current, 0);
		}
	}
}