package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class InfomationTest {

    @Test
    void of_생성테스트() {
        Information result = Information.of("poni, woni", "5");
        assertThat(result.getTimes()).isEqualTo(5);
        assertThat(result.getNames().size()).isEqualTo(2);
    }
}