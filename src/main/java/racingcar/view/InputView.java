package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCount;
import racingcar.model.Car;

public class InputView {

	public List<Car> inputCarNames() {
		//자동차 이름 입력
		String nameInput = Console.readLine();
		//쉼표(,) 기준으로 구분
		return Arrays.stream(nameInput.split(",")).map(Car::new).toList();
	}

	public RacingCount inputRacingCount() {
		String input = Console.readLine();
		return new RacingCount(Integer.parseInt(input));
	}
}
