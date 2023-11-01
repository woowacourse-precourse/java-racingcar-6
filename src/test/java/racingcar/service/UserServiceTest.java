package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.utils.ErrorMessage;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;


public class UserServiceTest {
    static UserService userService;
    static MockedStatic<Console> mockedConsole;

    @BeforeAll
    public static void init() {
        userService = UserService.getInstance();
        mockedConsole = mockStatic(Console.class);
    }

    @Test
    void 자동차_이름_빈칸_예외처리() {
        String input = "";
        readLineMocking(input);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getCars();
        }, ErrorMessage.NAMES_INPUT_IS_BLANK.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"yujin,", ","})
    void 다음_입력_빈칸_예외처리(String inputLine) {
        readLineMocking(inputLine);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getCars();
        }, ErrorMessage.NEXT_NAMES_NOT_ENTERED.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"minji,,yujin", ",yujin"})
    void 자동차_이름_공백_테스트_예외처리(String namesInput) {
        readLineMocking(namesInput);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getCars();
        }, ErrorMessage.ENTERED_CAR_IS_BLANK.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"kimyujin", "jay,yujinny"})
    void 자동차_이름_갯수_테스트(String namesInput) {
        readLineMocking(namesInput);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getCars();
        }, ErrorMessage.ENTERED_CAR_IS_TOO_LONG.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100", "-111"})
    void 시도_횟수_음수_테스트(String triesInput) {
        readLineMocking(triesInput);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getTries();
        }, ErrorMessage.TRIES_IS_NEGATIVE.getErrorMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10", "100", "10000"})
    void 시도_횟수_양수_테스트(String triesInput) {
        readLineMocking(triesInput);

        userService.getTries();
    }

    @Test
    void 시도_횟수_INTEGER_MAX_통과() {
        given(Console.readLine()).willReturn(Integer.toString(Integer.MAX_VALUE));

        userService.getTries();
    }

    @Test
    void 시도_횟수_INTEGER_MAX_초과() {
        long MAX = Integer.MAX_VALUE + 1;

        given(Console.readLine()).willReturn(Long.toString(MAX));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getTries();
        }, ErrorMessage.TRIES_IS_NOT_INT.getErrorMessage());
    }

    @Test
    void 시도_횟수_INTEGER_MAX_길이초과() {
        String MAX = Integer.toString(Integer.MAX_VALUE) + '1';

        given(Console.readLine()).willReturn(MAX);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getTries();
        }, ErrorMessage.TRIES_INPUT_IS_TOO_LONG.getErrorMessage());

    }

    private void readLineMocking(String namesInput) {
        given(Console.readLine()).willReturn(namesInput);
    }
}
