package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class InputViewTest {
    InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    private void setInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Nested
    class readCarNamesTest {
        @Test
        void 자동차_이름_입력_테스트() {
            // given
            String input = "Car1,Car2,Car3";
            setInput(input);

            // when
            List<String> names = inputView.readCarNames();

            // then
            assertThat(names).isEqualTo(List.of("Car1", "Car2", "Car3"));
        }

        @Test
        void 자동차_공백_포함한_이름_입력_테스트() {
            // given
            String input = "Car1, Car2, Car3";
            setInput(input);

            // when
            List<String> names = inputView.readCarNames();

            // then
            assertThat(names).isEqualTo(List.of("Car1", "Car2", "Car3"));
        }

        @Test
        void 자동차_이름_입력_빈값_예외_테스트() {
            // given
            String input = " ";
            setInput(input);

            // when & then
            assertThatThrownBy(inputView::readCarNames)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("적어도 한 개 이상의 자동차 이름을 입력해주세요.");
        }

    }

    @Nested
    class readTryCountTest {
        @Test
        void 시도_횟수_입력_테스트() {
            // given
            String input = "5";
            setInput(input);

            // when
            int tryCount = inputView.readTryCount();

            // then
            assertThat(tryCount).isEqualTo(5);
        }

        @Test
        void 시도_횟수_음수_예외_테스트() {
            // given
            String input = "-3";
            setInput(input);

            // when & then
            assertThatThrownBy(inputView::readTryCount)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도 횟수는 0 이상이어야 합니다.");
        }

        @Test
        void 시도_횟수_잘못된_입력_예외_테스트() {
            // given
            String input = "invalidInput";
            setInput(input);

            // when & then
            assertThatThrownBy(inputView::readTryCount)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 입력입니다. 유효한 숫자를 입력해주세요.");
        }
    }

}