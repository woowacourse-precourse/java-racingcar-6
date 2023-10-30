package racingcar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = askCarNames();
        Integer attemptNumber = askAttemptNumber();
    }

    public static List<String> askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(readLine().split(","))
                .map(Application::isValidCarName)
                .toList();
    }

    public static String isValidCarName(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        return carName;
    }

    public static Integer askAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String trialNumber = readLine();
        isValidAttemptNumber();
        return Integer.parseInt(trialNumber);
    }

    public static void isValidAttemptNumber() {
    }

}
