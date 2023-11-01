package racingcar.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingcarModel;

public class CarRacing {
	private int moveCount = 0;
	private String moveShow = "";

	public static List<Integer> playRace(List<String> carNames, int tryTimes) {

		CarRacing[] carObject = new CarRacing[carNames.size()]; // 입력된 자동차 갯수 만큼 객체 생성
		for (int j = 0; j < carNames.size(); j++) {
			carObject[j] = new CarRacing();
		}

		for (int i = 0; i < tryTimes; i++) {
			for (int j = 0; j < carNames.size(); j++) {
				carObject[j].carMove(carNames.get(j));
			}
			System.out.println("");
		}

		for (int j = 0; j < carNames.size(); j++) {
			RacingcarModel.raceResult.add(j, carObject[j].moveCount);
		}
		return RacingcarModel.raceResult;
	}

	public int carMove(String str) {

		String carName = str + " : ";
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (randomNumber >= 4) {
			moveCount++;
			moveShow += "-";
		}
		System.out.println(carName + moveShow);
		return moveCount;
	}
}
