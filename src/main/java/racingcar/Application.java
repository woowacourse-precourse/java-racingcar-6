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

        // 경주 할 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        String[] carNamesArray = carName.split(",");


        // 시도 할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        String moveCount = Console.readLine();
        int movementLimit = Integer.parseInt(moveCount);


        // 각 자동차의 전진 여부를 나타내는 빈 문자열 생성
        Map<String, String> forwardStatusMap = new HashMap<>();
        for (int i = 0; i < carNamesArray.length; i++) {
            forwardStatusMap.put(carNamesArray[i], "");
        }

        // 랜덤한 숫자에 따라 4이상이면 각 번호에 해당하는 자동차 하나씩 전진 -> 각 인덱스에 해당하는 문자열에 "-" 추가

        for (int i = 0; i < movementLimit; i++) {
            if(i==0){
                System.out.println("실행 결과");
            }
            for (int j = 0; j < carNamesArray.length; j++) {
                int moveDecision = Randoms.pickNumberInRange(0, 9);
                if (moveDecision >= 4){
                    String forwardStatus = forwardStatusMap.get(carNamesArray[j]);
                    forwardStatus += "-";
                    forwardStatusMap.put(carNamesArray[j], forwardStatus);
                }
            }

            for (Map.Entry<String, String> entry : forwardStatusMap.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println(key + " : " + value);
            }
            System.out.println();

        }

        ArrayList<Integer> forwardCountArrayList = new ArrayList<>();
        // 최종 우승자 출력
        for (Map.Entry<String, String> entry : forwardStatusMap.entrySet()){
            String value = entry.getValue();
            forwardCountArrayList.add(value.length());
        }

        int winnerScore = Collections.max(forwardCountArrayList);

        ArrayList<String> winnerNameArrayList = new ArrayList<>();

        for (int i = 0; i < forwardCountArrayList.size(); i++) {
            int forwardCount = forwardCountArrayList.get(i);
            if (forwardCount == winnerScore){
                winnerNameArrayList.add(carNamesArray[i]);
            }
        }

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
}

