package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.Input;

public class InputTest extends NsTest {
    Input input = new Input();

    @Test
    @DisplayName("경주 게임에 참여할 자동차 이름 입력 테스트")
    void getCarNameList_test() {
        command("pobi,woni,jun");
        List<String> carNameListForTest = input.getCarNameList();

        assertEquals(3, carNameListForTest.size());
        assertThat(carNameListForTest).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("시도할 횟수 입력 테스트")
    void getTryCount_test(){
        command(String.valueOf(4));
        int tryCountForTest = input.getTryCount();

        assertThat(tryCountForTest).isEqualTo(4);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {

    }
}
