package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class viewTest extends NsTest {

    @DisplayName("단독 우승자를 출력하는 테스트")
    @Test
    void printFinalWinner() {
        //given
        List<String> winners = List.of("pobi");

        //when
        OutputView.printFinalWinner(winners);

        //then
        assertThat(output()).isEqualTo("최종 우승자 : pobi");
    }

    @DisplayName("공동 우승자 목록을 출력하는 테스트")
    @Test
    void printFinalWinners() {
        //given
        List<String> winners = List.of("pobi,dui");

        //when
        OutputView.printFinalWinner(winners);

        //then
        assertThat(output()).isEqualTo("최종 우승자 : pobi,dui");
    }

    @Override
    protected void runMain() {

    }
}
