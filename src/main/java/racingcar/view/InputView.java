package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.utils.InputValidator;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        List<String> carNames = Arrays.asList(input.split(","));
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public static int getRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        InputValidator.verifyRounds(input);
        return Integer.parseInt(input);
    }
}
