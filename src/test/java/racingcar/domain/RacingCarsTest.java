package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.Names;

public class RacingCarsTest {
    private List<Car> carList;
    private MoveStrategy moveStrategy;

    @BeforeEach
    public void setUp() {
        Names names = Names.of(new String[]{"hyunjin", "pobi", "lefthand"});
        carList = Car.createCarList(names);
        moveStrategy = Mockito.mock(MoveStrategy.class);
    }

    @Test
    public void 모든_차들에_대한_이동진행() {
        //given, 모든 차가 이동할 수 있는 상태로 설정
        Mockito.when(moveStrategy.isMovable()).thenReturn(true);

        //when
        RacingCars racingCars = RacingCars.of(carList, moveStrategy);
        racingCars.move();

        //then,  모든 차가 1칸 이동했는지 검증
        for (Car car : racingCars.cars()) {
            Assertions.assertEquals(1, car.getDistance());
        }
    }

    @Test
    public void 모든_차들의_이동불가() {
        //given, 모든 차가 이동할 수 없는 상태로 설정
        Mockito.when(moveStrategy.isMovable()).thenReturn(false);

        //when
        RacingCars racingCars = RacingCars.of(carList, moveStrategy);
        racingCars.move();

        //then,  모든 차가 이동하지 않았는지 검증
        for (Car car : racingCars.cars()) {
            Assertions.assertEquals(0, car.getDistance());
        }
    }
}
