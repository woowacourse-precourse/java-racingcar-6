package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class RacingSystem {
    public static ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();
    public void nameInput() {
        System.out.printf("자동차 이름은 쉼표(,)를 기준으로 구분하여 작성 부탁 드리며, 이름은 5자 이하로 작성 요망 : ");
        String carNameInput = Console.readLine();
        String[] nameList = carNameInput.split(",");
        ErrorCheckingSystem errorCheck = new ErrorCheckingSystem();
        errorCheck.errorSystem(nameList);
        int inputCount = errorCheck.numberCheck(moveInput());
        sequence(inputCount, nameList);
    }
    public String moveInput() {
        System.out.printf("몇 번의 이동을 하게 만들 건가요?: ");
        String carNameInput = Console.readLine();
        return carNameInput;
    }
    public static int sequence(int inputCount, String[] carList) {
        EvaluateSystem raceResult = new EvaluateSystem();
        for (int i = 0; i < carList.length; i++) {
            carRecordSheet.add(raceResult.racingCondition(inputCount));
        }
        for (int j = 0; j < carRecordSheet.size(); j++) {
            for (int k = 0; k < carRecordSheet.get(j).size(); k++) {
                System.out.println("car name " + j + ": " + carRecordSheet.get(j).get(k));
            }
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


}
