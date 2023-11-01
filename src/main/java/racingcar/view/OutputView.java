package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private final String GAME_RESULT = "실행 결과";
    private final String POSITION_SYMBOL = "-";
    private final String WINNERS_NAME = "최종 우승자 :";

    public void printGameResultMsg() {
        System.out.println();
        System.out.println(GAME_RESULT);
    }

    public void printCarsPosition(List<Car> cars) {
        cars.stream()
                .forEach(car -> System.out.println(car.getName() + " : "
                        + POSITION_SYMBOL.repeat(car.getPosition())));
        System.out.println();
    }

    public void printWinnersName(List<Car> winners) {
        StringBuilder winnersName = new StringBuilder(WINNERS_NAME);

        winners.stream()
                .map(Car::getName)
                .forEach(name -> winnersName.append(" ").append(name).append(","));

        winnersName.deleteCharAt(winnersName.length() - 1); // 마지막에 들어가는 쉼표 제거

        System.out.print(winnersName.toString());
    }
}
