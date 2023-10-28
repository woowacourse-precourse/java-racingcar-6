package racingcar.game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.game.car.RacingCar;

public class Rule {
    private static final String RACE_SITUATION = "-";

    public String countToHyphen(RacingCar racingCar) {
        StringBuilder stringBuffer = new StringBuilder();
        Integer roundPoint = racingCar.getForwardCount();
        stringBuffer.append(RACE_SITUATION.repeat(Math.max(0, roundPoint)));
        return String.valueOf(stringBuffer);
    }

    public List<RacingCar> callWinners(List<RacingCar> racingCarList) {
        int maxForwardCount = racingCarList.stream()
                .mapToInt(RacingCar::getForwardCount)
                .max()
                .orElseThrow();

        List<RacingCar> winnerList = racingCarList
                .stream().filter(car -> car.getForwardCount() == maxForwardCount)
                .collect(Collectors.toList());
        return winnerList;
    }

}
