package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
  private static final int MOVING_FORWARD = 4;
  private static final int STOP = 3;

  @Test
  void 전진_정지() {
    assertRandomNumberInRangeTest(() -> {
      run("pobi,woni", "1");
      assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
    }, MOVING_FORWARD, STOP);
  }

  @Test
  void 이름공백_제거_확인() {
    assertRandomNumberInRangeTest(() -> {
      run("  po  bi ,woni", "1");
      assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
    }, MOVING_FORWARD, STOP);
  }


  @Test
  void 이름길이에_대한_예외_처리() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
        .isInstanceOf(IllegalArgumentException.class));
  }

  @Test
  void 공백입력에_대한_예외_처리() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pob,,lee", "1"))
        .isInstanceOf(IllegalArgumentException.class));
  }

  @Test
  void 중복이름에_대한_예외_처리() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,pobi", "1"))
        .isInstanceOf(IllegalArgumentException.class));
  }

  @Test
  void 시도할_횟수_공백_예외_처리() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,pobi", ""))
        .isInstanceOf(IllegalArgumentException.class));
  }

  @Test
  void 시도할_횟수_문자_예외_처리() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,pobi", "다섯번"))
        .isInstanceOf(IllegalArgumentException.class));
  }

  @Test
  void 시도할_횟수_숫자_예외_처리() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,pobi", "0"))
        .isInstanceOf(IllegalArgumentException.class));
  }

  @Override
  public void runMain() {
    Application.main(new String[] {});
  }
}
