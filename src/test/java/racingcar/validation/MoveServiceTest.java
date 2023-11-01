package racingcar.validation;

import org.junit.jupiter.api.Test;
import racingcar.model.Driver;

import static org.assertj.core.api.Assertions.*;

public class MoveServiceTest {

    private MoveService moveService = new MoveService();

    @Test
    void move_전진() {
        Driver driver = new Driver("pobi", 0);

        moveService.move(5, driver);

        assertThat(driver.getMoveCount()).isEqualTo(1);
    }

    @Test
    void move_그대로() {
        Driver driver = new Driver("pobi", 0);

        moveService.move(0, driver);
        assertThat(driver.getMoveCount()).isEqualTo(0);
    }
}
