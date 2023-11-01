package modules;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingcarExceptionTest {
  @Test
  void car_개수가_2_미만인_경우_예외_처리() {
    String[] input = {""};
    assertSimpleTest(() ->
            assertThatThrownBy(() -> RacingcarException.exception_len_under_2(input))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void car_이름의_길이가_5를_초과한_경우_예외_처리() {
    String input = "someone_name_over_5";
    assertSimpleTest(() ->
            assertThatThrownBy(() -> RacingcarException.exception_len_5(input))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void car_이름에_중복이_있을_경우_예외_처리() {
    String[] input = {"pobi", "woni", "pobi"};
    assertSimpleTest(() ->
            assertThatThrownBy(() -> RacingcarException.exception_same_name(input))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void 횟수로_받은_값이_int로_변환이_안될_경우_예외_처리() {
    String input = "string";
    assertSimpleTest(() ->
            assertThatThrownBy(() -> RacingcarException.exception_not_int(input))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void int_변수에_음수가_있을_경우_예외_처리() {
    String input = "-1";
    assertSimpleTest(() ->
            assertThatThrownBy(() -> RacingcarException.exception_negative(input))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }
}
