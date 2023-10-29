package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InfomationTest {

    @Test
    void of_생성테스트(){
        Infomation result = Infomation.of("poni, woni", "5");
        assertThat(result.getTimes()).isEqualTo(5);
        assertThat(result.getNames().size()).isEqualTo(2);
    }
}