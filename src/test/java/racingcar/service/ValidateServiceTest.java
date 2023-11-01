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
    void isEmpty() { //자동차 이름이 null 이거나 공백일 경우 예외 테스트
        assertThatThrownBy(() -> ValidateService.isEmpty(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidateService.isEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void hasBlank() { //자동차 이름 중에 공백이 들어갈 경우 예외 테스트
        assertThatThrownBy(() -> ValidateService.hasBlank("kang yu seok"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidLength() { //자동차 이름이 5자 넘어갈 때 예외 테스트
        assertThatThrownBy(() -> ValidateService.isValidLength("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumber() { //실행횟수를 입력받을 때 예외 테스트
        assertThatThrownBy(() -> ValidateService.isNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidateService.isNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidateService.isNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}