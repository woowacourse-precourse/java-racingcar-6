package racingcar.test;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.view.PlayerinputView;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Viewtest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 자동차이름_빈값_예외처리() {
        String input = ",aa,bb";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> PlayerinputView.getNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력하세요.");
    }

    @Test
    void 빈_라운드_횟수_예외처리() {
        String input = " ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> PlayerinputView.getRound())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수를 입력하세요.");
    }

    @Test
    void 시도횟수_0미만_예외처리() {
        String input = "-2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> PlayerinputView.getRound())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 0 이상이어야 합니다.");
    }

    @Test
    void 시도횟수에_문자_값_예외처리() {
        String input = "다섯번";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> PlayerinputView.getRound())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 숫자를 입력하세요.");
    }

    @Test
    void 자동차_이름_1개_예외처리() {
        String input = "super";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> PlayerinputView.getNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 2개 이상의 자동차 이름을 입력하세요.");
    }

}
