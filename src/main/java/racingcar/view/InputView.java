package racingcar.view;

import static racingcar.exception.ExceptionMessage.INPUT_IS_NOT_DIGIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.dto.request.CarNameDto;
import racingcar.controller.dto.request.RaceCountDto;
import racingcar.util.DigitValidator;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String SPLIT_CAR_NAMES_DELIMITER = ",";


    public CarNameDto readCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        List<String> carNameList = splitStringByComma(carNames);

        return new CarNameDto(carNameList);
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

    private List<String> splitStringByComma(String carNames) {
        return Arrays.stream(carNames.split(SPLIT_CAR_NAMES_DELIMITER)).map(String::trim).collect(Collectors.toList());
    }
}
