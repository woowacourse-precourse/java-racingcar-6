package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.dto.GameResultDto;

public class MessageResolver {

    public String resolveWinnerMessage(GameResultDto gameResult) {
        if (gameResult.isSingleWinner()) {
            return resolveSingleWinnerMessage(gameResult);
        }
        return resolveMultiWinnerMessage(gameResult);
    }

    public String resolveRoundResultMessage(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getCarName() + " : " + car.getPosition().draw())
                .collect(Collectors.joining("\n")) + "\n";
    }

    private String getWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
    }

    private String resolveMultiWinnerMessage(GameResultDto gameResult) {
        String winnerNames = getWinnerNames(gameResult.getWinners());
        return "최종 우승자 : " + winnerNames;
    }

    private String resolveSingleWinnerMessage(GameResultDto gameResult) {
        return resolveSingleWinnerMessage("최종 우승자 : " + gameResult.getSingleWinner().getCarName());
    }

    private String resolveSingleWinnerMessage(String gameResult) {
        return gameResult;
    }
}
