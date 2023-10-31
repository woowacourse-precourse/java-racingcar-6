package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
  private final static String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
  private final static String INPUT_FREQUENCY_MESSAGE = "시도할 회수는 몇회인가요?";
  private final static String FIRST_RESULT_MESSAGE = "\n실행 결과";

  public static void printInputNameMessage() {
    System.out.println(INPUT_NAME_MESSAGE);
  }

  public static void printInputFrequencyMessage() {
    System.out.println(INPUT_FREQUENCY_MESSAGE);
  }

  public static void printFirstResultMessage() {
    System.out.println(FIRST_RESULT_MESSAGE);
  }

  public static void printResultMessage(List<String> carNamesList, List<Integer> distance) {
    String DISTANCE = "-";
    for (int i = 0; i < carNamesList.size(); i++) {
      System.out.print(carNamesList.get(i) + " : " + DISTANCE.repeat(distance.get(i)) + "\n");
    }
    System.out.println();
  }

  public static void printWinner(List<Integer> winner, List<String> carNamesList) {
    System.out.print("최종 우승자 : ");
    List<String> winningCarNames = new ArrayList<>();

    for (int i = 0; i < winner.size(); i++) {
      if (winner.get(i) == 1) {
        winningCarNames.add(carNamesList.get(i));
      }
    }

    String winners = String.join(", ", winningCarNames);
    System.out.print(winners);
  }

  }
