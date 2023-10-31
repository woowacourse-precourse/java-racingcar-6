package racingcar;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.Console.validateCarName;

class ConsoleTest {
    @TestFactory
    Collection<DynamicTest> 자동차_이름_입력시_예외처리() {
        return List.of(
                DynamicTest.dynamicTest("자동차 이름을 입력하지 않은 경우 에러 발생", () -> {
                    Throwable thrown = catchThrowable(() -> validateCarName(""));
                    assertEquals("자동차 이름은 1자리 이상 5자 이하만 가능합니다.", thrown.getMessage());
                }),
                DynamicTest.dynamicTest("자동차 이름이 5자를 초과할 경우 에러 발생", () -> {
                    Throwable thrown = catchThrowable(() -> validateCarName("pobicon"));
                    assertEquals("자동차 이름은 1자리 이상 5자 이하만 가능합니다.", thrown.getMessage());
                })
        );
    }

    @TestFactory
    Collection<DynamicTest> 시도_횟수_입력시_예외처리() {
        return List.of(
                DynamicTest.dynamicTest("시도 횟수가 숫자가 아닌 경우 에러 발생", () -> {
                    Throwable thrown = catchThrowable(() -> Console.validateTryCount("a"));
                    assertEquals("시도 횟수는 숫자여야 합니다.", thrown.getMessage());
                }),
                DynamicTest.dynamicTest("시도 횟수가 0인 경우 에러 발생", () -> {
                    Throwable thrown = catchThrowable(() -> Console.validateTryCount("0"));
                    assertEquals("시도 횟수는 1 이상이어야 합니다.", thrown.getMessage());
                }),
                DynamicTest.dynamicTest("시도 횟수가 음수인 경우 에러 발생", () -> {
                    Throwable thrown = catchThrowable(() -> Console.validateTryCount("-1"));
                    assertEquals("시도 횟수는 1 이상이어야 합니다.", thrown.getMessage());
                })
        );
    }
}
