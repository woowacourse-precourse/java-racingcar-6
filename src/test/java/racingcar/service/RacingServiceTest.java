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

        carList.add(new Car("A", 0));
        carList.add(new Car("B", 0));
        carList.add(new Car("C", 0));

        // when
        List<Car> rondResult = racingService.playRound(carList);

        // then
        assertThat(rondResult).hasSize(3);
        assertThat(rondResult.toString())
                .containsOnlyOnce("A")
                .containsOnlyOnce("B")
                .containsOnlyOnce("C");
    }

    @Test
    @DisplayName("기능3 테스트: playRound 메서드 실행했을 때 결과는 carList의 순서대로 생성된다.")
    void playRoundShouldKeepOriginalCarOrder() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 0));
        carList.add(new Car("B", 0));
        carList.add(new Car("C", 0));

        // when
        List<Car> rondResult = racingService.playRound(carList);

        // then
        assertThat(rondResult.toString())
                .containsSubsequence("A", "B", "C");
    }

    @Test
    @DisplayName("기능5 테스트: getMaxMovingDistance 메서드가 최댓값이 하나일 때 최댓값을 정확하게 반환한다.")
    void getMaxMovingDistanceWhenOneMaxExist() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 1));
        carList.add(new Car("B", 2));
        carList.add(new Car("C", 3));

        // when
        int maxMovingDistance = racingService.getMaxMovingDistance(carList);

        // then
        assertThat(maxMovingDistance).isEqualTo(3);
    }

    @Test
    @DisplayName("기능5 테스트: getMaxMovingDistance 메서드가 최댓값이 두개일 때 최댓값을 정확하게 반환한다.")
    void getMaxMovingDistanceWhenTwoMaxExist() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 1));
        carList.add(new Car("B", 3));
        carList.add(new Car("C", 3));

        // when
        int maxMovingDistance = racingService.getMaxMovingDistance(carList);

        // then
        assertThat(maxMovingDistance).isEqualTo(3);
    }

    @Test
    @DisplayName("기능5 테스트: getMaxMovingDistance 메서드가 최댓값이 세개일 때 최댓값을 정확하게 반환한다.")
    void getMaxMovingDistanceWhenThreeMaxExist() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 3));
        carList.add(new Car("B", 3));
        carList.add(new Car("C", 3));

        // when
        int maxMovingDistance = racingService.getMaxMovingDistance(carList);

        // then
        assertThat(maxMovingDistance).isEqualTo(3);
    }

    @Test
    @DisplayName("기능6 테스트: 우승자가 1명일 때 generateWinner가 우승자 목록을 제대로 반환한다.")
    void generateWinnerListWhenWinnerIsOne() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 1));
        carList.add(new Car("B", 2));
        carList.add(new Car("C", 3));

        // when
        List<String> winnerList = racingService.generateWinnerList(carList);

        // then
        assertThat(winnerList)
                .hasSize(1)
                .containsExactly("C");
    }

    @Test
    @DisplayName("기능6 테스트: 우승자가 2명일 때 generateWinner가 우승자 목록을 제대로 반환한다.")
    void generateWinnerListWhenWinnerIsTwo() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 1));
        carList.add(new Car("B", 3));
        carList.add(new Car("C", 3));

        // when
        List<String> winnerList = racingService.generateWinnerList(carList);

        // then
        assertThat(winnerList)
                .hasSize(2)
                .containsExactly("B", "C");
    }

    @Test
    @DisplayName("기능6 테스트: 우승자가 3명일 때 generateWinner가 우승자 목록을 제대로 반환한다.")
    void generateWinnerListWhenWinnerIsThree() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 3));
        carList.add(new Car("B", 3));
        carList.add(new Car("C", 3));

        // when
        List<String> winnerList = racingService.generateWinnerList(carList);

        // then
        assertThat(winnerList)
                .hasSize(3)
                .containsExactly("A", "B", "C");
    }


}