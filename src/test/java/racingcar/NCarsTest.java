package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NCarsTest {
    String givenNames = "pobi,woni";
    List<String> names = Arrays.stream(givenNames.split(",")).toList();
    NCars nCars;

    @BeforeEach
    void setUp() {
        nCars = NCars.applyNames(names);
    }

    @Test
    @DisplayName("자동차들에 이름들을 부여할 수 있다.")
    public void carNameApplyTest() {
        String givenNames = "pobi,woni";
        List<String> names = Arrays.stream(givenNames.split(",")).toList();
        nCars = NCars.applyNames(names);
        List<String> targetNames = Arrays.stream(givenNames.split(",")).toList();
        assertThat(nCars.getNamesForTest()).isEqualTo(targetNames);
    }
    @Test
    @DisplayName("차량들을 한번 이동시킨다.")
    public void moveCarsByOneTimeNumberTest() {
        List<Integer> carsPosition = nCars.moveCars();
        Integer numberOfCars = names.size();
        assertThat(carsPosition.size()).isEqualTo(numberOfCars);
    }
    @Test
    @DisplayName("차량들을 입력한만큼 이동시킨다.")
    public void moveCarsByGivenNumberTest() {
        Integer round = 5;
        List<List<Integer>> carsPosition = nCars.moveCarsRepeatedByRound(round);
        assertThat(carsPosition.size()).isEqualTo(5);
    }

}
