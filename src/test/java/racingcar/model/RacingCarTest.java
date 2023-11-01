package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingGame;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarTest {

    @DisplayName("경주 우승자 판별 테스트")
    @Test
    void determineWinnerTest() {

        RacingCar racingCar = new RacingCar(new ArrayList<String>(Arrays.asList("냠냠", "뭐뭐")));
        racingCar.stopOrMoveForward();

        assertThat(racingCar.determineWinner())
                .as("경주의 우승자가 예상한 값이 아닙니다.")
                .containsAnyOf("냠냠", "뭐뭐");


    }

    @DisplayName("자동차 이름 중복 예외 확인테스트")
    @ParameterizedTest
    @MethodSource("provideExceptionDuplicateCarNameList")
    void checkForDuplicationExceptionTest(List<String> testInput) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCar(testInput);
        });

    }

    static Stream<Arguments> provideExceptionDuplicateCarNameList() {
        return Stream.of(
                Arguments.of(Arrays.asList("a", "a", "c")),
                Arguments.of(Arrays.asList("x", "z", "z"))
        );
    }

//    @DisplayName("자동차들이 이동한 거리중 최대 거리 찾는 테스트")
//    @Test
//    void findMaxDistanceTest(){
//        RacingCar racingCar = new RacingCar(new ArrayList<String>(Arrays.asList("냠냠", "뭐뭐")));
//        racingCar.stopOrMoveForward();
//
//        racingCar.findMaxDistance()
//        assertThat(car.measureDistance()).as("자동차가 한칸 전진하거나 멈추지 않았습니다.")
//                .satisfiesAnyOf(actual -> assertThat(actual).isEqualTo(0)
//                        , actual -> assertThat(actual).isEqualTo(1));
//    }
//    }
}
