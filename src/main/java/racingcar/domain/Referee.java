package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public List<RandomCar> selectWinners(List<RandomCar> randomCars) {
        int maxPosition = getMaxPosition(randomCars);

        return randomCars.stream()
                .filter(randomCar -> randomCar.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<RandomCar> randomCars) {
        return randomCars.stream()
                .mapToInt(RandomCar::getPosition)
                .max()
                .getAsInt();
    }
}
