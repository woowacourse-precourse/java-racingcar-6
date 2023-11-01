package racingcar.domain;

import racingcar.domain.data.Car;
import racingcar.domain.data.CarNames;
import racingcar.domain.data.Cars;
import racingcar.domain.data.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerPicker {

    public Winners pickWinner(Cars cars) {
        int winnerDistance = cars.getMaxForwardDistance();

        List<String> winnerNames = cars.getCars().stream()
                .filter(racingCar -> racingCar.getForwardDistance() == winnerDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        CarNames winnersName = new CarNames(winnerNames);
        return new Winners(winnersName);
    }
}
