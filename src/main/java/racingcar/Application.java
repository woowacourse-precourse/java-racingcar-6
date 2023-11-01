package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessagePrinter.askCarName();
        List<String> carNames = splitNames(getCarNames());
        MessagePrinter.askTryNumber();

        int tryNumber = getTryNumber();

        Cars cars = new Cars(carNames);

        RacingCarGame racingCarGame = new RacingCarGame(cars, tryNumber);
        racingCarGame.play();

    }

    public static String getCarNames() {
        return Console.readLine();
    }

    public static List<String> splitNames(String names) {
        List<String> name = Arrays.asList(names.split(","));
        InputValidator.validateName(name);
        return name;
    }

    public static int getTryNumber() {
        String input = Console.readLine();
        InputValidator.validateTryNumber(input);
        return Integer.parseInt(input);
    }

}
