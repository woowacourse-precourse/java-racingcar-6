package racingcar;

import camp.nextstep.edu.missionutils.Console;

import utils.Validator;
import utils.CarRaceLog;
import utils.FindWinner;

import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        ArrayList<String> carDistanceList;

        if (Validator.isCarNameValid(carNameInput)){
            carDistanceList = CarRaceLog.initCarDistanceList(carNameInput);
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountInput = Console.readLine();
        int tryCount;

        if (Validator.isTryCountNumberValid(tryCountInput)) {
            tryCount = Integer.parseInt(tryCountInput.trim());
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println("\n실행 결과");
        Racing.startGame(tryCount, carDistanceList);

        String result = FindWinner.getRaceResult(carDistanceList);
        System.out.println(result);
    }
}
