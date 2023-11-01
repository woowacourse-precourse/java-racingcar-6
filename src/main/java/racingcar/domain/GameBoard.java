package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameBoard {

  public static final String COLON = " : ";
  public static final String NEW_LINE = "\n";
  private static final String SCORE_BAR = "-";


  private final Map<String, Integer> board = new ConcurrentHashMap<>();

  public void update(List<Car> nextRace) {

    for (Car nextCar : nextRace) {
      String nextCarName = nextCar.getName();
      int nextScore = nextCar.getPosition();
      // 이전 경주 기록에서 새로운 자동차의 이름을 통해 점수를 업데이트
      this.board.put(nextCarName, nextScore);
    }

  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (String carName : board.keySet()) {
      int score = board.get(carName);
      sb.append(carName);
      sb.append(COLON);
      sb.append(String.join("", Collections.nCopies(score, SCORE_BAR)));
      sb.append(NEW_LINE);
    }

    return sb.toString();
  }
}
