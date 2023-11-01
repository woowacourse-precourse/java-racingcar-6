package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCount;
import racingcar.model.Car;
import racingcar.model.Cars;

public class InputView {

	public static String inputCarNames() {
        return Console.readLine();
    }

	public static int inputMoveCount() {
		try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("반복 횟수는 자연수여야 합니다.");
        }
    }
}
