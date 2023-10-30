package racingcar;

import camp.nextstep.edu.missionutils.Console;
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
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void inputCarNameValidation() {
      IllegalArgumentException illegalArgumentException = null;
      String input = "테스트1,테스트2,테스트3";
      String[] cars = input.split(",");
      assertThat(cars[2]).isEqualTo("테스트3");

      for (String car: cars) {
        if (car.length()>5){
          illegalArgumentException = new IllegalArgumentException("자동차이름 5자 이하만 가능합니다.");
        }
      }
      assertThat(illegalArgumentException).isEqualTo(null);
    }

  @Test
  void inputCarNameSplit() {
    String inputCarName = "테스트1,테스트2";
    String[] cars = inputCarName.split(",");
    if(cars.length<2){
      throw new IllegalArgumentException("이름은 쉼표(,) 기준으로 구분합니다.");
    }
    assertThat(cars.length).isEqualTo(2);
    assertThat(cars).contains("테스트2", "테스트1");
    assertThat(cars).containsExactly("테스트1", "테스트2");

  }
}
