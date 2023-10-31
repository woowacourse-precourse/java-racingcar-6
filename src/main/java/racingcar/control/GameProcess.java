package racingcar.control;

import racingcar.domain.Car;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
}
