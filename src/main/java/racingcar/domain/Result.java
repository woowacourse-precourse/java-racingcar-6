package racingcar.domain;

import java.util.List;

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
        winners.append(String.format("%n최종 우승자 : %s", ChampionNames.get(0)));
        for (int i = 1; i < ChampionNames.size(); i++) {
            winners.append(String.format(", %s", ChampionNames.get(i)));
        }
        return winners.toString();
    }
}
