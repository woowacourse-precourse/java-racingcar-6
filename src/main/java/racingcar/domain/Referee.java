package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Referee {
  final String LENGTH_OF_NAME_EXCEPTION_COMMENT = "5자가 넘는 이름이 있습니다";

  public List<String> splitCarName(String unsplitNames) {
    return Arrays.asList(unsplitNames.split(","));
  }

  public void checkNameNotExceed5Characters(List<String> participantNames) {
    for(int i = 0; i < participantNames.size(); i++) {
      if(participantNames.get(i).length() > 5) {
        throw new IllegalArgumentException(LENGTH_OF_NAME_EXCEPTION_COMMENT);
      }
    }
  }

  public String findFinalWinner(List<RacingCar> racingCars) {
    Collections.sort(racingCars);
    RacingCar winnerRacingCar = racingCars.get(0);

    StringBuilder winnerList = new StringBuilder();
    winnerList.append(racingCars.get(0).getName());

    int index = 1;
    while(racingCars.get(index).isSamePosition(winnerRacingCar)) {
      winnerList.append("," + racingCars.get(index++).getName());
    }

    return winnerList.toString();
  }
}
