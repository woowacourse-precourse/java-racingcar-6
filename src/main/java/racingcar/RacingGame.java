package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    List<Car> cars;

    public RacingGame() {
        this.cars = new ArrayList<Car>();
    }

    public void enterCarName() {
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (int i = 0; i < carNames.length; i++) {
            String carName = carNames[i];
            boolean isValidString = carName instanceof String;
            boolean isValidLength = carName.length() > 0 && carName.length() <= 5;
    
            if (!isValidString || !isValidLength) {
                throw new IllegalArgumentException();
            }

            this.cars.add(new Car(carName, 0));
        }
    }
}
