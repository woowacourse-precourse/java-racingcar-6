package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

class InputManagerTest {
    DataConverter dataConverter = new DataConverter();

    @Test
    void 자동차_이름_입력_리스트_변환(){
        String input = "밴츠,현대2,아우디a";

        List<String> result = dataConverter.toListString(input);

        assertThat(result).containsExactly("밴츠","현대2","아우디a");
    }

    @Test
    void 시도_횟수_입력_정수_변환(){
        String input = "3";

        int result = Integer.parseInt(input);

        assertThat(result).isEqualTo(3);
    }

}