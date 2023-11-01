package racingcar.model.dao;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Car;

class CarDaoImplTest {
    CarDao carDao = CarDaoImpl.getInstance();

    @BeforeEach
    void setUp() {
        carDao.init();
        carDao.insertCar(new Car("pobi"));
        carDao.insertCar(new Car("woni"));
        carDao.insertCar(new Car("jun"));
    }

    @DisplayName("woni의 이동 횟수를 1증가시킨다.")
    @Test
    void increaseMoveCount() {
        carDao.increaseMoveCount("woni");

        for (Car car : carDao.selectAllCars()) {
            if (car.getName().equals("woni")) {
                assertThat(car.getMoveCount()).isEqualTo(1);
            } else {
                assertThat(car.getMoveCount()).isEqualTo(0);
            }
        }
    }

    @DisplayName("가장 큰 전진 횟수(moveCount)를 반환한다.")
    @Test
    void selectTopMoveCount() {
        for (int i = 0; i < 10; i++) {
            carDao.increaseMoveCount("pobi");
            if (i < 8) {
                carDao.increaseMoveCount("woni");
            }
            if (i < 3) {
                carDao.increaseMoveCount("jun");
            }
        }

        assertThat(carDao.getTopMoveCount())
                .isEqualTo(10);

    }

    @DisplayName("전진 횟수와 일치하는 Car 리스트를 반환한다.")
    @Test
    void selectCarsByMoveCount() {
        int moveCount = 5;
        for (int i = 0; i < moveCount; i++) {
            carDao.increaseMoveCount("woni");
            carDao.increaseMoveCount("jun");
        }

        assertThat(carDao.selectCarsByMoveCount(moveCount).size())
                .isEqualTo(2);
    }
}