package racingcar.request;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.car.Name;

import java.io.ByteArrayInputStream;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static racingcar.constants.ErrorConstants.CAR_NAME_ERROR_MESSAGE;
import static racingcar.constants.ErrorConstants.DUPLICATE_NAME_ERROR_MESSAGE;


class RequestCheckerTest {

    @AfterEach
    public void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("쉼표(,)를 기준으로 자동차 이름을 저장할 수 있다.")
    public void requestNames() {
        // given
        String request = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(request.getBytes()));
        // when
        Set<Name> names = RequestChecker.requestNames();
        // then
        assertThat(names).hasSize(3)
                .extracting("name")
                .containsOnly("pobi", "woni", "jun");
    }

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

    @Test
    @DisplayName("시도할 횟수를 입력받을 수 있다.")
    public void getNumberOfMovementAttempts() {
        // given
        String request = "5";
        System.setIn(new ByteArrayInputStream(request.getBytes()));
        // when
        int movementAttempts = RequestChecker.getNumberOfMovementAttempts();
        // then
        assertThat(5).isEqualTo(movementAttempts);
    }

}