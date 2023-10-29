package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    private CarNameValidator validator;

    @Test
    void validateCarNameLength() {
        List<String> carNameList = Arrays.asList("pobi", "woni", "jun");
        assertThatThrownBy(() -> validator.validateCarNameLength(carNameList))
                .doesNotThrowAnyException();
    }

    @Test
    void validateCarNameDuplicate() {
    }
}