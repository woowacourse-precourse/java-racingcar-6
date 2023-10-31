package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Movable;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    public void InitCars() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.goForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        pobi.goForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        woni.goForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        woni.goForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        jun.goForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        List<Car> carList = Arrays.asList(pobi, woni, jun);
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("최대 거리가 정상적으로 반환되는지 확인")
    public void 최대_거리_확인() throws Exception {
        Method method = Cars.class.getDeclaredMethod("getMaxDistance");
        method.setAccessible(true);

        int maxDistance = (int) method.invoke(cars);

        assertEquals(2, maxDistance);
    }

    @Test
    @DisplayName("우승자가 복수일 경우 반환되는지 확인")
    public void 최대_거리_자동차_반환() throws Exception {
        List<Car> winnerCars = cars.getWinners();

        assertEquals(2, winnerCars.size());
        assertEquals("pobi", winnerCars.get(0).getName());
        assertEquals("woni", winnerCars.get(1).getName());

    }

}
