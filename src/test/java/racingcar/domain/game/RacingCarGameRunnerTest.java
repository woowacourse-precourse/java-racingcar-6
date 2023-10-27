package racingcar.domain.game;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameRunnerTest {

    @Test
    public void 입력받은_자동차_이름을_comma_기준으로_분리하는_기능() {
        // given
        String input = "app, band, cat, dog, egg";

        //when
        List<String> tmpNameList = Arrays.stream(input.split(", *")).toList();
        List<String> resultList = tmpNameList.stream()
                .filter(name -> !name.isBlank())
                .toList();

        //then
        assertThat(resultList).containsExactly("app", "band", "cat", "dog", "egg");
    }

    @Test
    public void 입력받은_자동차_이름에_있는_빈_문자열은_제외하는_기능() {
        // given
        String input = "app,,    ,  cat, dog, egg";

        //when
        List<String> tmpNameList = Arrays.stream(input.split(", *")).toList();
        List<String> resultList = tmpNameList.stream()
                .filter(name -> !name.isBlank())
                .toList();

        //then
        assertThat(resultList).containsExactly("app", "cat", "dog", "egg");
    }

    @Test
    public void 입력받은_이동_회수_음수_validation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input = "-1";

        //when
        RacingCarGameRunner runner = new RacingCarGameRunner();
        Method validateInput = RacingCarGameRunner.class
                .getDeclaredMethod("validateInput", String.class);
        validateInput.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> validateInput.invoke(runner, input));
        try {
            validateInput.invoke(runner, input);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    public void 입력받은_이동_회수_숫자_아닌_경우_validation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        String input = "apple";

        //when
        RacingCarGameRunner runner = new RacingCarGameRunner();
        Method validateInput = RacingCarGameRunner.class
                .getDeclaredMethod("validateInput", String.class);
        validateInput.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> validateInput.invoke(runner, input));
        try {
            validateInput.invoke(runner, input);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class);
        }
    }
}