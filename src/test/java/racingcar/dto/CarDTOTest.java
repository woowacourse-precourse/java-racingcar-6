package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarDTOTest {

    @DisplayName("CarDTO.ProgressResult 테스트")
    @Test
    void progressResultTest() {

        // given
        CarDTO.ProgressResult progressResult = new CarDTO.ProgressResult(new ArrayList<>());

        // when
        int iterateCount = 10;
        for (int i = 0; i < iterateCount; i++) {
            progressResult.addResult(new HashMap<>());
        }

        // then
        List<Map<String, Integer>> result = progressResult.getResult();
        assertThat(result.size()).isEqualTo(iterateCount);
    }
}