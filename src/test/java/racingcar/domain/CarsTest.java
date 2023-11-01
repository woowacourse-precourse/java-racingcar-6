package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.mock.MockNumberGenerator;
import racingcar.provider.TestProvider;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {

    private Cars testCars;

    private MockNumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        String testCarNames = "pobi,crong,honux";
        numberGenerator = TestProvider.createMockNumberGenerator(false);
        testCars = TestProvider.createTestCars(testCarNames, numberGenerator);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("자동차 이름에 null 값이 들어오면 split 시 예외가 발생한다.")
    void givenNullCarNames_thenFail(final String carNames) {
        assertThatThrownBy(() -> Cars.create(carNames, numberGenerator))
                .isInstanceOf(NullPointerException.class);
    }

}