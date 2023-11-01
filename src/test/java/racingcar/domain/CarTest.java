package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Names;

public class CarTest {
    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        // given: Car 객체들을 초기화
        Names names = Names.of(new String[]{"hyunjin", "pobi", "lefthand"});
        cars = Car.createCarList(names);
    }

    @Test
    public void 자동차_목록_생성_확인() {
        // then
        Assertions.assertEquals(3, cars.size());
    }

    @Test
    public void 이름_조회() {
        // when
        String name = cars.get(0).getName();

        // then
        Assertions.assertEquals("hyunjin", name);
    }

    @Test
    public void 이동_테스트() {
        // given: 첫 번째 자동차를 선택
        Car car = cars.get(0);

        // when: 자동차를 움직임
        car.move(() -> true);

        // then: 이동 거리가 1인지 확인
        Assertions.assertEquals(1, car.getDistance());
    }

    @Test
    public void 이동_불가능_테스트() {
        // given, 첫 번째 자동차를 선택
        Car car = cars.get(0);

        // when, 자동차를 움직이지 않음
        car.move(() -> false);

        // then, 이동 거리가 0인지 확인
        Assertions.assertEquals(0, car.getDistance());
    }
}
