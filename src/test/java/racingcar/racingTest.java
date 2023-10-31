package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarGenerator;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class racingTest {

    /**
     * CarGenerator
     */
    @Test
    public void CarGenerator_생성() throws Exception {
        String input = "ab,cd,ef";
        String[] inStr = input.split(",");
        CarGenerator cars = new CarGenerator(inStr);
        String[] names = cars.getNames();

        for (int i = 0; i < names.length; i++) {
            assertThat(names[i]).contains(inStr[i]);
        }
    }

    /**
     * 입력 예외처리
     */
    @Test
    public void 문자열길이_예외처리() {
        String input = "abcdef";
        String[] inStr = input.split(",");

        assertThatThrownBy(() -> new CarGenerator(inStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * NumberGenerator
     */
    @Test
    public void 랜덤숫자_생성() {
        Integer[] result = NumberGenerator.createRandomNumbers(3);
        assertThat(Arrays.stream(result).allMatch(v->v>=0 && v<=9)).isTrue();
    }

    /**
     * Referee
     */
    @Test
    public void 우승자() {
        String input = "ab,cd,ef";
        String[] inStr = input.split(",");
        CarGenerator cars = new CarGenerator(inStr);

        cars.getLocations()[0] = "--";
        cars.getLocations()[1] = "---"; //winner
        cars.getLocations()[2] = "--";

        List<String> result = Referee.calculateCars(cars);
        assertThat(result.get(0).contains("cd"));
    }
}
