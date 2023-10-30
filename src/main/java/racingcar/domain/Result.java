package racingcar.domain;

import java.util.List;
import racingcar.util.ResultMessage;

public class Result {
    private final List<String> ChampionNames;

    public Result(List<Car> cars) {
        this.ChampionNames = getChampions(cars);
    }

    public int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> getChampions(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    public String getWinners() {
        StringBuilder winners = new StringBuilder();
        winners.append(String.format(ResultMessage.FINAL_WINNER, ChampionNames.get(0)));
        for (int i = 1; i < ChampionNames.size(); i++) {
            winners.append(String.format(ResultMessage.MORE_WINNERS, ChampionNames.get(i)));
        }
        return winners.toString();
    }
}
