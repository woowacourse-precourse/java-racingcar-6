package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class RacingGameTest {
    private RacingGame racingGame;
    private final int NUM_OF_CARS = 3;
    private List<String> cars;
    List<String> resultList;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
        cars = new ArrayList<>(3);
        cars.add("pobi");
        cars.add("woni");
        cars.add("jin");
        resultList = racingGame.initResultList(NUM_OF_CARS);
    }

    @Test
    void initResultList_초기화_여부_확인_테스트() {
        assertThat(resultList).isEqualTo(Arrays.asList("","",""));
    }

    @Test
    void 랜덤값_3이하_경주_자동차_이동_테스트() {
        String resultMove = racingGame.decideMoveByRandValue(2,0,resultList);
        assertThat(resultMove).isEqualTo("");
    }

    @Test
    void 랜덤값_4이상_경주_자동차_이동_테스트() {
        String resultMove = racingGame.decideMoveByRandValue(2,0,resultList);
        assertThat(resultMove).isEqualTo("");
    }

    @Test
    void 게임_단독_우승자_판단_테스트() {
        List<String> winner = new ArrayList<>();
        resultList.set(0,"-");
        resultList.set(1,"--");
        resultList.set(2,"-");
        winner = racingGame.chooseWinners(winner,resultList,cars);

        assertThat(winner).containsExactly("woni");
    }

    @Test
    void 게임_공동_우승자_판단_테스트() {
        List<String> winner = new ArrayList<>();
        resultList.set(0,"-");
        resultList.set(1,"--");
        resultList.set(2,"--");
        winner = racingGame.chooseWinners(winner,resultList,cars);

        assertThat(winner).containsExactly("woni","jin");
    }
}