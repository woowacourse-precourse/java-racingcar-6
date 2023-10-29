package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.service.Car;

public class CarTest {

    @Test
    void 차_리스트_하나씩_나누기(){
        Car car = new Car();
        car.inputCar = "여엉차,흐읏차,오코차";
        List<String> result = car.nameSplit();
        assertThat(result).containsExactly("여엉차","흐읏차","오코차");
    }

    @Test
    void 차_이름_5이하만_받기() {
        Car car = new Car();
        car.splitCarList = Arrays.asList("여엉차","흐읏차","제이제이오코차");
        List<String> result = car.nameRange();
        assertThat(result).containsExactly("여엉차","흐읏차");
    }
}
