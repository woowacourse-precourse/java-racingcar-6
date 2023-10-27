package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.validation.ValidatorCars;


public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    ValidatorCars validator = new ValidatorCars();

    public void createAndAddCars(String[] names) {
        for (String name : names) {
            validator.isValid(name);
            cars.add(new Car(name));
        }
    }

    public void startGame() {
        int round = 0;
        System.out.println("\n실행결과");
        do {
            playRound();
            round++;
        } while (round < Settings.ATTEMPT_COUNT);
        System.out.printf("최종 우승자 : %s\n", getWinners());
    }

    private void playRound() {
        for (Car car : cars) {
            car.tryMove();
            String name = car.getName();
            String position = "-".repeat(car.getMoves());

            System.out.printf("%s : %s\n", name, position);
        }
        System.out.println();
    }

    private String getWinners() {
        StringBuilder winners = new StringBuilder();
        int biggest = biggestMoves();

        for (Car car : cars) {
            if (car.getMoves() == biggest) {
                winners.append(car.getName());
                winners.append(", ");
            }
        }
        cutStringEnd(winners);
        return winners.toString();
    }

    private int biggestMoves() {
        int biggest = 0;

        for (Car car : cars) {
            if (biggest < car.getMoves()) {
                biggest = car.getMoves();
            }
        }
        return biggest;
    }

    private void cutStringEnd(StringBuilder winners) {
        int length = winners.length();
        winners.delete(length - 2, length);
    }

}
