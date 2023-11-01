package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.ScoreDto;

class RacingCarServiceTest {
    @Test
    @DisplayName("RaingCars리스트를 ScoreDto리스트로 반환하는지 확인")
    public void testConvertToScoreDtoList() {
        String carNames = "pobi,dobi";
        RacingCarService racingCarService = new RacingCarService(carNames);

        List<ScoreDto> scoreDtoList = racingCarService.convertToScoreDtoList();

        assertThat(scoreDtoList.size()).isEqualTo(2);
        assertThat(scoreDtoList.get(0).getName()).isEqualTo("pobi");
        assertThat(scoreDtoList.get(1).getName()).isEqualTo("dobi");
    }

}
