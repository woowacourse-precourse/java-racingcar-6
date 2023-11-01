package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingRuleMakerTest {

    private RacingRuleMaker racingRuleMaker;
    private static final List<String> ANSWER1 = Arrays.asList("car1", "car2", "car3");
    private static final List<String> ANSWER2 = Arrays.asList("car1", "car2", "car3");
    private static final List<String> ANSWER3 = Arrays.asList("car1");

    @BeforeEach
    void setUp() {

        racingRuleMaker = new RacingRuleMaker("a,b,c", "1");
    }

    @Test
    void namingCar() {
        //문자열이 List<String>로 잘 변경이 되는지 확인
        List<String> result = racingRuleMaker.namingCar("car1,car2,car3");
        assertThat(result).isEqualTo(ANSWER1);
        //공백 제거 확인
        result = racingRuleMaker.namingCar(" car1 , car2,car3 ");
        assertThat(result).isEqualTo(ANSWER2);
        //인자가 1개일때
        result = racingRuleMaker.namingCar(" car1");
        assertThat(result).isEqualTo(ANSWER3);
    }

    @Test
    void inputRacingRoundTest() {

        int result = racingRuleMaker.inputRacingRound("1");
        assertThat(result).isEqualTo(1);

        result = racingRuleMaker.inputRacingRound("10");
        assertThat(result).isEqualTo(10);

        result = racingRuleMaker.inputRacingRound("103");
        assertThat(result).isEqualTo(103);


    }
}