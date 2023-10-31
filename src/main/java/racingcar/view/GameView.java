package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
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

    public static void printCarNames(List<Car> cars) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.carName());
        }
        String joinedName = String.join(" ", carNames);
        System.out.print(joinedName);
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

//    public static void printWinMessage() {
//        System.out.println("최종 우승자 : " + String.join(", " + winUser));
//    }

}
