package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;


public class ManualTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void empty_input_is_empty(){
        String input = "";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void empty_input_is_empty_with_sep(){
        String input =",";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void string_is_not_number(){
        String name = "kim,ki,woon";
        String count = "a";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(name, count))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void string_out_of_range_over_5(){
        String name = "kimkiwoon";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(name, "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void string_is_white(){
        String name =" ";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(name, "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void duplicate_name_used() {
        String input = "abc, abc";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void maga_try(){
        String input = "a,b,c,d,e,f,g,h,i,j,k,l,m";
        assertTimeout(Duration.ofSeconds(1), () -> run(input, "1000"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
