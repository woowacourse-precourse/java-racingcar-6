package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InfoMessage;
import racingcar.validation.InputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final static String CAR_NAME_SEPARATOR = ",";

    private InputView() {
    }

    public static List<String> inputCarName() {
        try {
            System.out.println(InfoMessage.CAR_NAME_INPUT_MESSAGE.getMessage());
            String carName = Console.readLine();
            InputValidation inputValidation = new InputValidation();
            inputValidation.carNameValidation(carName);
            return Arrays.stream(carName.split(CAR_NAME_SEPARATOR))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputRound() {
        try {
            System.out.println(InfoMessage.ROUND_INPUT_MESSAGE.getMessage());
            String inputRound = Console.readLine();
            int round = Integer.parseInt(inputRound);
            InputValidation inputValidation = new InputValidation();
            inputValidation.roundValidation(round);
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }


}
