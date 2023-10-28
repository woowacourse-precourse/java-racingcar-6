package racingcar.view;

import racingcar.domain.enums.InterfaceMsg;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
	private InputView() {
	}

	private static class InputViewHolder {
		private static final InputView INPUT_VIEW = new InputView();
	}

	public static InputView getInstance() {
		return InputViewHolder.INPUT_VIEW;
	}

	// 자동차 레이싱 게임 안내
	public void printGameRuleInfo() {
		System.out.println(InterfaceMsg.GAME_INFO.getValue());
	}

	// Player로부터 자동차 이름들을 입력받음
	public String requestInputCarName() {
		System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue());
		String inputCarName = readLine();
		System.out.println(inputCarName);

		return inputCarName;
	}

	// Player로부터 자동차 경주의 회수를 입력받음
	public String requestInputCarRaceTimes() {
		System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue());
		String inputCarRaceTimes = readLine();
		System.out.println(inputCarRaceTimes);

		return inputCarRaceTimes;
	}
}
