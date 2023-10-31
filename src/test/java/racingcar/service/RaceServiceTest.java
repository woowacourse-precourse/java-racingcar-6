package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.StepConstant.MOVING_FORWARD;
import static racingcar.constant.StepConstant.STOP;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.MovingCount;
import racingcar.dto.RaceResultTexts;
import racingcar.model.RacingCars;
import racingcar.util.StringFormatter;

class RaceServiceTest {

    @DisplayName("전체 경주 결과를 조회하면 각 차수별 모든 자동차의 결과를 반환한다.")
    @Test
    void success_GetTotalResult() {
        // given
        RaceService raceService = createRaceService();
        RaceResultTexts first = createFirstRaceResultTexts();
        RaceResultTexts second = createSecondRaceResultTexts();
        RaceResultTexts expected = createExpectedRaceResultTexts(first, second);

        // when // then
        assertRandomNumberInRangeTest(
                () -> {
                    RaceResultTexts result = raceService.getTotalResult();
                    assertThat(result).isEqualTo(expected);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }

    @DisplayName("최종 우승자를 조회하면 출력 문구를 반환한다.")
    @Test
    void success_Get_Winner() {
        // given
        RaceService raceService = createRaceService();
        String expected = "최종 우승자 : apple";

        // when // then
        assertRandomNumberInRangeTest(
                () -> {
                    raceService.getTotalResult();
                    String result = raceService.getWinner();
                    assertThat(result).isEqualTo(expected);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }

    private RaceResultTexts createExpectedRaceResultTexts(RaceResultTexts first, RaceResultTexts second) {
        List<String> results = new ArrayList<>();
        results.add(first.convertOneLine());
        results.add(second.convertOneLine());
        return new RaceResultTexts(results);
    }

    private RaceResultTexts createFirstRaceResultTexts() {
        List<String> results = new ArrayList<>();
        results.add(StringFormatter.raceResultFormat("apple", 1));
        results.add(StringFormatter.raceResultFormat("bear", 0));
        results.add(StringFormatter.raceResultFormat("cake", 1));
        return new RaceResultTexts(results);
    }

    private RaceResultTexts createSecondRaceResultTexts() {
        List<String> results = new ArrayList<>();
        results.add(StringFormatter.raceResultFormat("apple", 2));
        results.add(StringFormatter.raceResultFormat("bear", 0));
        results.add(StringFormatter.raceResultFormat("cake", 1));
        return new RaceResultTexts(results);
    }

    private RaceService createRaceService() {
        RacingCars racingCars = createRacingCars();
        MovingCount movingCount = createMovingCount();
        return RaceService.init(racingCars, movingCount);
    }

    private RacingCars createRacingCars() {
        String input = "apple,bear,cake";
        return RacingCars.createRacingCars(input);
    }

    private MovingCount createMovingCount() {
        String input = "2";
        return MovingCount.createMovingCount(input);
    }
}
