package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.service.CarName;

public class CarNameTest {

    @Test
    void 차_리스트_하나씩_나누기(){
        CarName carName = new CarName();
        carName.inputCar = "여엉차,흐읏차,오코차";
        List<String> result = carName.split();
        assertThat(result).containsExactly("여엉차","흐읏차","오코차");
    }

    @Test
    void 차_이름_5이하만_받기() {
        CarName car = new CarName();
        car.splitCarList = Arrays.asList("여엉차","흐읏차","제이제이오코차");
        List<String> result = car.range();
        assertThat(result).containsExactly("여엉차","흐읏차");
    }
}
