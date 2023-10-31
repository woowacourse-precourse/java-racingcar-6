package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class OutputView {

    public void showRoundResult(List<Car> cars) {
        System.out.println(resolveRoundResultMessage(cars));
    }

    public void showGameResult(List<Car> winners) {
        System.out.println(resolveWinnerMessage(winners));
    }

    private String resolveWinnerMessage(List<Car> winners) {
        if (isSingleWinner(winners)) {
            return "최종 우승자 : " + winners.get(0).getCarName();
        }
        String winnerNames = getWinnerNames(winners);
        return "최종 우승자 : " + winnerNames;
    }

    private String getWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
    }

    private boolean isSingleWinner(List<Car> winners) {
        return winners.size() == 1;
    }

    private String resolveRoundResultMessage(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getCarName() + " : " + car.getPosition().draw())
                .collect(Collectors.joining("\n")) + "\n";
    }
}
