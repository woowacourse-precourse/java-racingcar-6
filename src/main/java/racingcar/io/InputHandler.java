package racingcar.io;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        validateCarNames(input);


        return input.split(",");
    }

    private static void validateCarNames(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public static int getRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

}
