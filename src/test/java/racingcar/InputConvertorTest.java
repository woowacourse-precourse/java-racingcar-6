package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.RaceCount;
import racingcar.dto.PlayerNamesDto;
import racingcar.util.InputConvertor;

public class InputConvertorTest {

    @Test
    void 콤마로_구분된_플레이어_이름이_들어오면_dto로_반환한다() {
        PlayerNamesDto playerNamesDto = InputConvertor.convertPlayerNames("rose,lisa");
        assertThat(playerNamesDto.getPlayerNames()).containsExactly("rose", "lisa");
    }

    @Test
    void 문자열로_레이스_시도횟수가_들어오면_시도횟수_객체로_반환한다() {
        RaceCount raceCount = InputConvertor.convertRaceCount("1");
        assertThat(raceCount).isEqualTo(RaceCount.from(1));
    }
}
