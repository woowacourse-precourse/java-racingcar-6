package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름이 5자를 초과합니다.");

        /* same code using org.junit.jupiter.api.Assertions.assertThrows() without checking message
        assertThrows(IllegalArgumentException.class,
                () -> gameService.createCars(carNames));*/
    }

    @Test
    @DisplayName("입력한 시도 횟수가 숫자가 아닌 경우, IllegalArgumentException Exception 발생 및 프로그램 종료 테스트")
    public void checkAttemptNumber() throws Exception {
        // given
        String attemptNumber = "a";

        // when
        assertThatThrownBy(() -> gameService.validateAttemptNumber(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 입력입니다.");
        /*assertThrows(IllegalArgumentException.class,
                () -> gameService.validateAttemptNumber(attemptNumber));*/

    }

    @Test
    @DisplayName("우승자 선별 테스트")
    public void getWinner() throws Exception {
        // given
        List<Car> cars = new ArrayList<>();
        Car webCar = new Car("web");
        cars.add(webCar);
        Car iosCar = new Car("ios");
        cars.add(iosCar);
        Car backCar = new Car("back");
        cars.add(backCar);

        // when
        webCar.moveForward();
        iosCar.moveForward();
        iosCar.moveForward();
        backCar.moveForward();

        // then
        List<Car> winners = gameService.getWinners(cars);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo(iosCar.getName());

    }

    @Test
    @DisplayName("공동 우승자 선별 테스트")
    public void getCoWinner() throws Exception {
        // given
        List<Car> cars = new ArrayList<>();
        Car webCar = new Car("web");
        cars.add(webCar);
        Car iosCar = new Car("ios");
        cars.add(iosCar);
        Car backCar = new Car("back");
        cars.add(backCar);

        // when
        webCar.moveForward();
        iosCar.moveForward();
        iosCar.moveForward();
        backCar.moveForward();
        backCar.moveForward();

        // then
        List<Car> winners = gameService.getWinners(cars);

        assertThat(winners.size()).isEqualTo(2);
        assertAll(
                () -> assertThat(winners.get(0).getName()).isEqualTo(iosCar.getName()),
                () -> assertThat(winners.get(1).getName()).isEqualTo(backCar.getName())
        );

    }

}