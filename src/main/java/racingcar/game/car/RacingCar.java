package racingcar.game.car;

import racingcar.game.car.engin.CarEngine;
import racingcar.game.enums.CarMove;

public class RacingCar {
    private final CarEngine carEngine;
    private final String name;
    private Integer forwardCount;

    public void drive() {
        CarMove carMove = this.carEngine.operateEngine();
        if (carMove.equals(CarMove.MOVING_FORWARD)) {
            this.forwardCount++;
        }
    }

    public static RacingCar createRacingCar(String racingCarName, CarEngine carEngine) {
        return new RacingCar(racingCarName, carEngine);
    }

    public RacingCar(String racingCarName, CarEngine carEngine) {
        this.name = racingCarName;
        this.carEngine = carEngine;
        this.forwardCount = 0;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }

    public String getName(){
       return this.name;
    }
}
