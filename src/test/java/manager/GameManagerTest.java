package manager;

import custom_object.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;


public class GameManagerTest {

    @ParameterizedTest
    @MethodSource("progressMatchTestArguments")
    @DisplayName("progressMatchTest")
    public void progressMatchTest(int numberOfMatch, int[] answerArray) {
        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("test1"), new Car("test2")));
        GameManager gameManager = new GameManager(carList);
        int[] result = new int[2];

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < numberOfMatch; i++) {
                        gameManager.progressMatch();
                    }

                    for (int i = 0; i < result.length; i++) {
                        result[i] = carList.get(i).getPosition();
                    }
                    assertThat(result).isEqualTo(answerArray);
//                assertThat(output).contains("test1 : -", "test2 : ", "최종 우승자 : test1");
                },
                4,3,3,3,4,4
        );
    }

    public static Stream<Arguments> progressMatchTestArguments() {
        return Stream.of(
                Arguments.of( 1, new int[]{1,0}),
                Arguments.of( 2, new int[]{1,0}),
                Arguments.of( 3, new int[]{2,1})
        );
    }
}
