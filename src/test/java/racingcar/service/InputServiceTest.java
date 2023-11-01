package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputServiceTest {
    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("성공 : 유효한 자동차 입력 및 시도 횟수 입력")
    void setInputMessageForSuccess() {
        // given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("pobi,woni,jun\n5".getBytes());
        System.setIn(inputStream);

        // when
        InputService.setInputMessage();

        // then
        assertArrayEquals(new String[]{"pobi", "woni", "jun"}, InputService.carList);
        assertEquals(5, InputService.attemptCount);
    }

    @Test
    @DisplayName("성공 : 입력된 자동차들이 쉼표를 기준으로 나뉘어지는 경우")
    void inputCarsForSuccess() {
        // given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("pobi,woni,jun\n".getBytes());
        System.setIn(inputStream);

        // when
        String[] carList = InputService.inputCars();

        // then
        assertArrayEquals(new String[]{"pobi", "woni", "jun"}, carList);
    }

    @Test
    @DisplayName("성공 : 입력된 자동차들이 리스트로 만들어지는 경우")
    void createCarListForSuccess() {
        // given
        String cars = "pobi,woni,jun";

        // when
        String[] carList = InputService.createCarList(cars);

        // then
        assertArrayEquals(new String[]{"pobi", "woni", "jun"}, carList);
    }

    @Test
    @DisplayName("성공 : 입력 횟수를 정상적으로 받는 경우")
    void getAttemptCountForSuccess() {
        // given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(inputStream);

        // when
        int attemptCount = InputService.getAttemptCount();

        // then
        assertEquals(5, attemptCount);
    }

    @Test
    @DisplayName("실패 : 입력 횟수가 숫자가 아닌 경우")
    void getAttemptCountForFailure() {
        // given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("string\n".getBytes());
        System.setIn(inputStream);

        // when, then
        assertThatThrownBy(InputService::getAttemptCount).isInstanceOf(IllegalArgumentException.class);
    }
}
