package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RoundTest {
    private Round round;

    @BeforeEach
    void setUp() {
        round = new Round();
    }

    @DisplayName("차 이름들로 차 객체들이 생성되나 확인한다.")
    @Test
    void 차_객체들_생성하기() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("aaa");
        carNames.add("bbb");
        carNames.add("ccc");

        // when
        round.generateCars(carNames);

        // then
        List<Car> cars = round.getCars();
        assertEquals(3, cars.size());

        assertEquals("aaa", cars.get(0).getName());
        assertEquals("bbb", cars.get(1).getName());
        assertEquals("ccc", cars.get(2).getName());
    }

    @DisplayName("한 라운드를 진행하며 차마다 위치변화가 있는지 확인한다.")
    @Test
    void 한_라운드_진행_후_위치변화_확인() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("aaa");
        carNames.add("bbb");
        carNames.add("ccc");
        round.generateCars(carNames);

        List<Car> cars = round.getCars();

        // when
        cars.forEach(car -> {
            int originalCnt = car.getMoveCnt();
            int randomNumber = car.generateNumber();
            car.moveForward(randomNumber);

            // then
            int newCnt = car.getMoveCnt();
            if (car.isMove(randomNumber)) {
                assertEquals(originalCnt + 1, newCnt);
            } else {
                assertEquals(originalCnt, newCnt);

            }
        });
    }
}