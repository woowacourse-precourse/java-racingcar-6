package myTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class funcTest {

    @Test
    void count만큼_문자_반복출력() {

        int count = 5;
        String str = "-".repeat(count);

        assertThat(str).isEqualTo("-----");
    }

    @Test
    void initCar() {

        Car pony = new Car("pony");

        assertThat(pony.getName()).isEqualTo("pony");
        assertThat(pony.getScore()).isEqualTo(0);
    }

    @Test
    void Car_updateScore() {

        Car pony = new Car("pony");
        pony.plusScore();

        assertThat(pony.getScore()).isEqualTo(1);
    }

    @Test
    void 단일_우승자_판별() {

        Map<String, Car> carInfo = new HashMap<>();
        ArrayList<String> winner = new ArrayList<>();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        carInfo.put("car1", car1);
        carInfo.put("car2", car2);
        carInfo.put("car3", car3);

        car1.plusScore();

        int maxScore = 0;

        for (Car car : carInfo.values()) {

            if (maxScore < car.getScore()) {
                maxScore = car.getScore();
            }
        }

        assertThat(maxScore).isEqualTo(1);

        for (Car car : carInfo.values()) {
            if(maxScore == car.getScore()) {
                winner.add(car.getName());
            }
        }

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0)).isEqualTo("car1");
    }

    @Test
    void 공동_우승자_판별() {

        Map<String, Car> carInfo = new HashMap<>();
        ArrayList<String> winner = new ArrayList<>();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        carInfo.put("car1", car1);
        carInfo.put("car2", car2);
        carInfo.put("car3", car3);

        car1.plusScore();
        car2.plusScore();

        int maxScore = 0;

        for (Car car : carInfo.values()) {

            if (maxScore < car.getScore()) {
                maxScore = car.getScore();
            }
        }

        assertThat(maxScore).isEqualTo(1);

        for (Car car : carInfo.values()) {
            if(maxScore == car.getScore()) {
                winner.add(car.getName());
            }
        }

        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.get(0)).isEqualTo("car1");
        assertThat(winner.get(1)).isEqualTo("car2");
    }

    @Test
    void checkNameLengthException() {

        String input = "car1213, car2, car3";
        Application.carNameList = input.split(",");

        assertThatThrownBy(()->Application.exceptionInputCarNames()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNameListSizeException() {

        String input = "car3";
        Application.carNameList = input.split(",");

        assertThatThrownBy(()->Application.exceptionInputCarNames()).isInstanceOf(IllegalArgumentException.class);
    }
}
