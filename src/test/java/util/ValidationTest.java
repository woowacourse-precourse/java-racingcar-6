package util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidationTest {


    @Test
    void limitGameNumberTest() {
        List<Integer> numberToTestList = new ArrayList<>(Arrays.asList(0, 1000, 100, 135));
        for (int num : numberToTestList) {
            assertThatThrownBy(() -> Validator.limitGameNumberValidator(num))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void testIsNumberValidator() {
        List<String> matchTimesTest = new ArrayList<>(Arrays.asList("", "ad1", "asd"));
        for (String num : matchTimesTest) {
            assertThatThrownBy(() -> Validator.isNumberValidator(num))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void testNameValidator() {
        List<String> namesToTest = new ArrayList<>(Arrays.asList("qwer", "johnqw", "john12qw"));
        assertThatThrownBy(() -> Validator.nameValidator(namesToTest))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
