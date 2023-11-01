package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    private ArrayList<Car> racingCars = new ArrayList<>();

    private String[] nameValidation(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("Too long name");
            }
        }
        return names;
    }

    public String[] nameInput() {
        String[] names = Console.readLine().split(",");

        return nameValidation(names);
    }

    public int tryCountInput() {
        return Integer.parseInt(Console.readLine());
    }

    public void createRacingCars(String[] names) {
        for (String name : names) {
            this.racingCars.add(new Car(name));
        }
    }

    public void executeTrial() {
        for (Car car : this.racingCars) {
            car.determineCanGo();
            car.updateDistance();
        }
    }

    public void displayResult() {
        for (Car car : this.racingCars) {
            System.out.printf("%s : %s\n",car.getName(),car.getDistance());
        }
        System.out.print("\n");
    }

    public String getWinners() {
        int maxDistance = 0;
        StringBuilder winners = new StringBuilder();

        for (Car car : racingCars) {
            if (car.getDistance().length() > maxDistance) {
                maxDistance = car.getDistance().length();
            }
        }

        for (Car car : racingCars) {
            if (car.getDistance().length() == maxDistance) {
                winners.append(car.getName());
                winners.append(", ");
            }
        }

        return winners.substring(0, winners.length()-2);
    }

}
