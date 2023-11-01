package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.OutputStream;
import org.junit.jupiter.api.Test;
import racingcar.view.CarView;

public class CarViewTest extends BaseTest {

    private final CarView carView = CarView.getInstance();

    @Test
    void testPrintCarStatus() {
        OutputStream out = setIO();
        carView.printCarStatus("name", 1, false);
        assertThat(out.toString()).contains("name : -");
    }
}
