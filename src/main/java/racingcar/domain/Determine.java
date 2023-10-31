package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Determine {
  public static String winner(List<String> go, List<String> carnames) {
    List<Integer> goCount = new ArrayList<>();
    StringBuilder result = new StringBuilder();

    result.append("최종 우승자 : ");
    for (String s : go) {
      goCount.add(s.length());
    }

    int maxNum = Collections.max(goCount);

    result.append(carnames.get(goCount.indexOf(maxNum)));

    for (int i = goCount.indexOf(maxNum) + 1; i < go.size(); i++) {
      if (goCount.get(i) == maxNum) {
        result.append(", ").append(carnames.get(i));
      }
    }

    return result.toString();

  }

}
