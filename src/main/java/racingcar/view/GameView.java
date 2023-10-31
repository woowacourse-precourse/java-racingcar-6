package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
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
        for (Car car : cars) {
            System.out.print(car.carName() + " ");
        } // join 사용해서
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

//    public static void printWinMessage() {
//        System.out.println("최종 우승자 : " + String.join(", " + winUser));
//    }

}
