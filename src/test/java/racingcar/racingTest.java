package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarGenerator;
import racingcar.domain.Referee;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class racingTest {

    @Test
    public void creatCarGenerator() throws Exception {
        String input = "ab,cd,ef";
        String[] inStr = input.split(",");
        CarGenerator cars= new CarGenerator(inStr);
        String[][] names = cars.getNames();

        for(int i=0; i<names.length; i++) {
            assertThat(names[i][0]).contains(inStr[i]);
        }
    }

    @Test
    public void 문자열길이_예외처리() {
        String input = "abcdef";
        String[] inStr = input.split(",");

        assertThatThrownBy(() -> new CarGenerator(inStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 우승자() {
        String input = "ab,cd,ef";
        String[] inStr = input.split(",");
        CarGenerator cars= new CarGenerator(inStr);
        String[][] names = cars.getNames();

        names[0][1] = "--";
        names[1][1] = "---"; //winner
        names[2][1] = "--";

        List<String> result = Referee.calculateCars(names);
        assertThat(result.get(0).contains("cd"));
    }
}
