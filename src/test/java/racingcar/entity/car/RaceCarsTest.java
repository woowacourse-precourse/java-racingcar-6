package racingcar.entity.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.request.RequestChecker;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constants.ErrorConstants.CAR_NAME_ERROR_MESSAGE;
import static racingcar.constants.ErrorConstants.DUPLICATE_NAME_ERROR_MESSAGE;

class RaceCarsTest {

    @Test
    @DisplayName("중복된 이름을 입력시 예외가 발생한다.")
    public void requestNamesDuplicateException() {
        // given
        String request = "pobi,pobi,pobi";
        System.setIn(new ByteArrayInputStream(request.getBytes()));
        // when //then
        assertThatThrownBy(() -> RequestChecker.requestNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("이름의 글자수가 5를 초과하면 예외가 발생한다.")
    public void requestNamesLengthException() {
        // given
        String request = "pobi,woni,haenCar";
        System.setIn(new ByteArrayInputStream(request.getBytes()));
        // when //then
        assertThatThrownBy(() -> RequestChecker.requestNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_ERROR_MESSAGE);
    }

}