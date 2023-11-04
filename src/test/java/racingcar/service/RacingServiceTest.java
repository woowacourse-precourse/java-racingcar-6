package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.StringUtils;

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


    @Test
    @DisplayName("기능4 테스트: playAllRounds 메서드 실제로 전체 라운드를 진행하는지 확인한다.")
    void playAllRoundsShouldInvokePlayRoundAsManyAsTotalRound() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(carName1, 0));
        carList.add(new Car(carName2, 0));
        carList.add(new Car(carName3, 0));

        int totalCount = 5;

        // when
        String result = racingService.playAllRounds(carList, totalCount).toString();

        int countCarName1 = StringUtils.countOccurrences(result, carName1);
        int countCarName2 = StringUtils.countOccurrences(result, carName2);
        int countCarName3 = StringUtils.countOccurrences(result, carName3);

        // then
        assertThat(countCarName1).isEqualTo(totalCount);
        assertThat(countCarName2).isEqualTo(totalCount);
        assertThat(countCarName3).isEqualTo(totalCount);
    }
}