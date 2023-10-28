package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsValidatorTest {
    @DisplayName("validate 정상 처리 확인.")
    @Test
    void inputCarNames_이름입력_통합() {
        //given
        CarsValidator validator = CarsValidator.INSTANCE;
        String inputNames = "pobi,woni,jun,james,timmy,ski";
        String[] expected = inputNames.split(",");

        //when
        List<String> result = validator.validate(inputNames);

        //then
        result.stream()
                .forEach((name) -> assertThat(expected).contains(name));
    }
}
