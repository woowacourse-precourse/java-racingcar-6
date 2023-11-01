package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class UserInputTest extends NsTest {

    @TestFactory
    Stream<DynamicTest> testInvalidInputs() {
        return Stream.of(
                dynamicTest("이름_한개인_경우_예외_처리", () -> testInvalidInput("pobi")),
                dynamicTest("쉼표_뒤에_공백인_경우_예외_처리", () -> testInvalidInput("pobi, ")),
                dynamicTest("띄어쓰기가_포함된_이름인_경우_예외_처리", () -> testInvalidInput("pobi,wo ni")),
                dynamicTest("이름이_중복된_경우_예외_처리", () -> testInvalidInput("pobi,pobi")),
                dynamicTest("시도_횟수가_0인_경우_예외_처리", () -> testInvalidInput("pobi,woni", "0")),
                dynamicTest("시도_횟수가_0_미만인_경우_예외_처리", () -> testInvalidInput("pobi,woni", "-5"))
        );
    }

    private void testInvalidInput(String... inputs) {
        assertThatThrownBy(() -> runException(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
