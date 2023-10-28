package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class GameManagerTest {
    GameManager gameManager;
    List<Car> cars;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @Test
    void checkMovePossible_4이상_실행_확인() {
        Car car = Mockito.mock(Car.class);
        gameManager = new GameManager() {
            @Override
            protected int createRandomNumber() {
                return 4;
            }
        };

        // 테스트 대상 메소드 호출
        gameManager.checkMovePossible(car);

        verify(car, times(1)).move();
    }

    @Test
    void checkMovePossible_3이하_실행_확인() {
        Car car = Mockito.mock(Car.class);
        gameManager = new GameManager() {
            @Override
            protected int createRandomNumber() {
                return 3;
            }
        };

        // 테스트 대상 메소드 호출
        gameManager.checkMovePossible(car);

        verify(car, never()).move();
    }

    @Test
    void createRandomNumber() {
        int random = gameManager.createRandomNumber();

        assertThat(random).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

    @Test
    void selectWinner_SingleWinner() {
        String winners = cars.get(0).getName();

        cars.get(0).move();
        List<String> result = gameManager.selectWinner(cars);

        assertThat(result.get(0)).isEqualTo(winners);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void selectWinner_MultipleWinner() {
        List<String> winners = new ArrayList<>();
        winners.add(cars.get(0).getName());
        winners.add(cars.get(1).getName());

        cars.get(0).move();
        cars.get(1).move();
        List<String> result = gameManager.selectWinner(cars);

        assertThat(result).isEqualTo(winners);
        assertThat(result.size()).isEqualTo(2);
    }
}