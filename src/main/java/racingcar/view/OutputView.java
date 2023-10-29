package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    public void showResult() {
        System.out.println("\n실행 결과");
    }
    public void showPosition(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + makeDelimiter(car.getPosition()));
        }
        System.out.println();
    }

    private String makeDelimiter(int position) {
        return "-".repeat(position);
    }

    public void showWinner(List<String> winner) {
        String winnerName = String.join(", ", winner);
        System.out.print("최종 우승자 : " + winnerName);
    }
}
