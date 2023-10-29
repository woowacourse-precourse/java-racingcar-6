package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static List<String> carNames = new ArrayList<>();
    private static int carMovingCount;
    private static List<Integer> carMovings = new ArrayList<>();

    private static void displayStartText() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    private static void inputCarNames() {
        String carName = Console.readLine();
        carNames = Arrays.asList(carName.split(","));
    }

    private static void isNameLengthOverFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void inputCarMovingCount() {
        carMovingCount = Integer.parseInt(Console.readLine());
    }

    private static int randomPickingNumberZeroToNine() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static int decideGoAndStop() {
        if (randomPickingNumberZeroToNine() >= 4) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        displayStartText();

        inputCarMovingCount();

        inputCarNames();
        for (int i = 0; i < carNames.size(); i++) {
            isNameLengthOverFive(carNames.get(i));
        }

        for (int i = 0; i < carNames.size(); i++) {
            carMovings.add(0);
        }
    }
}
