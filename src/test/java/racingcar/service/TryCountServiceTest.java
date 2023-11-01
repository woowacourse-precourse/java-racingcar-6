package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TryCountServiceTest {

    TryCountService tryCountService = new TryCountService();

    @Test
    public void 시도횟수_입력_없음_예외_처리() {
        // given
        String string_try_count = "";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountService.convert_StringToPositiveInt(string_try_count);
        });
    }

    @Test
    public void 시도횟수_소수_또는_문자_입력_예외_처리() {
        // given
        String string_try_count1 = "1.1";
        String string_try_count2 = "a";
        String string_try_count3 = " ";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountService.convert_StringToPositiveInt(string_try_count1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountService.convert_StringToPositiveInt(string_try_count2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountService.convert_StringToPositiveInt(string_try_count3);
        });
    }

    @Test
    public void 시도횟수_0_또는_음수_입력_예외_처리() {
        // given
        String string_try_count1 = "0";
        String string_try_count2 = "-1";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountService.convert_StringToPositiveInt(string_try_count1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountService.convert_StringToPositiveInt(string_try_count2);
        });
    }

    @Test
    public void 시도횟수_정상입력() {
        // given
        String string_try_count1 = "3";
        String string_try_count2 = "005";

        // when
        int int_try_count1 = tryCountService.convert_StringToPositiveInt(string_try_count1);
        int int_try_count2 = tryCountService.convert_StringToPositiveInt(string_try_count2);

        // then
        assertThat(int_try_count1).isEqualTo(3);
        assertThat(int_try_count2).isEqualTo(5);
    }
}