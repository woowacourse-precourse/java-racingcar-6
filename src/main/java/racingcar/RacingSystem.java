package racingcar;
import camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;
import java.util.Arrays;

public class RacingSystem {
//    public static ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();

    EvaluateSystem raceCount = new EvaluateSystem();

    public void run() {
        System.out.printf("자동차 이름은 쉼표(,)를 기준으로 구분하여 작성 부탁 드리며, 이름은 5자 이하로 작성 요망 : ");
        String carNameInput = Console.readLine();
        String[] nameList = carNameInput.split(",");
        ErrorCheckingSystem errorCheck = new ErrorCheckingSystem();
        errorCheck.errorSystem(nameList);
        int inputCount = errorCheck.numberCheck(moveInput());
        sequenceSystem(inputCount, nameList);
    }

    public String moveInput() {
        System.out.printf("몇 번의 이동을 하게 만들 건가요?: ");
        String carNameInput = Console.readLine();
        return carNameInput;
    }

    public int sequenceSystem(int count, String[] carList) {
        int tempCount = 0;
        ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();//this is for actual race record
        ArrayList<ArrayList<Integer>> winnerCheckList = new ArrayList<>();//this is for chcking winner
        makeRecordList(winnerCheckList, carList.length);// bring name list to arraylist
        makeRecordList(carRecordSheet, carList.length);//declaring column by name
        for (int i = 0; i < count; i++) {
            addRecord(carRecordSheet, carList.length);//recording race
            displaySystem(carRecordSheet, carList);
            System.out.printf("\n");
        }
        winnerCheck(carRecordSheet, winnerCheckList);
        raceCount.winnerSearch(winnerCheckList, carList);

        return 0;
    }

    public void makeRecordList(ArrayList<ArrayList<Integer>> raceSheet, int nameGroupSize) {
        for (int i = 0; i < nameGroupSize; i++) {
            raceSheet.add(new ArrayList<>());
        }
    }

    public void addRecord(ArrayList<ArrayList<Integer>> racingSheet, int carListSize) {
        for (int i = 0; i < carListSize; i++) {
            racingSheet.get(i).add(raceCount.racingCondition());
        }
    }

    public void displaySystem(ArrayList<ArrayList<Integer>> RecordSheet, String[] carName) {
        for (int j = 0; j < RecordSheet.size(); j++) {
            System.out.printf(carName[j] + " : ");
            for (int k = 0; k < RecordSheet.get(j).size(); k++) {
                displayCheck(RecordSheet.get(j).get(k));
            }
            System.out.println("");
        }

//        EvaluateSystem.winnerDisplay(recordWinner, carName);
    }

    public void displayCheck(int insertedValue) {
        if (insertedValue >= 4) {
            System.out.printf("-");
        }
    }

    public void winnerCheck(ArrayList<ArrayList<Integer>> raceList, ArrayList<ArrayList<Integer>> winnerList) {
        for (int i = 0; i < raceList.size(); i++) {
            for (int j = 0; j < raceList.get(i).size(); j++) {
                winnerList.get(i).add(winnerCheckValue(raceList.get(i).get(j)));
            }
        }
    }

    public int winnerCheckValue(int raceValue) {
        if (raceValue >= 4) {
            return 1;
        } else {
            return 0;
        }
    }
}

