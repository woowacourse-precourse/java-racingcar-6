package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class parser {

  public List<String> parseCarNames(String input) {
    // 원하는 리스트 형식으로 변환한다
    return new ArrayList<>(Arrays.asList(input.split(",")));
  }

  public int parseNumberOfTrial(String input) {
    return Integer.parseInt(input);
  }
}
