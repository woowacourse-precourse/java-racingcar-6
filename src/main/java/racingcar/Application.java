package racingcar;

import static racingcar.constant.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분");
        String nameInput = Console.readLine();
        // 자동차 이름 입력 관련 1차 유효성 검사
        if (nameInput.contains(",")) {
            if (nameInput.charAt(0) == ',' || nameInput.charAt(nameInput.length()-1) == ',') {
                throw new IllegalArgumentException(NAME_INPUT_FORMAT + nameInput);
            }
            if (nameInput.contains(",,")) {
                throw new IllegalArgumentException(NAME_INPUT_FORMAT + nameInput);
            }
        }
        // 자동차 이름 입력 관련 2차 유효성 검사
        Map<String, Integer> carList = new LinkedHashMap<>();
        for (String carName : nameInput.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(NAME_LENGTH + carName.length());
            }
            if (carList.containsKey(carName)) {
                throw new IllegalArgumentException(NAME_DUPLICATED + carName);
            }
            carList.put(carName, 0);
        }
        // 시도 횟수 입력
        System.out.println("시도할 횟수는 몇회인가요?");
        String countInput = Console.readLine();
        // 시도 횟수 유효성 검사
        int count;
        try {
            count = Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC + countInput);
        }

        // 자동차 경주 진행 단계
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            for (String carName : carList.keySet()) {
                // 현재 자동차의 전진/정지 여부 결정
                int randomNum = Randoms.pickNumberInRange(0,9);
                int moves = carList.get(carName);
                if (randomNum >= 4) {
                    moves++;
                    carList.put(carName, moves);
                }
                // 해당 차수의 실행 결과 출력
                System.out.print(carName + " : ");
                for (int j = 0; j < moves; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 자동차 경주 종료 단계
        // 가장 많이 전진한 자동차 명단 추리기
        Integer maxValue = Collections.max(carList.values());
        List<String> winnerList = new ArrayList<>();
        for (String carName : carList.keySet()) {
            if (maxValue.equals(carList.get(carName))) {
                winnerList.add(carName);
            }
        }
        // 최종 우승자 출력
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            if (i == 0) {
                System.out.print(winnerList.get(i));
            }
            else if (i > 0) {
                System.out.print(", " + winnerList.get(i));
            }
        }
    }
}
