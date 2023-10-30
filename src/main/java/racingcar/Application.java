package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        racingGame();
    }

    private static void racingGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<Car> cars = parsingCarNames(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryCount = Console.readLine();
        int tryCount = parsingTryCount(inputTryCount);
    }

    private static List<Car> parsingCarNames(String inputCarNames) {
        String[] splitNames = inputCarNames.split(",");
        Validate.carNames(splitNames);
        return Arrays.stream(splitNames).map(Car::new).toList();
    }

    private static int parsingTryCount(String inputTryCount) {
        //TODO: tryCount 기능 구현 및 validator class 구현
        return 0;
    }
}
