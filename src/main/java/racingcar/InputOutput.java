package racingcar;

import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import camp.nextstep.edu.missionutils.Console;

public class InputOutput {
  CheckInput check = new CheckInput();

  public String[] getCarNames() {
    System.out.println(GameConstant.Output.INPUTCARNAME.print());
    String carNameInput = Console.readLine();
    check.carNameEmptyInput(carNameInput);
    String[] carNames = carNameInput.split(",");
    check.carNamelength(carNames);
    return carNames;
  }

  public Integer getTrialCount() {
    System.out.println(GameConstant.Output.INPUTTRIAL.print());
    String trialCount = Console.readLine();
    check.trial(trialCount);

    return Integer.parseInt(trialCount);
  }

  public void printCars(List<Entry<String,Integer>> cars) {
    for (Entry<String,Integer> car : cars) {
      System.out.print(car.getKey());
      System.out.print(GameConstant.COLON);
      printCarProgress(car.getValue());
      System.out.println();
    }
    System.out.println();
  }

  public void printCarProgress(Integer progress) {
    for (int i = GameConstant.STARTPOSITION; i < progress; i++) {
      System.out.print(GameConstant.DASH);
    }
  }

  public void printResultStatement() {
    System.out.println();
    System.out.println(GameConstant.Output.RESULT.print());
  }

  public void printWinners(List<Entry<String,Integer>> cars, Integer leadPosition) {
    System.out.print(GameConstant.Output.WINNER.print());
    List<String> winners = new ArrayList<>();

    for (Entry<String,Integer> car : cars) {
      if (car.getValue() == leadPosition) {
        winners.add(car.getKey());
      }
    }

    System.out.println(String.join(", ",winners));
  }

}
