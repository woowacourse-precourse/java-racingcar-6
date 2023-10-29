package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Cars;
import racingcar.view.InputView;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {

    @ParameterizedTest
    @MethodSource("provideNamesForValidate")
    void 자동차_이름_입력값_검증_테스트(String[] carNames) {
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNamesForValidate() {
        return Stream.of(
                Arguments.of((Object) new String[] {"jy", "jy", "wb"}),
                Arguments.of((Object) new String[] {"jy", "juyeon", "wb"}),
                Arguments.of((Object) new String[] {"jy", "", "wb"}),
                Arguments.of((Object) new String[] {"jy", " ", "wb"})
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"+4", "ss", "-1", "0"})
    void 라운드_수_입력값_검증_테스트(String input) {
        generateInput(input);
        assertThatThrownBy(InputView::inputRoundNumber)
                .isInstanceOf(IllegalArgumentException.class);

        Console.close();
    }

    private void generateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 라운드_하나_실행_테스트() {
        // given
        String[] carNames = {"jy", "wb"};
        Cars cars = Cars.from(carNames);
        int initialPosition1 = cars.getCars().get(0).getPosition();
        int initialPosition2 = cars.getCars().get(1).getPosition();

        // when
        cars.playRound();

        // then
        int currentPosition1 = cars.getCars().get(0).getPosition();
        int currentPosition2 = cars.getCars().get(1).getPosition();
        assertThat(currentPosition1).isIn(initialPosition1, initialPosition1 + 1);
        assertThat(currentPosition2).isIn(initialPosition2, initialPosition2 + 1);
    }
}
