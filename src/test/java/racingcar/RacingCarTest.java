package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RacingCarTest {
    private String test_name = "test_name";
    private RacingCar car;

    @BeforeEach
    void setUp(){
        car = new RacingCar(test_name);
    }

    @Test
    public void getLoc() { //시작 위치 + 값 불러오기 테스트
        int result = car.getLoc();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void getName() {
        String result = car.getName();
        assertThat(result).isEqualTo(test_name);
    }

    @Test
    void accel() {  // 랜덤하게 나온 값이 n일때 이동거리가 l로 나오는지 테스트
        int before = car.getLoc();
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(3);

        car.accel();
        int after = car.getLoc();
        int result = after-before;
        assertThat(result).isEqualTo(0);
    }
}