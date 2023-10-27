package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;


public class Util {

	public static ArrayList<String> strToList(String carsString) {
		return new ArrayList<>(Arrays.asList(carsString.split(Constants.DELIMITER)));
	}
	public static int getRandomNum() {
		return Randoms.pickNumberInRange(0, 9);
	}
}
