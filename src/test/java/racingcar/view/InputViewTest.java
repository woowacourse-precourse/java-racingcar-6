package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class InputViewTest {

    @Test
    void 자동차_이름_입력_테스트() {
        // given
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> result = InputView.readRacingCarName();

        // then
        assertThat(result).isEqualTo(List.of("pobi", "woni", "jun"));
    }
}