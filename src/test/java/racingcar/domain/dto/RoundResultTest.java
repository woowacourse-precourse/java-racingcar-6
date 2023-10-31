package racingcar.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundResultTest {
    List<CarResult> carResultList;
    RoundResult roundResult;

    @BeforeEach
    void setUp() {
        carResultList = List.of(
                CarResult.of(new Name("pobi"), new Position(1)),
                CarResult.of(new Name("crong"), new Position(1))
        );
        roundResult = RoundResult.of(carResultList);
    }

    @Test
    void 라운드_결과를_나타내는_roundResult() {
        List<CarResult> compareCarResultList = List.of(
                CarResult.of(new Name("pobi"), new Position(1)),
                CarResult.of(new Name("crong"), new Position(1))
        );
        assertThat(roundResult).isEqualTo(new RoundResult(compareCarResultList));
    }

    @Test
    void RoundResult의_toString을_실행하면_라운드_결과를_문자열로_반환한다() {
        assertThat(roundResult.toString()).isEqualTo("pobi : -\ncrong : -\n");
    }

    @Test
    void 해당_라운드의_우승자를_반환한다() {
        assertThat(roundResult.getWinner()).isEqualTo(List.of(
                new Name("pobi"),
                new Name("crong"))
        );
    }

    @Test
    void 해당_라운드의_우승자는_한_명일수_있다(){
        carResultList = List.of(
                CarResult.of(new Name("pobi"), new Position(1)),
                CarResult.of(new Name("crong"), new Position(1)),
                CarResult.of(new Name("honux"), new Position(2))
        );
        roundResult = RoundResult.of(carResultList);
        assertThat(roundResult.getWinner()).isEqualTo(List.of(new Name("honux")));
    }
}