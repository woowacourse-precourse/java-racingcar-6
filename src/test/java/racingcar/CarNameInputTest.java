package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameInputTest {
    @ParameterizedTest
    @ValueSource(strings = {"부릉이,따릉이,딸랑이"})
    @DisplayName ("경주할 자동차 이름입력 정상동작 테스트")
    void canGetCarNameGeneralTest(String testInput) {
        String[] answer = {"부릉이", "따릉이", "딸랑이"};
        RacingSetting racingSetting = new RacingSetting();

        InputStream test = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(test);
        assertArrayEquals(answer, racingSetting.getName());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (입력이 없을때)")
    void canHandleEmptyInputCarNameExceptionTest(String testInput) {
        RacingSetting racingSetting = new RacingSetting();

        InputStream test = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(test);
        assertThatThrownBy(racingSetting::getName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 개수가 너무 적습니다 최소 하나라도 입력해 주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"부릉이,,", "부릉이,", "부릉이,,따릉이", ",부릉이"})
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (쉼표가 나오고 자동차 이름이 나오지않은경우)")
    void canHandleNotInputCarNameExceptionTest(String testInput) {
        RacingSetting racingSetting = new RacingSetting();

        InputStream test = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(test);
        assertThatThrownBy(racingSetting::getName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (이름에 공백만 들어온 경우)")
    void canHandleOnlyWhiteSpaceCarNameExceptionTest(String testInput) {
        assertThatThrownBy(() -> new Car(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"부릉부릉부릉"})
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (이름이 너무 긴 경우)")
    void canHandleOverLengthCarNameExceptionTest(String testInput) {
        final int MAX_CAR_NAME = 5;
        assertThatThrownBy(() -> new Car(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 이름이 너무 깁니다 이름 최대 길이 " + MAX_CAR_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"부릉이,부릉이"})
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (중복된 이름이 들어온 경우)")
    void canHandleDuplicateCarNameExceptionTest(String testInput) {
        RacingSetting racingSetting = new RacingSetting();

        InputStream test = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(test);
        assertThatThrownBy(() -> racingSetting.getName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 이름이 중복되었습니다 중복되지않게 적어주세요");
    }
}
