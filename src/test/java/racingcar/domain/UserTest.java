package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserTest {

    @Test
    void 자동차_입력값_Cars로_가져오기_test(){
        User user = new User();
        String input = "pobi,anti,noel";
        Map<String, Integer> result = user.getCars(input);

        Map<String, Integer> expect = new LinkedHashMap<>();
        expect.put("pobi",0);
        expect.put("anti",0);
        expect.put("noel",0);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 게임횟수_입력값_가져오기_test(){
        User user = new User();
        String input = "3";
        int result = user.getGameCount(input);
        assertThat(result).isEqualTo(3);
    }
}
