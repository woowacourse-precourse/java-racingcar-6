package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddValueServiceTest {
    AddValueService addValueService = new AddValueService();

    @Test
    @DisplayName("자동차 이름 구분하기 테스트")
    void addCarNames() {
        String testNames = "테스트,테스트2,테스트3";
        String[] testResult = {"테스트","테스트2","테스트3"};
        Assertions.assertThat(addValueService.addCarNames(testNames)).isEqualTo(testResult);

    }

    @Test
    void addCarCount() {
        String testCount = "12";
        int testResult = 12;

        Assertions.assertThat(addValueService.addCarCount(testCount)).isEqualTo(testResult);
    }
}