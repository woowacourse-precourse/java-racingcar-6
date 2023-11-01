package racingcar.dto.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;

public class InputDTOTest {

    @Test
    public void createInputDTO_테스트() {
        // 준비
        TrialCount trialCount = TrialCount.of("3");
        Names names = Names.of(new String[]{"hyunjin", "pobi", "lefthand"});

        // 실행
        InputDTO inputDTO = InputDTO.of(trialCount, names);

        // 확인
        Assertions.assertEquals(trialCount, inputDTO.getTrialCount());
        Assertions.assertEquals(names, inputDTO.getNames());
    }
}
