package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
import racingcar.view.OutputView;

public class RacingCarTest {

    @DisplayName("자동차 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    public void validateCarNameLengthOverflow() {
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("validateCarNameDuplicate")
    @Test
    public void validateCarNameDuplicate() {
        assertThatThrownBy(() -> {
            String[] carList = {"1234", "1234"};
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 빈 문자열 일 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "    "})
    @Test
    public void checkCarNameBlank() {
        assertThatThrownBy(() -> {
            new Car(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(" 시도 횟수는 1이상 이어야 한다.")
    @Test
    public void checkMoveCount() {
        assertThatThrownBy(() -> {
            new MoveCount(0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertDoesNotThrow(() -> {
            new MoveCount(2);
        });
    }

    @DisplayName("우승자 출력 포맷을 확인한다 . 우승자는 한명 또는 여러명 일 수 있다.")
    @Test
    public void checkWinnerFormat() {
        List<String> winnerOnlyOne = List.of("a");
        assertThat(OutputView.winnerPrintFormat(winnerOnlyOne)).isEqualTo("최종 우승자 : a");
        List<String> winnersMany = List.of("a", "b", "c");
        assertThat(OutputView.winnerPrintFormat(winnersMany)).isEqualTo("최종 우승자 : a, b, c");
    }

    @DisplayName("4 이상일 때 자동차는 position이 1 증가한다.")
    @Test
    public void movePosition() {
        Car car = new Car("a");
        int position1 = car.getPosition();

        car.move(4);
        int position2 = car.getPosition();
        assertThat(position1 + 1).isEqualTo(position2);

        car.move(3);
        int position3 = car.getPosition();
        assertThat(position3).isEqualTo(position2);

    }


}
