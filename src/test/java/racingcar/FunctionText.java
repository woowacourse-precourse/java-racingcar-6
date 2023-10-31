package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionText {
    @Test
    void 자동차이름_입력_테스트() {
        String input = "pobi";
        Car name= new Car(input);
        String result = name.getName();
        assertThat(result).contains("pobi");
    }

    @Test
    void 전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    String input = "pobi";
                    Car name= new Car(input);
                    name.move();
                    String result = name.getPositionInString();
                    assertThat(result).contains("-");
                },
                5
        );
    }

    @Test
    void 우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    String input = "pobi,java";
                    List<String> carNames = Arrays.asList(input.split(","));

                    Race race = new Race(carNames);

                    race.playRound();
                    List<String> result=race.getWinners();
                    assertThat(result).contains("pobi");
                },
                5,1
        );
    }

}
