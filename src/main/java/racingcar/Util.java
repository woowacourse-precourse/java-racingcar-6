package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


public class Util {

	public static int getMax(List<Integer> integers) {
		return Collections.max(integers);
	}

	public static List<String> toList(String carsString) {
		return Arrays.asList(carsString.split(Constants.DELIMITER));
	}

	public static int getRandomNum() {
		return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
	}

	public static String repeatDash(int num) {
		StringBuilder dashes = new StringBuilder();
		IntStream.range(0, num).forEach(i -> dashes.append(Constants.DASH));
		return dashes.toString();
	}
}
