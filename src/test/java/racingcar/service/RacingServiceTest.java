package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

class RacingServiceTest {
    private final String carName1 = "A";
    private final String carName2 = "B";
    private final String carName3 = "C";

    private RacingService racingService;

    @BeforeEach
    void beforeEach() {
        racingService = new RacingService();
    }

    @Test
    @DisplayName("기능3 테스트: playRound 메서드 실행했을 때 현재 라운드 결과를 반환한다.")
    void playRoundShouldReturnRoundResult() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(carName1, 0));
        carList.add(new Car(carName2, 0));
        carList.add(new Car(carName3, 0));

        // when
        List<String> result = racingService.playRound(carList);

        // then
        assertThat(result).hasSize(3);
        assertThat(result.toString())
                .containsOnlyOnce(carName1)
                .containsOnlyOnce(carName2)
                .containsOnlyOnce(carName3);
    }

    @Test
    @DisplayName("기능3 테스트: playRound 메서드 실행했을 때 결과는 carList의 순서대로 생성된다.")
    void playRoundShouldKeepOriginalCarOrder() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(carName1, 0));
        carList.add(new Car(carName2, 0));
        carList.add(new Car(carName3, 0));

        // when
        List<String> result = racingService.playRound(carList);

        // then
        assertThat(result.toString())
                .containsSubsequence(carName1, carName2, carName3);
    }


}