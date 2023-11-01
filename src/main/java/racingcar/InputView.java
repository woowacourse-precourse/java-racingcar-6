package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String ASK_ROUND = "시도할 회수는 몇회인가요?";

    public static List<Car> inputCarsInfo() {
        printAskCarNames();
        return getCarNames();
    }

    private static void printAskCarNames() {
        System.out.println(ASK_CAR_NAMES);
    }

    public static List<Car> getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(CAR_NAMES_DELIMITER);

        for (String carName : carNames) {
            Validator.validateCarName(carName);
        }
        Validator.validateDuplicate(carNames);

        return TypeConverter.convertStringArrayToCarList(carNames);
    }

    public static int inputRound() {
        printAskRound();
        return getRound();
    }

    private static void printAskRound() {
        System.out.println(ASK_ROUND);
    }

    public static int getRound() {
        String input = Console.readLine();
        return Validator.validateRound(input);
    }
}
