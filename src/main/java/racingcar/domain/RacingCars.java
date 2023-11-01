package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.common.strategy.MoveStrategy;

/**
 * 레이싱 게임에서 차량들을 관리하는 클래스
 */
public final class RacingCars {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    // private 생성자
    private RacingCars(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = Collections.unmodifiableList(cars);
        this.moveStrategy = moveStrategy;
    }

    //RacingCars 객체를 생성하여 반환
    public static RacingCars of(List<Car> carList, MoveStrategy moveStrategy) {
        return new RacingCars(carList, moveStrategy);
    }

    // 모든 차량을 움직임
    public void move() {
        cars.forEach(car -> car.move(moveStrategy));
    }

    // 현재 차량 목록을 반환
    public List<Car> cars() {
        return cars;
    }
}
