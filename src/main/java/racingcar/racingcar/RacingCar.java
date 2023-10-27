package racingcar.racingcar;

import java.util.List;

/**
 * @author 민경수
 * @description racing car
 * @since 2023.10.27
 **********************************************************************************************************************/
public class RacingCar {

    private final List<Car> cars;
    private Integer moveCount;

    public RacingCar(List<Car> cars, Integer moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

}