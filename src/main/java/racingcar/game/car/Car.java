package racingcar.game.car;

import racingcar.game.car.engin.CarEngine;
import racingcar.game.enums.CarMove;

public class Car {
    private final CarEngine carEngine;
    private final String name;
    private Integer forwardCount;

    public Car(String racingCarName, CarEngine carEngine) {
        this.name = racingCarName;
        this.carEngine = carEngine;
        this.forwardCount = 0;
    }

    public void drive() {
        CarMove carMove = this.carEngine.operateEngine();
        if (carMove.equals(CarMove.MOVING_FORWARD)) {
            this.forwardCount++;
        }
    }

    public Integer getForwardCount() {
        return forwardCount;
    }

    public String getName() {
        return this.name;
    }

}
