package racingcar.view;

import racingcar.domain.RandomCar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {


    public void printWinnerList(List<RandomCar> winnerCars) {
        String winners = winnerCars.stream()
                .map(RandomCar::getName)
                .collect(Collectors.joining(", "));

        String output = String.format("최종 우승자 : %s", winners);
        System.out.println(output);
    }

    public void printCarStatus(List<RandomCar> randomCars) {
        for (RandomCar car : randomCars) {
            String output = String.format("%5s : ", car.getName());
            for (int i = 0; i < car.getPosition(); i++) {
                output += "-";
            }
            System.out.println(output);
        }

        System.out.println();
    }
}
