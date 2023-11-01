package racingcar.view;

import java.util.List;
import racingcar.domain.car.Car;

public class OutputView {
    public static void informCarMoveDistance(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            for (int i = 0; i < car.getCarLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void informFinalWinner(List<String> carName) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", carName);
        System.out.println(result);
    }

    public static void informPlayResult() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
