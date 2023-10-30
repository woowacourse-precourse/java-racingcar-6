package tool;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomTest {

  @Test
  @RepeatedTest(100)
  void isRandOverValueInRange_지정된_값_이상이면_true_반환() {
    boolean bool = Random.isRandOverValueInRange(4, 10, 4);

    assertThat(bool).isEqualTo(true);
  }

  @Test
  @RepeatedTest(100)
  void isRandOverValueInRange_지정된_값_이하면_false_반환() {
    boolean bool = Random.isRandOverValueInRange(0, 3, 4);

    assertThat(bool).isEqualTo(false);
  }
}
