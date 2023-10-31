package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerPicker {

    //TODO 이 부분 수정이 필요해보임. 디미터 법칙 위반
    public Winners pickWinner(Cars cars) {
        ForwardDistance winnerDistance = cars.getMaxForwardDistance();

        List<String> winnerNames = cars.getCars().stream()
                .filter(racingCar -> racingCar.getForwardDistance().equals(winnerDistance))
                .map(car -> car.getName().getName())
                .collect(Collectors.toList());

        CarNames winnersName = new CarNames(winnerNames);
        return new Winners(winnersName);
    }
}
