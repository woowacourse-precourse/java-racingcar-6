package modules;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

  @Test
  void 우승자_리스트로_출력() {
    HashMap<String, Integer> input = new HashMap<String, Integer>() {{
      put("pobi", 5); put("woni", 4); put("jun", 5);
    }};
    List<String> result = new ArrayList<>() {{
      add("pobi"); add("jun");
    }};

    List<String> input_result = racingcarModules.campion_racing(input);
    assertThat(result).isEqualTo(input_result);
  }
}
