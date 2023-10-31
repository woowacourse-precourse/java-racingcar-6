package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.LimitScoreMoveRule;
import racingcar.domain.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {
    private Cars cars;
    private CarService service;

    @BeforeEach
    public void initService() {
        cars = new Cars(List.of(new Car("가"), new Car("나"), new Car("다")));
        service = new CarService(cars, new LimitScoreMoveRule(new RandomNumberGenerator()));
    }

    @RepeatedTest(10)
    @DisplayName("1회 테스트 시 모든 점수가 0 ~ 1 사이에서 나와야한다.")
    void 자동차_랜덤_경주_1회() {
        //given
        service.moveAllCarByRandom();
        //when
        List<Integer> list = cars.cars().stream().map(e -> (int) e.getDistance()).toList();
        //then
        assertThat(list.stream().allMatch(e -> 0 <= e && e <= 1)).isTrue();
    }

    @RepeatedTest(5)
    @DisplayName("10회 테스트 시 모든 점수가 0 ~ 10 사이에서 나와야한다.")
    void 자동차_랜덤_경주_10회() {
        //given,when
        for (int i = 0; i < 10; i++) {
            service.moveAllCarByRandom();
        }
        List<Integer> list = cars.cars().stream().map(e -> (int) e.getDistance()).toList();
        if (list.isEmpty()) {
            Assertions.fail();
        }
        //then
        assertThat(list).allMatch(e -> 0 <= e && e <= 10);
    }
}