package racingcar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        raceStart();
    }

    private static void raceStart(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        raceReady();
    }

    private static void raceReady(){

        // 경주 할 자동차 이름 입력 받기
        String carName = inputCarNames();

        // 경주 할 자동차 입력 받은 문자열을 배열로 변환
        String[] carNamesArray = convertToCarNameArray(carName);

        // 시도 할 횟수 입력
        askMoveCount();

        String moveCount = inputMoveCount();

        // 입력 받은 시도 횟수
        int movementLimit = StringToIntMoveCount(moveCount);

        makeForwardStatus(carNamesArray, movementLimit);
    }

    private static void makeForwardStatus(String[] carNamesArray, int movementLimit){
        Map<String, String> forwardStatusMap = createEmptyForwardStatus(carNamesArray);
        racing(carNamesArray, movementLimit, forwardStatusMap);
    }

    // 랜덤한 숫자에 따라 4이상이면 각 번호에 해당하는 자동차 하나씩 전진 -> 각 인덱스에 해당하는 문자열에 "-" 추가
    private static void racing(String[] carNamesArray, int movementLimit, Map<String, String> forwardStatusMap){
        for (int i = 0; i < movementLimit; i++) {
            if (i == 0) {
                System.out.println("실행 결과");
            }
            for (int j = 0; j < carNamesArray.length; j++) {
                int moveDecision = Randoms.pickNumberInRange(0, 9);
                if (moveDecision >= 4) {
                    String forwardStatus = forwardStatusMap.get(carNamesArray[j]);
                    forwardStatus += "-";
                    forwardStatusMap.put(carNamesArray[j], forwardStatus);
                }
            }
            printResult(forwardStatusMap);
        }
        raceEnd(forwardStatusMap,carNamesArray);

    }

    private static void raceEnd(Map<String, String> forwardStatusMap, String[] carNamesArray){
        ArrayList<Integer> forwardCountArrayList = makeForwardCountArrayList();
        caculateForwardCount(forwardCountArrayList,forwardStatusMap);
        findWinners(forwardCountArrayList, carNamesArray);
    }

    private static void findWinners(ArrayList<Integer> forwardCountArrayList, String[] carNamesArray){
        int winnerScore = Collections.max(forwardCountArrayList);

        ArrayList<String> winnerNameArrayList = new ArrayList<>();

        for (int i = 0; i < forwardCountArrayList.size(); i++) {
            int forwardCount = forwardCountArrayList.get(i);
            if (forwardCount == winnerScore){
                winnerNameArrayList.add(carNamesArray[i]);
            }
        }

        decisionWinner(winnerNameArrayList);
    }

    // 최종 우승자 출력
    private static void decisionWinner(ArrayList<String> winnerNameArrayList){
        if (winnerNameArrayList.size() > 1) {
            StringBuilder result = new StringBuilder("최종 우승자 : ");
            for (int i = 0; i < winnerNameArrayList.size(); i++) {
                result.append(winnerNameArrayList.get(i));
                if (i < winnerNameArrayList.size() - 1) {
                    result.append(", ");
                }

            }
            System.out.println(result);
        }
        else if(winnerNameArrayList.size() == 1){
            System.out.println("최종 우승자 : "+winnerNameArrayList.get(0));
        }
    }

    private static String inputCarNames(){
        // Console.readLine();
        return Console.readLine();
    }

    private static String[] convertToCarNameArray(String carName){
        String[] carNamesArray = carName.split(",");
        containsNonStringElement(carNamesArray);
        return carNamesArray;
    }

    private static void containsNonStringElement(String[] carNamesArray) {
        for (String carName : carNamesArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("5글자 이하의 이름을 입력해주세요.");
            }
        }
    }

    private static void askMoveCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static String inputMoveCount(){
        // Console.readLine();
        return Console.readLine();
    }

    private static int StringToIntMoveCount(String moveCount){
        int movementLimit = Integer.parseInt(moveCount);
        return movementLimit;
    }

    private static Map<String, String> createEmptyForwardStatus(String[] carNamesArray){
        Map<String, String> forwardStatusMap = new HashMap<>();
        composeForwardStatus(forwardStatusMap, carNamesArray);
        return forwardStatusMap;
    }

    private static void composeForwardStatus(Map<String, String> forwardStatusMap, String[] carNamesArray){
        for (int i = 0; i < carNamesArray.length; i++) {
            forwardStatusMap.put(carNamesArray[i], "");
        }

    }

    private static void printResult(Map<String, String> forwardStatusMap){
        for (Map.Entry<String, String> entry : forwardStatusMap.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        System.out.println();
    }

    private static ArrayList<Integer> makeForwardCountArrayList(){
        ArrayList<Integer> forwardCountArrayList = new ArrayList<>();
        return forwardCountArrayList;
    }

    private static void caculateForwardCount(ArrayList<Integer> forwardCountArrayList, Map<String, String> forwardStatusMap){
        for (Map.Entry<String, String> entry : forwardStatusMap.entrySet()){
            String value = entry.getValue();
            forwardCountArrayList.add(value.length());
        }
    }

}


