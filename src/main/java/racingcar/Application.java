package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분");
        String nameInput = Console.readLine();
        // 자동차 이름 입력 관련 1차 유효성 검사
        if (nameInput.contains(",")) {
            if (nameInput.charAt(0) == ',' || nameInput.charAt(nameInput.length()-1) == ',') {
                throw new IllegalArgumentException("Invalid name input format: " + nameInput);
            }
            if (nameInput.contains(",,")) {
                throw new IllegalArgumentException("Invalid name input format: " + nameInput);
            }
        }
        // 자동차 이름 입력 관련 2차 유효성 검사
        Map<String, Integer> carList = new LinkedHashMap<>();
        for (String carName : nameInput.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Not valid length: "+carName.length());
            }
            if (carList.containsKey(carName)) {
                throw new IllegalArgumentException("Duplicated car name: " + carName);
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
            throw new IllegalArgumentException("Not Integer: " + countInput);
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
    }
}
