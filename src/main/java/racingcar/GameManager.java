package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarList;
import racingcar.domain.CarListFactory;

public class GameManager {

    private final CarListFactory carListFactory;

    public GameManager(CarListFactory carListFactory) {
        this.carListFactory = carListFactory;
    }

    public void play() {
        String input = Console.readLine();
        CarList carList = carListFactory.create(input);
    }
}
