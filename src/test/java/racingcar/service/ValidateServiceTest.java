package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class ValidateServiceTest {

    @Test
    void isEmpty() {
        assertThatThrownBy(() -> ValidateService.isEmpty(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidateService.isEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void hasBlank() {
        assertThatThrownBy(() -> ValidateService.hasBlank("kang yu seok"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidLength() {
        assertThatThrownBy(() -> ValidateService.isValidLength("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumber() {
        assertThatThrownBy(() -> ValidateService.isNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidateService.isNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidateService.isNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}