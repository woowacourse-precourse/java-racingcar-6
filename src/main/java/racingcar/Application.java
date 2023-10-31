package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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

        // 실행 결과 문구 출력
        System.out.println();
        System.out.println("실행 결과");

        // 전진 결과를 저장
        int[] carForward = new int[carNames.length];

        // 각 자동차 값 4 이상일 때 전진, 회차별 결과 출력
        for (int i = 0; i < attempts; i++) {
            for (int j = 0; j < carNames.length; j++) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    carForward[j]++;
                }
            }
            for (int j = 0; j < carNames.length; j++) {
                System.out.print(carNames[j] + " : ");
                for (int k = 0; k < carForward[j]; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 우승자 전진 거리 구하기
        int winnerDistance = 0;
        for (int i = 0; i < carNames.length; i++) {
            if (carForward[i] > winnerDistance) {
                winnerDistance = carForward[i];
            }
        }

        // 우승자 출력
        System.out.print("최종 우승자 : ");
        String winner = "";
        for (int i = 0; i < carNames.length; i++) {
            if (carForward[i] == winnerDistance) {
                if (!winner.isEmpty()) {
                    winner += ", ";
                }
                winner += carNames[i];
            }
        }
        System.out.println(winner);
    }
}
