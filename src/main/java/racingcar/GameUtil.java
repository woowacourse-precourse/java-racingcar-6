package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GameUtil {
    private Integer repeatNumber;
    private ArrayList<Car> cars;

    public GameUtil() {
        this.repeatNumber = 0;
        this.cars = new ArrayList<>();
    }

    public void runGame() {
        receiveCarsName();
    }

    public void receiveCarsName() {
        System.out.println(Constants.CAR_NAME_INPUT_COMMENT);
        String[] carNames = validateAndSplitCarNames(Console.readLine());

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private String[] validateAndSplitCarNames(String inputNames) {
        String[] carNames = inputNames.split(",");

        for (String name : carNames) {
            if (name.length() > Constants.CAR_NAME_MAXIMUM) {
                throw new IllegalArgumentException();
            }
        }

        return carNames;
    }
}
