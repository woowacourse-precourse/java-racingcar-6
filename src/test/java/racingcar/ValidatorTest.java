package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @Test
    void testIsCarNameOverFive() {
        String[] testSample = "pobi,javajiww".split(",");
        ArrayList<String> testList = new ArrayList<String>(Arrays.asList(testSample));

        Validators validator = new Validators();
        assertThatThrownBy(() -> {
            validator.isCarNameOverFive(testList.get(1));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하였습니다.");
    }

    @Test
    void testIsInteger() {
        Validators validator = new Validators();
        ArrayList<String> testNumbers = new ArrayList<>();
        testNumbers.add("2.3");
        testNumbers.add("-4");

        for(String number : testNumbers){
            assertThatThrownBy(
                    () -> {
                        validator.isInteger(number);
                    }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 값을 입력하였습니다.");
        }
    }
}
