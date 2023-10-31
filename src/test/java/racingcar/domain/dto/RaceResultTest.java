package racingcar.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceResultTest {
    List<RoundResult> roundResultList;
    RaceResult raceResult;

    @BeforeEach
    void setUp(){
        RoundResult roundOneCarResult = RoundResult.of(
                List.of(
                        CarResult.of(new Name("pobi"), new Position(1)),
                        CarResult.of(new Name("crong"), new Position(1)))
        );

        RoundResult roundTwoCarResult = RoundResult.of(
                List.of(
                        CarResult.of(new Name("pobi"), new Position(2)),
                        CarResult.of(new Name("crong"), new Position(2)))
        );

        roundResultList = List.of(roundOneCarResult, roundTwoCarResult);
        raceResult = RaceResult.of(roundResultList);
    }

    @Test
    void 해당_레이싱_게임_결과와_과정을_담는_레코드(){
        assertThat(raceResult).isEqualTo(RaceResult.of(roundResultList));
    }

    @Test
    void 해당_레이싱_게임_과정과_최종_우승자를_문자열로_반환하여_보여준다(){
        assertThat(raceResult.toString()).isEqualTo("pobi : -\ncrong : -\n\n\npobi : --\ncrong : --\n\n최종 우승자 : pobi, crong");
    }
}