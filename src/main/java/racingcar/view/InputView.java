package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

  private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private static final String INPUT_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

  public RaceGameInput readStartInput() {
    System.out.println(INPUT_CAR_NAMES_MESSAGE);
    String carNamesInput = readLine();

    System.out.println(INPUT_GAME_COUNT_MESSAGE);
    String roundInput = readLine();

    System.out.println();
    return RaceGameInput.from(carNamesInput, roundInput);
  }
}
