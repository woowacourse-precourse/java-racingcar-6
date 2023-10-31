package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.rmi.server.RemoteRef;
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
    public int sequence(int inputCount, String[] carList) {
        EvaluateSystem raceResult = new EvaluateSystem();
        for (int i = 0; i < carList.length; i++) {
            carRecordSheet.add(raceResult.racingCondition(inputCount));
        }
        displaySystem(carRecordSheet, carList);
        return 0;
    }
    public static void displaySystem(ArrayList<ArrayList<Integer>> RecordSheet, String[] carName) {
        ArrayList<ArrayList<Integer>> recordWinner = new ArrayList<>();
        for (int j = 0; j < RecordSheet.size(); j++) {
            System.out.printf(carName[j] + "'s car : ");
            for (int k = 0; k < RecordSheet.get(j).size(); k++) {
                displayCheck(RecordSheet.get(j).get(k));
            }

            System.out.println("");
        }
//        EvaluateSystem.winnerDisplay(recordWinner, carName);
    }
    public static void displayCheck(int insertedValue) {
        if (insertedValue <= 4) {
            System.out.printf("=");
        } else {
        }
    }


}
