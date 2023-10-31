package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;

public class CarView {
    public void printRaceResult(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printWinners(ArrayList<Car> winners) {
        ArrayList<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.getName());
        }
        System.out.println("The winners: " + String.join(", ", winnerNames));
    }
}
