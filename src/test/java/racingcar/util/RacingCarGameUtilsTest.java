package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.util.RacingCarGameUtils.convertStringToInt;
import static racingcar.util.RacingCarGameUtils.convertStringToList;
import static racingcar.util.RacingCarGameUtils.generateRandomValuesForCarGame;
import static racingcar.util.RacingCarGameUtils.joinStringWithComma;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingCarGameUtilsTest {

  @Test
  @DisplayName("[Success] 들어온 문자열에 대해 ','로 나누어 리스트를 만들어 반환한다.")
  void 쉼표로_분리된_문자열을_나눈다() {
    // given
    String strWithRegex = "abcd,efgh,ijkl,mnop";

    // when
    List<String> expectedList = Arrays.asList("abcd", "efgh", "ijkl", "mnop");
    List<String> actualList = convertStringToList(strWithRegex);

    // then
    assertThat(actualList).isEqualTo(expectedList);

  }

  @Test
  @DisplayName("[Success] 문자열을 숫자로 바꾼다.")
  void 문자열_형태인_숫자를_숫자로_바꾼다() {
    // given
    String strInteger = "123";

    // when
    Integer actualVar = convertStringToInt(strInteger);
    Integer expected = 123;

    // then
    assertThat(actualVar).isEqualTo(expected);
  }

  @Test
  @DisplayName("[Success] 유효한 범위 내의 랜덤값을 입력받은 개수만큼 생성한다.")
  void 라운드마다_차에게_할당되는_랜덤값을_생성한다() {
    // given
    final Integer carCount = 10;

    // when
    List<Integer> actualList = generateRandomValuesForCarGame(carCount);

    // then
    assertThat(actualList.size()).isEqualTo(carCount);
  }

  @ParameterizedTest
  @DisplayName("[Success] 우승자 목록을 바탕으로 우승자 출력 포맷을 생성한다.")
  @CsvSource({
      "우승자1, 우승자1",
      "'우승자1,우승자2', '우승자1, 우승자2'"
  })
  void testJoinStringWithComma(String winnersInput, String expectedOutput) {
    // given
    List<String> winners = Arrays.asList(winnersInput.split(","));

    // when
    String actual = RacingCarGameUtils.joinStringWithComma(winners).toString();

    // then
    assertThat(actual).isEqualTo(expectedOutput);
  }
}