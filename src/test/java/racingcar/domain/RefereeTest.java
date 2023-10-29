package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStateDto;

class RefereeTest {
    private static final String CARNAME1 = "붕붕카";
    private static final String CARNAME2 = "타요버스";
    private static final String CARNAME3 = "토마토버스";
    private static Referee referee;

    @BeforeAll
    static void init() {
        referee = new Referee();
    }

    @Test
    @DisplayName("우승자한명")
    void 우승자_한_명() {
        String winnerName = CARNAME3;

        List<CarStateDto> dtoList = new ArrayList<>();
        dtoList.add(new CarStateDto(CARNAME1, 1));
        dtoList.add(new CarStateDto(CARNAME2, 2));
        dtoList.add(new CarStateDto(CARNAME3, 3));

        List<String> winner = referee.getWinner(dtoList);
        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner).contains(winnerName);
    }

    @Test
    @DisplayName("공동우승자")
    void 공동_우승자() {
        List<CarStateDto> dtoList = new ArrayList<>();
        dtoList.add(new CarStateDto(CARNAME1, 3));
        dtoList.add(new CarStateDto(CARNAME2, 3));
        dtoList.add(new CarStateDto(CARNAME3, 3));

        List<String> winner = referee.getWinner(dtoList);
        assertThat(winner.size()).isEqualTo(3);
        assertThat(winner).contains(CARNAME1, CARNAME2, CARNAME3);
    }
}