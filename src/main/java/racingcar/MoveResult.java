package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class MoveResult {
  public void move(List<String> carNames, int attemptNumber) {
    System.out.println("실행 결과");

    Map<String, String> results = new HashMap<>();
    for (String name : carNames) {
      results.put(name, "");
    }

    for (int i = 0; i < attemptNumber; i++) {
      for (String name : carNames) {
        String currentResult = results.get(name);
        results.put(name, currentResult + generateResult());
      }
      printResults(results);
    }
    List<String> winners = determineWinners(results);
    printWinners(winners);
  }

  private String generateResult() {
    if (Randoms.pickNumberInRange(0, 9) >= 4) {
      return "-";
    }
    return "";
  }

  private void printResults(Map<String, String> results) {
    for (Map.Entry<String, String> entry : results.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
    System.out.println();
  }

  private List<String> determineWinners(Map<String, String> results) {
    int maxDistance = 0;
    List<String> winners = new ArrayList<>();
    for (Map.Entry<String, String> entry : results.entrySet()) {
      int distance = entry.getValue().length();
      if (distance > maxDistance) {
        maxDistance = distance;
        winners.clear();
        winners.add(entry.getKey());
      } else if (distance == maxDistance) {
        winners.add(entry.getKey());
      }
    }
    return winners;
  }

  private void printWinners(List<String> winners) {
    System.out.print("최종 우승자 : ");
    for (int i = 0; i < winners.size(); i++) {
      System.out.print(winners.get(i));
      if (i < winners.size() - 1) {
        System.out.print(", ");
      }
    }
  }
}
