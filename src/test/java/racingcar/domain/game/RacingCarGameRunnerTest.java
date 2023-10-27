package racingcar.domain.game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameRunnerTest {

    @Test
    public void 입력받은_자동차_이름을_comma_기준으로_분리하는_기능() {
        // given
        String input = "app, band, cat, dog, egg";

        //when
        List<String> tmpNameList = Arrays.stream(input.split(", *")).toList();
        List<String> resultList = tmpNameList.stream()
                .filter(name -> !name.isBlank())
                .toList();

        //then
        assertThat(resultList).containsExactly("app", "band", "cat", "dog", "egg");
    }

    @Test
    public void 입력받은_자동차_이름에_있는_빈_문자열은_제외하는_기능() {
        // given
        String input = "app,,    ,  cat, dog, egg";

        //when
        List<String> tmpNameList = Arrays.stream(input.split(", *")).toList();
        List<String> resultList = tmpNameList.stream()
                .filter(name -> !name.isBlank())
                .toList();

        //then
        assertThat(resultList).containsExactly("app", "cat", "dog", "egg");
    }
}