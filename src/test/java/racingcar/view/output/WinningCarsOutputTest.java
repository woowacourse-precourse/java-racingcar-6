package racingcar.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.dto.CarDto;

class WinningCarsOutputTest {
    @Test
    void CarDto리스트를_입력받아_우승_자동차_출력_문자열을_포맷팅한다() {
        List<CarDto> carDtos = Cars.from(List.of("melon", "apple")).dtos();
        WinningCarsOutput winningCarsOutput = WinningCarsOutput.from(carDtos);

        assertThat(winningCarsOutput.output()).isEqualTo("최종 우승자 : melon, apple");
    }
}
