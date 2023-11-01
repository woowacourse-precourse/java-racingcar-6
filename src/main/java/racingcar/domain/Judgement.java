package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
	private static final int STANDARD_NUMBER = 4;

	public static void goStop(GameData data) {
		for (int i = 0; i < data.getNumberList().size(); i++) {
			if (data.getNumberList().get(i) >= STANDARD_NUMBER) {
				data.getPositionList().set(i, (data.getPositionList().get(i) + 1)); // 원래 값에 1 추가
			}
		}
	}

	public void getWinners(GameData data) {
		int maxPosition = getMaxPosition(data.getPositionList());

		for (int i = 0; i < data.getCarList().size(); i++) {
			int position = data.getPositionList().get(i);

			if (position == maxPosition) {
				data.getWinnersList().add(data.getCarList().get(i));
			}
		}

	}

	public int getMaxPosition(List<Integer> list) {
		int maxPosition = -1;
		for (int position : list) {
			if (position > maxPosition) {
				maxPosition = position;
			}
		}
		return maxPosition;
	}

}
