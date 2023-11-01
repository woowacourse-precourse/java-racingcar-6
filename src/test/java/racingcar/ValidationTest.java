package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest extends NsTest {

  @Test
  void 이름_유효성_테스트() {
    // 1글자 미만
    checkNameValidation("", "자동차 이름은 1글자 이상 5글자 이하로 입력해주세요.");
    // 6글자 이상
    checkNameValidation("abcdef", "자동차 이름은 1글자 이상 5글자 이하로 입력해주세요.");
    // 공백 포함
    checkNameValidation("pobi ", "자동차 이름에는 공백을 포함할 수 없습니다.");
    // 중복 이름
    checkNameValidation("pobi,pobi", "같은 이름을 가진 자동차가 있습니다.");
  }

  @Test
  void 시도_유효성_테스트() {
    // 숫자가 아닌 입력값
    checkAttemptValidation("abc", "시도할 회수는 숫자여야 합니다.");
    // 0 이하의 숫자
    checkAttemptValidation("-1", "시도할 회수는 양수여야 합니다.");
    // 공백 포함
    checkAttemptValidation(" 5 ", "시도할 회수는 숫자여야 합니다.");
  }

  private void checkNameValidation(String names, String expectedMessage) {
    assertThatThrownBy(() -> runException(names, "1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(expectedMessage);
  }

  private void checkAttemptValidation(String attempt, String expectedMessage) {
    assertThatThrownBy(() -> runException("pobi", attempt))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(expectedMessage);
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
