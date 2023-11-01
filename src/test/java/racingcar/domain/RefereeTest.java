package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

  @Test
  void split_입력테스트1() {
    String input = ",,,,,";
    List<String> result = Arrays.asList(input.split(","));

    assertThat(result).isEmpty();
  }

  @Test
  void split_입력테스트2() {
    String input = "hwang,seong,heon,,,";
    List<String> result = Arrays.asList(input.split(","));

    assertThat(result.size()).isEqualTo(3);
    assertThat(result).containsExactly("hwang","seong","heon");
  }
}