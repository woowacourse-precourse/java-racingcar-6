package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarInputProcessTest {
    private CarInputProcess carInputProcess;

    @BeforeEach
    void setUp() {
        carInputProcess = new CarInputProcess();
    }

    @Test
    void 자동차_이름을_쉼표로_구분() {
        String input = "java,unity";
        List<String> testCars = carInputProcess.process(input);
        assertThat(testCars).contains("java", "unity");
        assertThat(testCars).containsExactly("java", "unity");
    }

    @Test
    void 자동차_이름이_5자_이상일경우_오류발생() {
        String input = "java,unityTest";
        assertThatThrownBy(() -> carInputProcess.process(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
