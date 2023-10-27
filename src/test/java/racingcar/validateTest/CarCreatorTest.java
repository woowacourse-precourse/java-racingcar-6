package racingcar.validateTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarCreator;
import racingcar.service.UserService;

public class CarCreatorTest {

    UserService userService;
    CarCreator carCreator;

    @BeforeEach
    void setUp() {
        carCreator = new CarCreator();
    }

    @Test
    void 차_입력_테스트() {
        String input = "pobi,woni";

        List<String> test = carCreator.createCarList(input);

        assertThat(test).contains("pobi", "woni");
    }

}
