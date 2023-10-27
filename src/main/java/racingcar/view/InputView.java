package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputView() { }

    public static void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static void printInputRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public static List<String> inputCarName() {
        try {
            String carName = Console.readLine();
            InputValidation inputValidation = new InputValidation();
            inputValidation.carNameValidation(carName);
            return Arrays.stream(carName.split(","))
                                        .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }


}
