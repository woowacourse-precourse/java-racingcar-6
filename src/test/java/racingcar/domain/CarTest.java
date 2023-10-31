package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.Names;

public class CarTest {
    private List<Car> cars;
    private MoveStrategy moveStrategy;

    @BeforeEach
    public void setUp() {
        Names names = Names.of(new String[]{"hyunjin", "pobi", "lefthand"});
        cars = Car.createCarList(names);
        moveStrategy = Mockito.mock(MoveStrategy.class);
    }

    @Test
    public void 자동차_목록_생성_확인() {
        Assertions.assertEquals(3, cars.size());
    }

    @Test
    public void 이름_조회() {
        //given
        String name = cars.get(0).getName();

        //when & then
        Assertions.assertEquals(name, "hyunjin");
    }

    @Test
    public void 이동_테스트() {
        //given
        Mockito.when(moveStrategy.isMovable()).thenReturn(true);

        //when
        Car car = cars.get(0);
        car.move(moveStrategy);

        //then
        Assertions.assertEquals(1, car.getDistance());
    }

    @Test
    public void 이동_불가능_테스트() {
        //given
        Mockito.when(moveStrategy.isMovable()).thenReturn(false);

        //when
        Car car = cars.get(0);
        car.move(moveStrategy);

        //then
        Assertions.assertEquals(0, car.getDistance());
    }

    @Test
    public void 우승자와_점수가_같은_경우() {
        //given
        Car car = cars.get(0);
        Mockito.when(moveStrategy.isMovable()).thenReturn(true);

        //when
        car.move(moveStrategy);

        //then
        Assertions.assertTrue(car.isWinner(1));
    }

    @Test
    public void 우승자와_점수보다_점수가_작은_경우() {
        //given
        Car car = cars.get(0);
        Mockito.when(moveStrategy.isMovable()).thenReturn(false);

        //when
        car.move(moveStrategy);

        //then
        Assertions.assertFalse(car.isWinner(1));
    }
}
