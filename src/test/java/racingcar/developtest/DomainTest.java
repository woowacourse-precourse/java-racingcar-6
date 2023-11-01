package racingcar.developtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.NumberGenerator;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong"})
    void stringToListByComma_콤마를_기준으로_문자열을_리스트로_변환(String string) {
        CarFactory carFactory = new CarFactory();
        List<String> result = carFactory.stringtoListByComma(string);
        assertThat(result.toString()).isEqualTo(Arrays.asList("pobi", "crong").toString());
    }

    @Test
    void updatePosition_앞으로_전진합니다(){
        Car car = new Car("pobi");
        car.updatePosition(NumberGenerator.generateRandomNumber(4,9));
        car.updatePosition(NumberGenerator.generateRandomNumber(4,9));
        assertThat(car.getFormattedPostion()).isEqualTo("pobi : --");
    }
    @Test
    void updatePosition_정지합니다(){
        Car car = new Car("pobi");
        car.updatePosition(NumberGenerator.generateRandomNumber(0,3));
        car.updatePosition(NumberGenerator.generateRandomNumber(0,3));
        assertThat(car.getFormattedPostion()).isEqualTo("pobi : ");
    }


}
