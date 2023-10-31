package racingcar;

import data.Car;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class CarTest {
    @Test
    void 올바른_이름_테스트(){
        String name = "cys";
        Car car = new Car(name);

        assertThat(car.getName()).contains("cys");
    }

    @Test
    void 잘못된_이름_테스트(){
        String name = "cyscyscys";
        assertThatThrownBy(()->new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Name can be longer than 5");
    }
    @Test
    void 트랙_추가되는지_테스트(){
        String name = "cys";
        Car car = new Car(name);
        car.add();
        car.add();
        car.add();

        assertThat(car.getTrackLength()).isEqualTo(3);
    }
    @Test
    void Car_문자열로_반환(){
        String name = "cys";
        Car car = new Car(name);
        car.add();

        assertThat(car.toString()).contains("cys : -");
    }

    @Test
    void 어떤_Car가_멀리_갔는지(){
        String winner ="win";
        String loser = "lose";
        Car winnerCar = new Car(winner);
        Car loserCar = new Car(loser);

        winnerCar.add();
        winnerCar.add();
        loserCar.add();

        int result = winnerCar.compareTo(loserCar);
        assertThat(result).isPositive();
    }
}
