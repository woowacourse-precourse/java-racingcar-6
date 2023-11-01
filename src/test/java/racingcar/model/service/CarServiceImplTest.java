package racingcar.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Car;
import racingcar.model.dao.CarDao;
import racingcar.model.dao.CarDaoImpl;

class CarServiceImplTest {
    CarService carService = CarServiceImpl.getInstance();
    CarDao carDao = CarDaoImpl.getInstance();

    @BeforeEach
    void setUp() {
        carService.registerCarLineUp("pobi,woni,jun");
        carDao.increaseMoveCount("pobi");
        carDao.increaseMoveCount("jun");
    }

    @DisplayName("우승자 이름 리스트를 반환한다.")
    @Test
    void selectWinnerNames() {
        assertThat(carService.selectWinnerNames())
                .containsExactly("pobi", "jun");
    }
}