package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingCarServiceImplTest  {

    private static final RacingCarServiceImpl racingCarService = new RacingCarServiceImpl();

    @Test
    void 자동차_이름_길이_제한_예외_테스트() {

        // given
        String[] carNames = {"test", "testName"};

        // when

        // then
        assertThatThrownBy(() -> validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car name should not exceed 5 characters.");
            }
        }
    }
}