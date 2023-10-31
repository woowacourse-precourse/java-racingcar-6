package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
  private InputView inputView;

  @BeforeEach
  void setUp(){
    inputView = new InputView();
  }
  @Test
  void 자동차이름_5이상(){
    System.setIn(new ByteArrayInputStream("abcdefg, car1, car2".getBytes()));
    assertThatThrownBy(() -> inputView.getCarNames())
            .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 1글자 이상, 5글자 이하여야 한다.");
  }
  @Test
  void 자동차이름_공백(){
    System.setIn(new ByteArrayInputStream("car1, ,car3\n".getBytes()));
    assertThatThrownBy(() -> inputView.getCarNames())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 1글자 이상, 5글자 이하여야 한다.");
  }
  @Test
  void 이름중복(){
    System.setIn(new ByteArrayInputStream("car1, car2, car2\n".getBytes()));
    assertThatThrownBy(() -> inputView.getCarNames())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복된 자동차 이름이 있으면 안 된다.");
  }

  @Test
  void 배열길이확인(){
    System.setIn(new ByteArrayInputStream("car1, car2, car3, car4\n".getBytes()));
    String[] carNames = inputView.getCarNames();
    assertNotNull(carNames);
    assertEquals(4, carNames.length);
    assertArrayEquals(new String[]{"car1", "car2", "car3", "car4"}, carNames);
  }
}