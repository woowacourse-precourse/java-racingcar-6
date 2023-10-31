package modules;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class racingcarModulesTest {
  @Test
  void 랜덤_숫자가_4_이상이면_한_칸_앞으로() {
    int[] random_num_input = {1, 4, 5, 1};
    int result = 0;
    for (int num : random_num_input) {
      result += racingcarModules.checked_random_num_over_4(num);
    }

    assertThat(result).isEqualTo(2);
  }
}
