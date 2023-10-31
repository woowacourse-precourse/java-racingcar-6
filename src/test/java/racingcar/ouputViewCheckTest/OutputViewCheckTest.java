package racingcar.ouputViewCheckTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.iosystem.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewCheckTest {
    @DisplayName("승자 출력")
    @Test
    void outputTest() {
        String[] cars = {"pobi","woni","jun"};
        int[] carMove = {3, 2, 3};
        assertThat(OutputView.winnerCarsList(carMove, cars)).isEqualTo("pobi, jun");
    }
}
