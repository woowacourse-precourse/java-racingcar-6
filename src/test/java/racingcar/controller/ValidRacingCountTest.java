package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.model.RemainRacingCount;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidRacingCountTest {

    AppConfig appConfig = new AppConfig();
    ValidRacingCount validRacingCount = appConfig.validRacingCount();

    @Test
    void 올바른_경기_숫자_입력() {

        String s = "12";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);

        RemainRacingCount r = validRacingCount.getValidRacingCount();
        Assertions.assertThat(r.getRemainRacingCount()).isEqualTo(12);

        Console.close();
    }

    @Test
    void 음수_경기_숫자_입력() {

        String s = "-12";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> validRacingCount.getValidRacingCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수가 아닌 입력입니다");

        Console.close();
    }

    @Test
    void 소수점_경기_숫자_입력() {

        String s = "1.2";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> validRacingCount.getValidRacingCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수가 아닌 입력입니다");

        Console.close();
    }

    @Test
    void 영_경기_숫자_입력() {

        String s = "0";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> validRacingCount.getValidRacingCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수가 아닌 입력입니다");

        Console.close();
    }

    @Test
    void 문자_경기_숫자_입력() {

        String s = "테스트";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> validRacingCount.getValidRacingCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수가 아닌 입력입니다");

        Console.close();
    }

}
