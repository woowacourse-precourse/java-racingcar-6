package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class GameView {

    public static String printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String printTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static void printCarNames(List<Car> carList) {
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            carNames.add(car.carName());
        }
        String joinedName = String.join(" ", carNames);
        System.out.println(joinedName);
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarStatus(Car car, int count) {
        System.out.println(car + " : " + "-".repeat(count));
    }

    public static void printWinMessage(List<Car> carList) {List<String> winnerNames = carList.stream()
            .map(Car::carName)
            .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}

