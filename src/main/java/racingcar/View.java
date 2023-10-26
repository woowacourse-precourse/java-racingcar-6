package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class View {

    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static List<String> carList;
    private static int attempts;

    static void makeCarList() {
        System.out.println(INPUT_CAR_MESSAGE);
        carList = Arrays.asList(readLine().split(","));
    }

    static void inputAttemptsCount() {
        System.out.println(INPUT_ATTEMPT_MESSAGE);
        attempts = Integer.parseInt(readLine());
    }

    static List<String> getCarList() {
        return carList;
    }

    static int getAttempts() {
        return attempts;
    }
}
