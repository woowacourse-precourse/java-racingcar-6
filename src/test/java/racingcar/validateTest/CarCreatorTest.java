package racingcar.validateTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarCreator;
import racingcar.service.UserService;

public class CarCreatorTest {

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

    @Test
    void 이름_5글자_초과_테스트() {
        String input = "pobi,pobiii";

        assertThatThrownBy(() -> {
            List<String> test = carCreator.createCarList(input);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 최소_차량_입력_테스트() {
        String input = "pobi";

        assertThatThrownBy(() -> {
            List<String> test = carCreator.createCarList(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_차량_테스트() {
        String input = "pobi,pobi";

        assertThatThrownBy(() -> {
            List<String> test = carCreator.createCarList(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
