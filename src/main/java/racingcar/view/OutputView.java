package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printCarsPosition(Car car) {
        System.out.println(car.getName() + " : " + car.getPosition());
    }

    public static void printWinnerList(List<Car> winnerList) {

        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            Car car = winnerList.get(i);
            sb.append(car.getName());
            if (i < winnerList.size() - 1) {
                sb.append(", ");
            }
        }

        System.out.print(sb);
    }
}
