package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingSystem {
    public static ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();
    public static int sequence(int inputCount, int carAmount) {
        EvaluateSystem raceResult = new EvaluateSystem();
        for (int i = 0; i < carAmount; i++) {
            carRecordSheet.add(EvaluateSystem.racingCondition(inputCount));
        }

        return 0;
    }
    public void display() {
//        for (int j = 0; j < carRecordSheet.size(); j++) {
//            for (int k = 0; k < carRecordSheet.get(j).size(); k++) {
//                System.out.println("car number " + j + ": " + carRecordSheet.get(j).get(k));
//            }
//        }
    }
    public void nameInput() {
        System.out.printf("자동차 이름은 쉼표(,)를 기준으로 구분하여 작성 부탁 드리며, 이름은 5자 이하로 작성 요망 : ");
        String carNameInput = Console.readLine();
        String[] nameList = carNameInput.split(",");
        ErrorCheckingSystem errorCheck = new ErrorCheckingSystem();
        errorCheck.errorSystem(nameList);
        for ( String dummy : nameList) {
            System.out.println(dummy);
        }


    }
    public void moveInput() {

    }

}
