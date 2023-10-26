package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.judge.Judge;

import java.util.Arrays;
import java.util.List;

public class JudgeTest {

    @Test
    void getWinnersTest() {
        // Given
        Judge judge = new Judge();
        List<String> driverList = Arrays.asList("BTS", "손흥민", "봉준호", "김태훈");
        String opportunity = "5";

        // When
        List<String> result = judge.getWinners(driverList, opportunity);

        // Then
        System.out.println(result);
    }
}
