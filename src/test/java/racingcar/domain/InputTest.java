package racingcar.domain;
import camp.nextstep.edu.missionutils.test.NsTest;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @Test
    void getCarName() {

        Input input = new Input();
        String carnames = "pobi,woni,jun";

        //"," 기준 split 되었는가
        List<String> result = input.getCarName(carnames);
        assertThat(result).contains("pobi", "woni","jun");
        assertThat(result).containsExactly("pobi", "woni","jun");

        //단일 문자열입력이 들어오면 그대로 출력하는가
        carnames = "pobi";
        result = input.getCarName(carnames);
        assertThat(result).contains("pobi");
    }

    @Test
    void getCountYouWantTry() {

        Input input = new Input();

        //Integer 형식으로 반환했는가
        String CountYouWantTry = "24";
        Integer result = input.getCountYouWantTry(CountYouWantTry);
        assertThat(result).isEqualTo(24);
    }
}