package racingcar.view;

import static racingcar.exception.ExceptionMessage.INPUT_IS_NOT_DIGIT;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.dto.request.CarNameDto;
import racingcar.controller.dto.request.RaceCountDto;
import racingcar.util.DigitValidator;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";


    public CarNameDto readCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carName = Console.readLine();

        return new CarNameDto(carName);
    }

    public RaceCountDto readRaceCount() {
        System.out.println(INPUT_RACE_COUNT_MESSAGE);
        String rawRaceCount = Console.readLine();
        validateRaceCount(rawRaceCount);

        int raceCount = Integer.parseInt(rawRaceCount);

        return new RaceCountDto(raceCount);
    }

    private void validateRaceCount(String rawRaceCount) {
        if (!DigitValidator.isInteger(rawRaceCount)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_DIGIT);
        }
    }
}
