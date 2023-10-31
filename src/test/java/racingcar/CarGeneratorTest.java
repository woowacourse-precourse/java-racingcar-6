package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarGenerator;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class CarGeneratorTest {
    CarGenerator testGenerator = new CarGenerator();
    @Test
    void 자동차_생성(){
        List<String> testCarList = new ArrayList<>();
        testCarList.add("testOne");
        testCarList.add("testTwo");
        assertThat(testGenerator.createCars(testCarList)).isInstanceOf(ArrayList.class);
        assertThat(testCarList.get(0)).contains("testOne");
        assertThat(testCarList.get(1)).contains("testTwo");
    }

}
