package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DomainTest {

    @Test
    public void 자동차객체생성테스트(){
        Car car = new Car("super");

        String testName= car.getName();
        int testLocation=car.getLocation();

        Assertions.assertThat(testName).isEqualTo("super");
        Assertions.assertThat(testLocation).isEqualTo(0);
    }

    @Test
    public void 자동차객체위치변환테스트(){
        Car car = new Car("superduper");

        car.incLocation();

        int testLocation= car.getLocation();

        Assertions.assertThat(testLocation).isEqualTo(1);
    }

    @Test
    public void 게임도메인생성테스트(){
        Car car =new Car("super");
        Car car2 = new Car("duper");

        List<Car> carList=new ArrayList<Car>();

        carList.add(car);
        carList.add(car2);

        GameSystem gameSystem=new GameSystem(carList,2);
        gameSystem.incAttemptNum();

        Assertions.assertThat(gameSystem.getCarList().get(0).getName()).isEqualTo("super");
        Assertions.assertThat(gameSystem.getCarList().get(1).getName()).isEqualTo("duper");
        Assertions.assertThat(gameSystem.compareAttemptNumToFinal()).isFalse();

        gameSystem.incAttemptNum();
        Assertions.assertThat(gameSystem.compareAttemptNumToFinal()).isTrue();

    }

}
