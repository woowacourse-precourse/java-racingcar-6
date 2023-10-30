package racingcar.configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class AppConfigTest {

    @Test
    public void AppConfig가_싱글톤인지() {
        // given
        Config config1 = AppConfig.getInstance();
        Config config2 = AppConfig.getInstance();

        //when

        // then
        assertThat(config1).isEqualTo(config2);
    }
}
