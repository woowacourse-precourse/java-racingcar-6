package racingcar.domainTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class UserConsoleTest extends NsTest {

  @Test
  void 이름입력_받기와_처리() {
    assertSimpleTest(() -> {
      run("pobi,minju", "1");

      assertThat(output()).contains("minju :");
      assertThat(output()).contains("pobi : ");
    });

  }

  @Test
  void 실시횟수_입력받고_저장() {
    assertSimpleTest(() -> {
      run("pobi,minju", "1");
      String result = output();
      int roundsCount = 0;
      roundsCount += (result.length() - result.replace("pobi", "").length()) / 4;

      assertThat(roundsCount < 3).isTrue();
      assertThat(roundsCount > 0).isTrue();
    });
  }

  @Test
  void 최대_길이를_넘어가는_이름_입력에_대한_처리() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,minjulee", "1"))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void 공백으로만_구성된_이름_입력에_대한_처리() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException(" , , ", "2"))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void 한명의_이름만_입력되었을때의_처리() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi", "2"))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void 올바르지_않은_라운드_수를_입력했을때의_처리() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,minju", "0"))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void 숫자가_아닌_라운드를_입력했을때의_처리() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,minju", "둘"))
            .isInstanceOf(NumberFormatException.class)
    );
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }

}
