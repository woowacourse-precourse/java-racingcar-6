package racingcar.dto.output;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnerDTOTest {

    @Test
    public void createWinnerDTO_테스트() {
        // 준비
        List<String> winnerNames = Arrays.asList("hyunjin", "pobi", "lefthand");

        // 실행
        WinnerDTO winnerDTO = WinnerDTO.of(winnerNames);

        // 확인
        assertEquals(winnerNames, winnerDTO.getNames());
    }
}
