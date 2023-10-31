package racingcar.view;

import racingcar.RandomCar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {


    public void printWinnerList(List<RandomCar> winnerCars) {
        String format = ("최종 우승자 : ");

        String winners = winnerCars.stream()
                .map(RandomCar::getName)
                .collect(Collectors.joining(", "));

        System.out.println(format + winners);
    }
}
