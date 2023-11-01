package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Name;
import racingcar.domain.car.NameParser;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class NameParserTest {
    private final NameParser nameParser = new NameParser();

    @Test
    @DisplayName(",로 구분된 문자열을 입력받으면 파싱하여 리스트로 반환하는 것을 성공한다.")
    void parseName_StringCarNames_Success(){
        String carNames = "가가,나나";
        List<Name> answers =
                Arrays.stream(carNames.split(","))
                .map(Name::new)
                .toList();

        List<Name> results = nameParser.parseName(carNames);

        assertThat(results).hasSize(2);
        assertThat(results).containsExactlyInAnyOrderElementsOf(answers);
    }

    @Test
    @DisplayName("자동차 이름이 1개인 경우 파싱하여 리스트로 반환하는 것을 실패한다.")
    void parseName_StringCarNames1_ThrowIllegalArgumentException(){
        String carNames = "가가";

        Assertions.assertThatThrownBy(() -> nameParser.parseName(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 문자열이 들어올 경우 파싱하여 리스트로 반환하는 것을 실패한다.")
    @ValueSource(strings = {
            ",,,",
            "가가,"
    })
    void parseName_StringCarNames2_ThrowIllegalArgumentException(String data){

        Assertions.assertThatThrownBy(() -> nameParser.parseName(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는 2명 이상이어야 합니다.");
    }

}
