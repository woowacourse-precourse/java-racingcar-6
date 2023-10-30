package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static final String CAR_NAME_DELIMIT = ",";
    private List<Car> cars;
    private StringBuilder gameLog;
    private StringBuilder gameWinner;
    private Integer attemptCount;

    public GameManager() {
        this.cars = new ArrayList<>();
        this.gameLog = new StringBuilder();
        this.gameWinner = new StringBuilder();
        this.attemptCount = 0;
    }

    public void readCarNames() {
        String enteredCarNames = Console.readLine();
        String[] carNames = enteredCarNames.split(CAR_NAME_DELIMIT);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

}
