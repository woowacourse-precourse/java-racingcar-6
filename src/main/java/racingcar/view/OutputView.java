package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Referee;
import racingcar.util.Converter;

public class OutputView {
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public void play(List<Car> cars, int count) {
        System.out.println(GAME_RESULT);
        for (int i = 0; i < count; i++) {
            cars.forEach(Car::forward);
            printResult(cars);
            System.out.println();
        }
    }

    public void printWinner(List<Car> cars) {
        List<Car> winners = Referee.getWinner(cars);
        System.out.print(WINNER);
        System.out.println(Converter.carListToString(winners));
    }

    private void printResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPoint())));
    }
}
