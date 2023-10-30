package racingcar.util;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.constant.CarStatus;
import static org.assertj.core.api.Assertions.assertThat;

class CalculationTest {
    private static Calculation calculation;

    @BeforeAll()
    static void Calculation_객체_생성() {
        calculation = new Calculation();
    }

    @Test
    void 랜덤숫자에_따른_이동여부_1이면_중지() {
        CarStatus result = calculation.judgeCarMoveOrStop(1);
        assertThat(result).isEqualTo(CarStatus.STOP);
    }
    @Test
    void 랜덤숫자에_따른_이동여부_3이면_중지() {
        CarStatus result = calculation.judgeCarMoveOrStop(3);
        assertThat(result).isEqualTo(CarStatus.STOP);
    }
    @Test
    void 랜덤숫자에_따른_이동여부_4이면_이동() {
        CarStatus result = calculation.judgeCarMoveOrStop(4);
        assertThat(result).isEqualTo(CarStatus.MOVE);
    }
    @Test
    void 랜덤숫자에_따른_이동여부_5이면_이동() {
        CarStatus result = calculation.judgeCarMoveOrStop(5);
        assertThat(result).isEqualTo(CarStatus.MOVE);
    }
    @Test
    void 랜덤숫자에_따른_이동여부_9이면_이동() {
        CarStatus result = calculation.judgeCarMoveOrStop(9);
        assertThat(result).isEqualTo(CarStatus.MOVE);
    }



}