package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.StepConstant.MOVING_FORWARD;
import static racingcar.constant.StepConstant.STOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceResultTexts;
import racingcar.util.StringFormatter;

class CarsPositionTest {
    @DisplayName("자동차 위치 생성 시 경주 자동차를 이용한다.")
    @Test
    void success_Create_Cars_Position() {
        // given
        RacingCars racingCars = createRacingCars();
        Map<String, Integer> expected = racingCars.createInitPosition();

        // when
        CarsPosition result = CarsPosition.createPositionWithRacingCars(racingCars);

        // then
        assertThat(result).hasFieldOrPropertyWithValue("carsPosition", expected);
    }

    @DisplayName("각 자동차 별 경주 결과를 요청하면 경주를 진행 후 경주 결과를 반환한다.")
    @Test
    void success_Get_Each_Race_Result() {
        // given
        RacingCars racingCars = createRacingCars();
        CarsPosition carsPosition = CarsPosition.createPositionWithRacingCars(racingCars);
        RaceResultTexts expected = createRaceResults();

        // when // then
        assertRandomNumberInRangeTest(
                () -> {
                    carsPosition.race();
                    RaceResultTexts result = carsPosition.getEachRaceResult();
                    assertThat(result).isEqualTo(expected);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @DisplayName("우승자를 안내 문구를 요청한다.")
    @Test
    void success_Get_Winner_Sole() {
        // given
        RacingCars racingCars = createRacingCars();
        CarsPosition carsPosition = CarsPosition.createPositionWithRacingCars(racingCars);
        String expectedWinner = "apple";
        String expected = StringFormatter.winnerFormat(expectedWinner);

        // when // then
        assertRandomNumberInRangeTest(
                () -> {
                    carsPosition.race();
                    String result = carsPosition.getWinner();
                    assertThat(result).isEqualTo(expected);
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @DisplayName("우승자를 안내 문구를 요청한다. 여러 명일 경우 쉼표를 이용하여 구분한다.")
    @Test
    void success_Get_Winner_Multi() {
        // given
        RacingCars racingCars = createRacingCars();
        CarsPosition carsPosition = CarsPosition.createPositionWithRacingCars(racingCars);
        String expectedWinners = "apple, bear";
        String expected = StringFormatter.winnerFormat(expectedWinners);

        // when // then
        assertRandomNumberInRangeTest(
                () -> {
                    carsPosition.race();
                    String result = carsPosition.getWinner();
                    assertThat(result).isEqualTo(expected);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    private RaceResultTexts createRaceResults() {
        List<String> list = new ArrayList<>();
        list.add(StringFormatter.raceResultFormat("apple", 1));
        list.add(StringFormatter.raceResultFormat("bear", 0));
        list.add(StringFormatter.raceResultFormat("cake", 1));
        return new RaceResultTexts(list);
    }

    private RacingCars createRacingCars() {
        String input = "apple,bear,cake";
        return RacingCars.createRacingCars(input);
    }
}
