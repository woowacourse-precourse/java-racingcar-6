package racingcar.view;

import java.util.List;
import racingcar.InputReader;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputReader inputReader = new InputReader();

    public List<String> readCarName() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        return inputReader.racingCar();
    }

    public String readRaceRound() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        return inputReader.raceRound();
    }
}
