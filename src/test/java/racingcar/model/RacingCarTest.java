package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingGame;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("경주 우승자 판별 테스트")
    @Test
    void determineWinnerTest() {

        RacingCar racingCar = new RacingCar(new ArrayList<String>(Arrays.asList("냠냠","뭐뭐")));
        racingCar.stopOrMoveForward();

        assertThat(racingCar.determineWinner()).as("경주의 우승자가 예상한 값이 아닙니다.")
                .containsAnyOf("냠냠","뭐뭐");


    }
}
