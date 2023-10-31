package racingcar.control;

import racingcar.domain.Car;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameProcess {
    private final ArrayList<Car> cars = new ArrayList<>();
    private int raceTime;
    public void inputName() {
        String line = readLine();
        makeCars(splitNames(line));
    }

    private String[] splitNames(String line) {
        String[] names = line.split(",");
        for (String name: names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 5자로 입력해주세요.");
            }
        }
        return names;
    }

    private void makeCars(String[] names) {
        for (String name: names) {
            cars.add(new Car(name));
        }
    }

    public void inputRaceTime() {
        String line = readLine();
        try {
            this.raceTime = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void playingGame() {
        for (int i = 0; i < this.raceTime; i++) {
            controlCars();
            System.out.println();
        }
    }

    private void controlCars() {
        for (Car car: this.cars) {
            goOrNot(car);
            System.out.println(car.toString());
        }
    }

    private void goOrNot(Car car) {
        if (pickNumberInRange(0, 9) > 3) {
            car.moveForward();
        }
    }

}
