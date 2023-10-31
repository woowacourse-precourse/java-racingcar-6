package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarList;
import racingcar.validation.RacingCarValidation;

import java.io.ByteArrayInputStream;

import static java.lang.System.*;
import static org.assertj.core.api.Assertions.*;

class RacingCarServiceTest {

    public RacingCarService racingCarService;

    public RacingCarServiceTest() {
        this.racingCarService = new RacingCarService(new CarList(), new RacingCarValidation());
    }

    @Test
    @DisplayName("경기 횟수 입력(숫자) - 성공")
    public void read_count_success() {
        //given
        String inputCount = "5";
        setIn(new ByteArrayInputStream(inputCount.getBytes()));

        //when
        int count = racingCarService.readCount();

        //then
        assertThat(count).isEqualTo(Integer.parseInt(inputCount));

        Console.close();
    }

    @Test
    @DisplayName("경기 횟수 입력(숫자x) - 실패")
    public void read_count_no_digit_fail() {
        //given
        String inputCount = "noDigit";
        setIn(new ByteArrayInputStream(inputCount.getBytes()));

        //when&then
        assertThatThrownBy(() -> racingCarService.readCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 값은 숫자여야 합니다.");

        Console.close();
    }

    @Test
    @DisplayName("경기 횟수 입력(범위 밖) - 실패")
    public void read_count_out_range_fail() {
        //given
        String inputCount = "10001";
        setIn(new ByteArrayInputStream(inputCount.getBytes()));

        //when&then
        assertThatThrownBy(() -> racingCarService.readCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 값은 범위 내에서 실행할 수 없는 값입니다. (1 ~ 10000)");

        Console.close();
    }

}