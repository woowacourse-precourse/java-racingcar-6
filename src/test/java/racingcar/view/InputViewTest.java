package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc,", "abc,,abc", ",abc"})
    public void 쉼표는_이름과_이름_사이에_하나만_존재할_수_있다(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when, then
        Assertions.assertThatThrownBy(InputView::getCarNames)
                .isInstanceOf(IllegalArgumentException.class);

        // close Scanner
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@#,a#2", "abcd!,a+b*c", "안녕!!!"})
    public void 이름에는_특수기호가_포함될_수_없다(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when, then
        Assertions.assertThatThrownBy(InputView::getCarNames)
                .isInstanceOf(IllegalArgumentException.class);

        // close Scanner
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi3", "pobi,jun,ian", "hi,hello,안녕"})
    public void 이름의_형식이_지켜진_경우_에러가_발생하지_않는다(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when, then
        InputView.getCarNames();

        // close Scanner
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ab", "하이", "!@"})
    public void 시도_회수는_숫자_이외에_값을_받을_수_없다(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when, then
        Assertions.assertThatThrownBy(InputView::getAttemptCount)
                .isInstanceOf(IllegalArgumentException.class);

        // close Scanner
        Console.close();
    }

    private void systemIn(String input) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
    }

}