package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.service.RacingCarService;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCarService racingCarService = new RacingCarService();

    @DisplayName("랜덤 번호가 4 이상이면 1칸 전진한다.")
    @Test
    void moveForward() {
        Car car = new Car("stella");
        car.setPosition(0);
        racingCarService.move(car,5);
        assertThat(car.getPosition()).isEqualTo(1);
    }
    @DisplayName("랜덤 번호가 4 이하이면 전진하지 않는다.")
    @Test
    void notMoveForward() {
        Car car = new Car("stella");
        car.setPosition(0);
        racingCarService.move(car,1);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("가장 많이 전진한 숫자를 찾는다.")
    @Test
    void findMaxPosition() {
        Car maxCar = new Car("stella");
        maxCar.setPosition(4);
        Car minCar = new Car("jay");
        minCar.setPosition(1);
        List<Car> cars = Arrays.asList(maxCar,minCar);
        assertThat(racingCarService.findMaxPosition(cars)).isEqualTo(4);
    }

    @DisplayName("최종 우승자를 찾는다.")
    @Test
    void findWinner() {
        Car winner = new Car("winner");
        winner.setPosition(5);
        Car notWinner = new Car("not winner");
        notWinner.setPosition(2);
        List<Car> cars = Arrays.asList(winner,notWinner);
        assertThat(racingCarService.findWinner(cars,racingCarService.findMaxPosition(cars))).isEqualTo(Arrays.asList("winner"));
    }

    @DisplayName("최종 우승자들(복수)을 찾는다.")
    @Test
    void findWinners() {
        Car firstWinner = new Car("first");
        firstWinner.setPosition(6);
        Car secondWinner = new Car("second");
        secondWinner.setPosition(6);
        Car notWinner = new Car("not winner");
        notWinner.setPosition(2);
        List<Car> cars = Arrays.asList(firstWinner,secondWinner,notWinner);
        assertThat(racingCarService.findWinner(cars,racingCarService.findMaxPosition(cars))).isEqualTo(Arrays.asList("first","second"));
    }
}
