package modules;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class racingcarExceptionTest {
  @Test
  void car_개수가_0인_경우_예외_처리() {
    String[] input = {""};
    assertSimpleTest(() ->
            assertThatThrownBy(() -> modules.racingcarException.exception_len_0(input))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }
}
