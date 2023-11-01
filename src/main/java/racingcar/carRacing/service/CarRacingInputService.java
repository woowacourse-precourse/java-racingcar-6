package racingcar.carRacing.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.validation.Validation.areLessThenSixLetters;
import static racingcar.validation.Validation.containDuplicateCarName;
import static racingcar.validation.Validation.isValidRange;

import java.util.List;

public class CarRacingInputService {

    public List<String> inputCarNameList() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = readLine();
        List<String> carNames = List.of(carNameString.split(","));

        areLessThenSixLetters(carNames);
        containDuplicateCarName(carNames);
        return carNames;
    }

    public Integer inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String attemptCountString = readLine();
        Integer attemptCount;

        try {
            attemptCount = Integer.parseInt(attemptCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("attempt count must be numeric.");
        }
        isValidRange(attemptCount);
        return attemptCount;
    }

}
