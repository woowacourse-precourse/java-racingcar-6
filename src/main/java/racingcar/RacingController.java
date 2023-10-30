package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.InputValidator.validateCarName;
import static racingcar.InputValidator.validateRounds;
import static racingcar.InputValidator.validateString;

public class RacingController {
    public RacingController() {}

    public String carNamePrompt(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String carNamesInput = readLine();
        validateString(carNamesInput);

        System.out.println("carNamesInput = " + carNamesInput); // tmp

        return carNamesInput;
    }
    public String roundPrompt(){
        System.out.println("시도할 회수는 몇 회인가요?");
        String roundsInput = readLine();
        validateRounds(roundsInput);
        System.out.println("roundsInput = " + roundsInput);
        return roundsInput;
    }
}
