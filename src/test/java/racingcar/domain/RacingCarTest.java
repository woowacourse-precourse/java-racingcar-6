package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("레이싱에 속한 자동차들의 경주 결과 출력 문자열을 생성한다.")
    @Test
    void getResultMessage() {
        //given
        final List<String> names = Arrays.asList("bonsi", "soeun", "left");
        final String predictionMessage = createResultMessage(names);

        RacingCar racingCar = new RacingCar(names);

        //when
        String resultMessage = racingCar.getResultMessage();

        //then
        assertThat(resultMessage).isEqualTo(predictionMessage);
    }

    private String createResultMessage(List<String> names){
        return names.stream()
                .map(n -> n + " : ")
                .collect(Collectors.joining("\n"));
    }

}