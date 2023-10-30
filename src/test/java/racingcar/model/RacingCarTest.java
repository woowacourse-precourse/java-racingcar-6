package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("자동차 리스트를 입력 받아 이를 갖는 경주 객체 생성")
    @Test
    void createRacingCar() {
        //given
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        Car junCar = new Car("jun");

        //when
        RacingCar racingCar = new RacingCar(List.of(pobiCar, woniCar, junCar));

        //then
        assertThat(racingCar.getCars()).contains(pobiCar, woniCar, junCar);
    }

    @DisplayName("우승자가 한 명이면 한 명의 우승자를 반환")
    @Test
    void findOneWinner() {
        //given
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        Car junCar = new Car("jun");
        pobiCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        woniCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        junCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        junCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        RacingCar racingCar = new RacingCar(List.of(pobiCar, woniCar, junCar));

        //when
        List<Car> winners = racingCar.findWinners();

        //then
        assertThat(winners).contains(junCar);
    }

    @DisplayName("우승자가 두 명 이상이면 두 명 이상의 공동 우승자를 반환")
    @Test
    void findJointWinner() {
        //given
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        Car junCar = new Car("jun");
        pobiCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        pobiCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        woniCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        woniCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        junCar.moveForward(Car.MIN_NUMBER_ALLOWED_TO_MOVE);
        RacingCar racingCar = new RacingCar(List.of(pobiCar, woniCar, junCar));

        //when
        List<Car> winners = racingCar.findWinners();

        //then
        assertThat(winners).contains(pobiCar, woniCar);
    }

    @DisplayName("모든 자동차가 이동하지 않았다면 모든 자동차가 공동 우승자")
    @Test
    void allJointWinner() {
        //given
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        Car junCar = new Car("jun");
        RacingCar racingCar = new RacingCar(List.of(pobiCar, woniCar, junCar));

        //when
        List<Car> winners = racingCar.findWinners();

        //then
        assertThat(winners).contains(pobiCar, woniCar, junCar);
    }
}