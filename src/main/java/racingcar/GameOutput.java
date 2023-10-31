package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameOutput {

    public void printRoundResult(List<Car> carList) {
        String roundResult = carList.stream().
                map(car -> car + " : " + GameUtils.numToHyphen(car.getMovingCount())).
                collect(Collectors.joining("\n"));

        System.out.println(roundResult + "\n");
    }

    public void printWinners(List<Car> winnerList) {
        String winners = winnerList.stream()
                .map(Car::toString)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winners);
    }

}
