package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String CAR_NAME_SEPARATOR = ",";

    private InputView() {
    }

    public static List<String> inputCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carName = Console.readLine();
        return Arrays.stream(carName.split(CAR_NAME_SEPARATOR))
                .collect(Collectors.toList());
    }

    public static int inputRound() {
        try {
            System.out.println(ROUND_INPUT_MESSAGE);
            String inputRound = Console.readLine();
            return Integer.parseInt(inputRound);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
