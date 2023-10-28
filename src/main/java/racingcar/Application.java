package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 요구
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        // 자동차 이름 입력
        String carName = Console.readLine();
        
        // 입력된 자동차 이름을 (,)기준으로 split
        String[] carNames = carName.split(",");

        // 잘못된 입력에 대해 IllegalArgumentException 발생
        for (int i = 0; i < carNames.length; i++) {
            // 자동차 이름은 5자 이하만 가능
            if (carNames[i].trim().length() > 5) {
                throw new IllegalArgumentException();
            }
            // (,)를 기준 이름이 비어 있으면 안된다.
            if (carNames[i].trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }

        // 시도 회수 요구
        System.out.println("시도할 회수는 몇회인가요?");

        // 시도 회수 입력
        String inputAttempts = Console.readLine();
        int attempts = Integer.parseInt(inputAttempts);

        // 잘못된 입력에 대해 IllegalArgumentException 발생
        if (attempts <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
