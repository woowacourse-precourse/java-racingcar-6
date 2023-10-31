package racingcar.game;

import racingcar.numberGenerator.NumberGenerator;
import racingcar.user.UserInput;

public class Referee {
    UserInput user = new UserInput();
    NumberGenerator numberGenerator = new NumberGenerator();
    private int userAttemptCount() {
      return user.attemptCountInput();
    }
    private int randomValueForMove() {
        return numberGenerator.createRandomNumber();
    }
    private Boolean isMoveCondition() {
        int randomNumber = randomValueForMove();
        return randomNumber >= 4;
    }


}
