package game;

import org.junit.jupiter.api.Test;
import racingcar.business.InputValidator;
import racingcar.GameInputHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {
    InputValidator validator = new InputValidator();

    @Test
    void splitStringToList_메서드로_주어진_값을_구분() {
        GameInputHandler gameInputHandler = new GameInputHandler();
        Method method = null;
        try {
            method = gameInputHandler.getClass().getDeclaredMethod("splitStringToList", String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("메서드를 찾을 수 없습니다.", e);
        }
        //splitStringToList 메서드 테스트 하기 위해 private 메서드 접근 허용
        method.setAccessible(true);
        String input = "aaa,bbb,ccc";
        List<String> cars = new ArrayList<>();
        try {
            cars = (List<String>) method.invoke(gameInputHandler, input);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("메서드 호출 실패", e);
        }

        assertThat(cars).contains("bbb", "aaa", "ccc");
        assertThat(cars).containsExactly("aaa", "bbb", "ccc");
    }

    @Test
    void 이름에_대한_예외_처리() {
        List<String> input = new ArrayList<>();
        input.add("123");
        input.add("12345");
        input.add("123456");

        assertThrows(IllegalArgumentException.class, () -> validator.validateCarsName(input));
    }

    @Test
    void 입력값_띄어쓰기_예외_확인() {
        String input = "1 ,2,3";

        assertThrows(IllegalArgumentException.class, () -> validator.validateInputValue(input));
    }

    @Test
    void 입력값_Empty_예외() {
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> validator.validateInputValue(input));
    }

    @Test
    void 자동차_이름_중복() {
        List<String> input = new ArrayList<>();
        input.add("abc");
        input.add("def");
        input.add("abc");

        assertThrows(IllegalArgumentException.class, () -> validator.validateCarsName(input));
    }

    @Test
    void 시도할_횟수_숫자_외_값() {
        String input = "a";

        assertThrows(IllegalArgumentException.class, () -> validator.validateAttempts(input));
    }
}
