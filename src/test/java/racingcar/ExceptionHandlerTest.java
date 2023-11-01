package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class ExceptionHandlerTest {

  private final ExceptionHandler exceptionHandler = new ExceptionHandler();


  @DisplayName("자동차 이름 입력에 대한 예외처리 테스트")
  @ParameterizedTest
  @MethodSource("readCarName")
  void carNameExceptionTest(String carName) {
    assertThatThrownBy(() -> exceptionHandler.carNameException(carName))
      .isInstanceOf(IllegalArgumentException.class);
  }

  static Stream<Arguments> readCarName() {
    return Stream.of(
      Arguments.of(""),  // 아무것도 입력하지 않음
      Arguments.of("abc,abcdef"),  // 이름이 5자가 넘어감
      Arguments.of("a,b,5c,d,e")  // 알파벳 이외에 입력함
    );
  }

}