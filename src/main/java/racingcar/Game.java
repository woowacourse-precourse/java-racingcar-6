package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    private final CarUtil carUtil = new CarUtil();

    public void play() {
        List<Car> cars = carUtil.parseCarName(Console.readLine());
        int time = Integer.parseInt(Console.readLine());

        for(int i = 0; i < time; i++) {
            gameProceed(cars);
        }
    }

    public void gameProceed(List<Car> cars) {
        for(Car car : cars) {
            carUtil.process(car);
        }
    }

}
