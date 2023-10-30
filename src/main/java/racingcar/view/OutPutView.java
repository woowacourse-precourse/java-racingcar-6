package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class OutPutView {

    public static void outPutViewResult(Cars cars) {

        resultSystem();

        for (Car car : cars.getCars()) {

            System.out.print(car.getCarName() + " : ");

            int position = car.getPosition();

            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void outPutViewWinners(Cars winners) {

        winnersSystem();
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winners.getCars()) {

            winnerNames.add(winner.getCarName());
        }

        System.out.print(String.join(", ", winnerNames));
    }

    private static void winnersSystem() {
        System.out.print("최종 우승자 : ");
    }

    private static void resultSystem() {
        System.out.println("실행 결과");

    }
}
