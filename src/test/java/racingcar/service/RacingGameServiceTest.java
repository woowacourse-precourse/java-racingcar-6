package racingcar.service;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.OneGameResultsDto;
import racingcar.service.domain.CarEngine;
import racingcar.service.domain.RacingCars;

class RacingGameServiceTest {

    static final Integer MOVE = 1;
    static final Integer STOP = 0;
    static final String racingCarNames = "L!!O,new,j2AnS,H,yp,b 0y";
    static final int CANT_MOVE_EDGE_CONDITION = 3;
    RacingGameService racingGameService = new RacingGameService();

    @ParameterizedTest
    @CsvSource(value = {"june,jayZ,White"})
    @DisplayName("[성공 테스트] 자동차 3대 중 2대만 전진하는 테스트")
    void playOneTimeCarRaceTest(String name1, String name2, String name3) {
        // given
        RacingCars racingCars = new RacingCars(List.of(name1, name2, name3), new CustomCarEngine());
        // when
        OneGameResultsDto resultDto = racingGameService.playOneTimeCarRace(racingCars);
        // then
        Assertions.assertThat(resultDto.getTotalPositions()).containsExactly(MOVE, STOP, MOVE);
    }

    @Test
    @DisplayName("최종 우승자 판별 기능 테스트. 경주 1회 진행")
    void calculateFinalWinnersTest1() {
        // given
        List<String> carNameList = Arrays.asList(racingCarNames.split(","));
        RacingCars racingCars = new RacingCars(carNameList, new CustomCarEngine2());
        // when
        racingGameService.playOneTimeCarRace(racingCars);
        List<String> winners = racingGameService.calculateFinalWinners(racingCars);
        // then
        Assertions.assertThat(winners).containsExactly("H", "yp", "b 0y");
    }

    @Test
    @DisplayName("최종 우승자 판별 기능 테스트. 경주 3회 진행")
    void calculateFinalWinnersTest2() {
        // given
        List<String> carNameList = Arrays.asList(racingCarNames.split(","));
        RacingCars racingCars = new RacingCars(carNameList, new CustomCarEngine2());
        int totalRound = 3;
        // when
        for (int round = 0; round < totalRound; round++) {
            racingGameService.playOneTimeCarRace(racingCars);
        }
        List<String> winners = racingGameService.calculateFinalWinners(racingCars);
        // then
        Assertions.assertThat(winners).containsExactly("H", "b 0y");
    }

    @Test
    @DisplayName("최종 우승자 판별 기능 테스트. 모든 자동차가 움직이지 못하는 경우")
    void calculateFinalWinnersTest3() {
        // given
        List<String> carNameList = Arrays.asList(racingCarNames.split(","));
        RacingCars racingCars = new RacingCars(carNameList, () -> CANT_MOVE_EDGE_CONDITION);
        // when
        racingGameService.playOneTimeCarRace(racingCars);
        List<String> winners = racingGameService.calculateFinalWinners(racingCars);
        // then
        Assertions.assertThat(winners).containsExactly("L!!O", "new", "j2AnS", "H", "yp", "b 0y");
    }

    static class CustomCarEngine implements CarEngine {
        List<Integer> enginePowers = Lists.newArrayList(4, 3, 8);

        @Override
        public int generateNumber() {
            return enginePowers.remove(0);
        }
    }

    static class CustomCarEngine2 implements CarEngine {
        List<Integer> enginePowers = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        List<Integer> enginePowers2 = Lists.newArrayList(0, 0, 9, 6, 3, 4);
        List<Integer> enginePowers3 = Lists.newArrayList(4, 3, 7, 9, 1, 8);

        @Override
        public int generateNumber() {
            if (!enginePowers.isEmpty()) {
                return enginePowers.remove(0);
            }
            if (!enginePowers2.isEmpty()) {
                return enginePowers2.remove(0);
            }
            return enginePowers3.remove(0);
        }
    }
}

