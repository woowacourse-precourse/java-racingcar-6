package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgement {

  public List<String> judgeWinner(List<Car> carLineUp) {
    List<String> winners = new ArrayList<>();
    int maxPoint = findMaxPoint(carLineUp);
    for (int i = 0; i < carLineUp.size(); i++) {
      if (carLineUp.get(i).isWinner(maxPoint)) {
        winners.add(carLineUp.get(i).getName());
      }
    }
    return winners;
  }

  private int findMaxPoint(List<Car> carLineUP) {
    int maxPoint = 0;
    for (int i = 0; i < carLineUP.size(); i++) {
      maxPoint = Math.max(maxPoint, carLineUP.get(i).getProgress());
    }
    return maxPoint;
  }
}
