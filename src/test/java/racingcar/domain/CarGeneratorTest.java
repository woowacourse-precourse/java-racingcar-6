package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import static org.assertj.core.api.Assertions.assertThat;

class CarGeneratorTest {

    @Test
    void LinkedHashMap_자동차리스트_값을_확인() {
        LinkedHashMap<String,String> carList = new LinkedHashMap<>();
        String[] cars = {"pobi","jason","juno"};
        for(String car : cars) {
            carList.put(car,"");
        }
        for (String car : cars) {
            assertThat(carList).containsKey(car);
        }

    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "pobi,jason,juno";
        String[] carList = input.split(",");
        assertThat(carList).contains("pobi", "jason", "juno");
        assertThat(carList).containsExactly("pobi", "jason", "juno");
    }
}