package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameServiceTest {
    private static GameService gameService = new GameService();

    @Test
    @DisplayName("경주용 자동차 생성 테스트")
    public void createCars() throws Exception {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
        String carNames = cars.stream().map(Car::getName).collect(Collectors.joining(","));

        // when
        List<Car> createdCars = gameService.createCars(carNames);

        // then
        assertThat(createdCars.size()).isEqualTo(cars.size());
        for (int i=0; i<createdCars.size(); i++) {
            assertThat(createdCars.get(i).getName()).isEqualTo(cars.get(i).getName());
        }
    }

    @Test
    @DisplayName("입력한 이름이 너무 긴 경우, IllegalArgumentException Exception 발생 및 프로그램 종료 테스트")
    public void tooLongNameException() throws Exception {
        // given
        String carNames = "car,racing,longName";

        // when / then
        assertThatThrownBy(() -> gameService.createCars(carNames))
                .isInstanceOf(IllegalArgumentException.class);

        /* same code using org.junit.jupiter.api.Assertions.assertThrows()
        assertThrows(IllegalArgumentException.class,
                () -> gameService.createCars(carNames));*/
    }

    @Test
    @DisplayName("입력한 시도 횟수가 숫자가 아닌 경우, IllegalArgumentException Exception 발생 및 프로그램 종료 테스트")
    public void checkAttemptNumber() throws Exception {
        // given
        String attemptNumber = "a";

        // when
        assertThrows(IllegalArgumentException.class,
                () -> gameService.validateAttemptNumber(attemptNumber));

    }

}