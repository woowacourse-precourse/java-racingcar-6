package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("문자열을 구분하는 기능")
    @Test
    void inputCarNamesTest() {
        System.setIn(new ByteArrayInputStream(",,,".getBytes()));
        List<String> answer = new ArrayList<>() {
            {
                add("pobi");
                add("woni");
                add("jun");
            }
        };

        List<String> nameList = InputView.inputCarNames();

        assertThat(answer).isEqualTo(nameList);
    }
}
