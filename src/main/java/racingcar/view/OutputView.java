package racingcar.view;

import racingcar.domain.RandomCar;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.ConsoleMessage.FINALLY_WINNER_LIST;

public class OutputView {

    public void printWinnerList(List<RandomCar> winnerCars) {
        String winners = winnerCars.stream()
                .map(RandomCar::getName)
                .collect(Collectors.joining(", "));

        String output = String.format(FINALLY_WINNER_LIST, winners);
        System.out.println(output);
    }

    public void printCarsPosition(List<RandomCar> randomCars) {
        for (RandomCar car : randomCars) {
            String visualPosition = drawPosition(car);

            String output = String.format("%5s : %s", car.getName(), visualPosition);
            System.out.println(output);
        }

        System.out.println();
    }

    private String drawPosition (RandomCar car) {
        StringBuilder position = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            position.append("-");
        }

        return position.toString();
    }
}
