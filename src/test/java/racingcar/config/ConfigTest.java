package racingcar.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.printer.GamePrinter;
import racingcar.scanner.NumberOfTimesScanner;
import racingcar.scanner.RacingCarNameScanner;

class ConfigTest {

    Config config = new Config();

    @Test
    @DisplayName("원하는 구현체가 반환되는지 확인")
    void getPrinter() {
        assertThat(config.getPrinter()).isInstanceOf(GamePrinter.class);
    }

    @Test
    @DisplayName("원하는 구현체가 반환되는지 확인")
    void getNameScanner() {
        assertThat(config.getNameScanner()).isInstanceOf(RacingCarNameScanner.class);
    }

    @Test
    @DisplayName("원하는 구현체가 반환되는지 확인")
    void getNumberScanner() {
        assertThat(config.getNumberScanner()).isInstanceOf(NumberOfTimesScanner.class);
    }
}