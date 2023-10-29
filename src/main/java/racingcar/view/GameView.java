package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.validate.UserInputValidation;

import java.util.Arrays;
import java.util.List;

public class GameView {
    private final static String COMMA = ",";

    public List<String> getCarNames(final UserInputValidation<List<String>> userInputValidation) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        List<String> carNames = Arrays.stream(userInput.split(COMMA)).toList();

        if (!userInputValidation.validate(carNames)) throw new IllegalArgumentException();
        return carNames;
    }

    public int getRoundNumber(final UserInputValidation<String> userInputValidation) {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();

        if (!userInputValidation.validate(userInput)) throw new IllegalArgumentException();
        return Integer.parseInt(userInput);
    }

}
