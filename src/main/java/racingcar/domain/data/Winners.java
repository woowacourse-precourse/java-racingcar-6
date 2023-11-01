package racingcar.domain.data;

import racingcar.domain.data.CarName;
import racingcar.domain.data.CarNames;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final CarNames winnersName;

    public Winners(final CarNames winnerName) {
        this.winnersName = winnerName;
    }

    public CarNames getWinnersName() {
        return winnersName;
    }

    @Override
    public String toString() {
        List<String> winnerNames = winnersName.getCarNames().stream()
                .map(CarName::toString)
                .collect(Collectors.toList());

        return "최종 우승자 : " + String.join(", ", winnerNames);
    }
}
