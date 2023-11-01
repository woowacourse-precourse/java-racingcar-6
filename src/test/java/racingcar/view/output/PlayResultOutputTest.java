package racingcar.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.dto.CarDto;

class PlayResultOutputTest {
    @ParameterizedTest
    @CsvSource(value = {"0:''", "1:-", "2:--"}, delimiter = ':')
    void CarDto를_입력받아_경기_결과_출력_문자열을_포맷팅한다(int moveCount, String expectedPositionOutput) {
        Car car = Car.from("melon");
        IntStream.range(0, moveCount)
                .forEach(ignored -> car.move(() -> true));

        PlayResultOutput playResultOutput = PlayResultOutput.from(CarDto.from(car));

        assertThat(playResultOutput.output()).isEqualTo("melon : " + expectedPositionOutput);
    }
}
