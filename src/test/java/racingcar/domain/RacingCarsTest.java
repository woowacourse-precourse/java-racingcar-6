package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Names;

public class RacingCarsTest {
    private List<Car> carList;

    @BeforeEach
    public void setUp() {
        // given: Car 객체들을 초기화
        Names names = Names.of(new String[]{"hyunjin", "pobi", "lefthand"});
        carList = Car.createCarList(names);
    }

    @Test
    public void 모든_차들에_대한_이동진행() {
        // given, 모든 차가 이동할 수 없는 상태로 설정,  이동 전략을 true를 반환하는 람다로 설정
        RacingCars racingCars = RacingCars.of(carList, () -> true);

        // when: 모든 차량을 이동
        racingCars.move();

        // then: 모든 차가 1칸 이동했는지 검증
        for (Car car : racingCars.cars()) {
            Assertions.assertEquals(1, car.getDistance());
        }
    }

    @Test
    public void 모든_차들의_이동불가() {
        // given, 모든 차가 이동할 수 없는 상태로 설정,  이동 전략을 false를 반환하는 람다로 설정
        RacingCars racingCars = RacingCars.of(carList, () -> false);

        // when, 모든 차량을 이동
        racingCars.move();

        // then, 모든 차가 이동하지 않았는지 검증
        for (Car car : racingCars.cars()) {
            Assertions.assertEquals(0, car.getDistance());
        }
    }
}
