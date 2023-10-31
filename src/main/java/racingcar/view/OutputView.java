package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.dto.GameResultDto;

public class OutputView {

    public void showRoundResult(List<Car> cars) {
        System.out.println(resolveRoundResultMessage(cars));
    }

    public void showGameResult(GameResultDto gameResult) {
        System.out.println(resolveWinnerMessage(gameResult));
    }

    private String resolveWinnerMessage(GameResultDto gameResult) {
        if (gameResult.isSingleWinner()) {
            return "최종 우승자 : " + gameResult.getSingleWinner().getCarName();
        }
        String winnerNames = getWinnerNames(gameResult.getWinners());
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
