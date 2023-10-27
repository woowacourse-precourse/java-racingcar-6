package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarController;
import racingcar.dto.CarNameDto;
import racingcar.model.CarGenerator;

public class InputTest {
    RacingCarController racingCarController = new RacingCarController();

    @Test
    void 사용자_입력에서_자동차_이름을_추출한다() {
        String userInput = "a,b,c";
        List<String> carNameList = Arrays.stream(userInput.split(",")).toList();

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        List<CarNameDto> carNameDtoList = racingCarController.splitCarName();
        List<String> generatedCarNameList = carNameDtoList.stream()
                .map(CarNameDto::getCarName)
                .toList();

        assertThat(carNameList).isEqualTo(generatedCarNameList);
    }

    @Test
    void 자동차_이름이_중복되면_안된다() {
        String userInput = "ab,ab, c";
        CarGenerator carGenerator = new CarGenerator(userInput);
        assertThatThrownBy(carGenerator::generateCarNameList)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백은_자동차_이름이_될수없다() {
        String userInput = ", ,,";
        CarGenerator carGenerator = new CarGenerator(userInput);
        assertThatThrownBy(carGenerator::generateCarNameList)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 자동차_이름은_5자_이하여야한다() {
        String userInput = "ababab, c, d";
        CarGenerator carGenerator = new CarGenerator(userInput);
        assertThatThrownBy(carGenerator::generateCarNameList)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
