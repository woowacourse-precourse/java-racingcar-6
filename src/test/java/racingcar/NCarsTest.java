package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NCarsTest {
    NCars nCars;
    @BeforeEach
    void setUp(){
        String givenNames = "pobi,woni";
        List<String> names = Arrays.stream(givenNames.split(",")).toList();
        nCars = NCars.applyNames(names);
    }
    @Test
    @DisplayName("자동차에 이름들을 부여할 수 있다.")
    public void carNameApplyTest(){
        String givenNames = "pobi,woni";
        List<String> names = Arrays.stream(givenNames.split(",")).toList();
        nCars = NCars.applyNames(names);
        List<String> targetNames = Arrays.stream(givenNames.split(",")).toList();
        assertThat(nCars.getNamesForTest()).isEqualTo(targetNames);
    }
}
