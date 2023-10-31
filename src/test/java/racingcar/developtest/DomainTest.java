package racingcar.developtest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong"})
    void stringToListByComma_콤마를_기준으로_문자열을_리스트로_변환(String string) {
        CarFactory carFactory = new CarFactory();
        List<String> result = carFactory.stringtoListByComma(string);
        assertThat(result.toString()).isEqualTo(Arrays.asList("pobi", "crong").toString());
    }
}
