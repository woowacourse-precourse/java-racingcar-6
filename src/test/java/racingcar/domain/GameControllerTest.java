package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

class GameControllerTest {

    @ParameterizedTest
    @CsvSource(value = {"4:-", "3:''", "9:-"}, delimiter = ':')
    @DisplayName("랜덤값이 4이상이면 전진하는 기능")
    void moveOrNot_랜덤값이_4이상이면_전진(int randomNumber, StringBuffer expected) {
        GameController gameController = new GameController();
        Car car = new Car("test");

        gameController.moveOrNot(car, randomNumber);

        assertThat(car.getForwardDistance().toString()).isEqualTo(expected.toString());
    }
}