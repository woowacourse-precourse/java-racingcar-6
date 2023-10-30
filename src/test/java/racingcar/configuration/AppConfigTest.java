package racingcar.configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class AppConfigTest {

    @Test
    public void AppConfig가_싱글톤인지() {
        // given && when
        Config config1 = AppConfig.getInstance();
        Config config2 = AppConfig.getInstance();

        // then
        assertThat(config1).isSameAs(config2);
    }

    @Test
    public void Config의_구현체를_반환하는지() {
        // given && when
        Config config1 = AppConfig.getInstance();

        // then
        assertThat(config1).isInstanceOf(Config.class);
    }

}
