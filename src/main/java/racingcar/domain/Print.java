package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;

public class Print {
  public static String printExecute(List<String> carNames, List<String> go) {

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < carNames.size(); i++) {

      int num = pickNumberInRange(0, 9);
      if (num >= 4) {
        go.set(i, go.get(i) + "-");
      }
      sb.append(carNames.get(i) + " : " + go.get(i)).append("\n");
    }

    return sb.toString();
  }
}