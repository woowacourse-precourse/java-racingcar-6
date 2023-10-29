package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NameParserTest {

/*    @Test
    void 쉼표로_자동차_이름_나누기() {
        // Given
        String input = "pobi,woni,jun";
        List<String> expectedCarNames = Arrays.asList("pobi", "woni", "jun");

        // When
        NameParser nameParser = new NameParser();
        List<String> resultCarNames = nameParser.parseCarName(input);

        // Then
        assertThat(resultCarNames).isNotNull();
        assertThat(resultCarNames).hasSize(3);
        assertThat(resultCarNames).containsExactlyElementsOf(expectedCarNames);
    }
    @Test
    public void 자동차이름_5자_이하() {
        // Given
        NameParser nameParser = new NameParser();
        List<String> carNameList = Arrays.asList("Joind", "BMW", "Audi");

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> {
            nameParser.setCar(carNameList);
        });
    }*/

    @Test
    public void 자동차_이름_할당() {
        // Given
        NameParser nameParser = new NameParser();
        List<String> carNameList = Arrays.asList("Tesla", "Ford", "car");

        // When
        List<Car> carList = nameParser.setCar(carNameList);

        // Then
        assertThat(carList).isNotNull();
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("Tesla");
    }
}
