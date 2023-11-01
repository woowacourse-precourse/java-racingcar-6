package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;


class OutputValuesTest {
    OutputValues outputValues = new OutputValues();


    @Test
    void carNameOutput() {
        String carTestName = "test";
        Assertions.assertThat(outputValues.carNameOutput(carTestName)).isEqualTo(carTestName);
    }

    @Test
    void carMovementOutput() {
    }

    @Test
    void carRaceWinnerOutput() {
    }

    @Test
    void runResultOutput() {
    }
}