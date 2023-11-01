package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static racingcar.Util.Constants.DUPLICATED;
import static racingcar.Util.Constants.HAS_BLANK;
import static racingcar.Util.Constants.MORE_THAN_MAXLENGTH;
import static racingcar.Util.Constants.UNVALID_NUMBER;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.Model.Game;

public class GameTest {
    @Test
    void 중복된_이름이_있을때() {
        List<String> inputList = Arrays.asList("minju", "pobi", "minju");
        int repitition = 4;

        assertThatThrownBy(() -> new Game(inputList, repitition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED);

    }

    @Test
    void 이름이_공백인_값이_있을때() {
        List<String> inputList = Arrays.asList("minju", "pobi", " ");
        int repitition = 4;

        assertThatThrownBy(() -> new Game(inputList, repitition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(HAS_BLANK);

    }

    @Test
    void 이름이_최대길이를_넘어갈때() {
        List<String> inputList = Arrays.asList("minjuchoi", "pobi", "minju");
        int repitition = 4;

        assertThatThrownBy(() -> new Game(inputList, repitition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MORE_THAN_MAXLENGTH);

    }

    @Test
    void 반복횟수가_음수일때() {
        List<String> inputList = Arrays.asList("minju", "pobi", "choi");
        int repitition = -1;

        assertThatThrownBy(() -> new Game(inputList, repitition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UNVALID_NUMBER);

    }

    @Test
    void 올바르게_입력했을때() {
        List<String> inputList = Arrays.asList("minju", "pobi", "choi");
        int repitition = 4;

        Game game = new Game(inputList, repitition);
        assertNotNull(game);
    }

    @Test
    void 전진_테스트() {
        Car car = new Car("minju");
        int[] randomNumber = {5, 1, 4, 3, 9};

        for (int i = 0; i < randomNumber.length; i++) {
            car.go(randomNumber[i]);
        }

        int result = car.getDistance();
        assertThat(result).isEqualTo(3);
    }
}
