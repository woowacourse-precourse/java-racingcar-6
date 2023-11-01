package racingcar;

import camp.nextstep.edu.missionutils.Console;

import utils.validator;
import utils.carRaceLog;
import utils.findWinner;

import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        ArrayList<String> carDistanceList;

        if (validator.isCarNameValid(carNameInput)){
            carDistanceList = carRaceLog.initCarDistanceList(carNameInput);
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountInput = Console.readLine();
        int tryCount;

        if (validator.isTryCountNumberValid(tryCountInput)) {
            tryCount = Integer.parseInt(tryCountInput.trim());
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println("\n실행 결과");
        Racing.startGame(tryCount, carDistanceList);

        String result = findWinner.getRaceResult(carDistanceList);
        System.out.println(result);
    }
}
