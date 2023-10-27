package racingcar.game.car;

import racingcar.game.car.engin.CarEngine;
import racingcar.game.enums.CarMove;

public class RacingCar {
    private final CarEngine carEngine;
    private Integer forwardCount;

    public void drive() {
        CarMove carMove = this.carEngine.operateEngine();
        if (carMove.equals(CarMove.MOVING_FORWARD)) {
            this.forwardCount++;
        }
    }

    public static RacingCar createRacingCar(CarEngine carEngine) {
        return new RacingCar(carEngine);
    }

    public RacingCar(CarEngine carEngine) {
        this.carEngine = carEngine;
        this.forwardCount = 0;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }
}
