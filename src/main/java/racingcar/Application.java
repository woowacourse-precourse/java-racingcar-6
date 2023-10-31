package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력
        String[] carNames = getCarNames();

        // 시도 회수 입력
        int attempts = getAttempts();

        // 실행 결과 문구 출력
        System.out.println();
        System.out.println("실행 결과");

        // 자동차 전진 거리를 저장할 공간
        int[] carForward = new int[carNames.length];

        // 시도 회수 만큼 진행 하고 결과 출력
        for (int i = 0; i < attempts; i++) {
            forwardCar(carNames, carForward);
            printCar(carNames, carForward);
        }

        String winner = getWinner(carNames, carForward);
        System.out.println("최종 우승자: " + winner);
    }

    // 자동차 이름을 입력 받는 함수
    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        // 자동차 이름 입력이 (,)로 끝나면 안된다.
        if (carName.endsWith(",")) {
            throw new IllegalArgumentException();
        }
        String[] carNames = carName.split(",");
        validCarNames(carNames);
        return carNames;
    }

    // 입력된 자동차 이름이 유효한지 검사하는 함수
    private static void validCarNames(String[] carNames) {
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
    }

    //시도 회수를 입력받고 검사하는 함수
    private static int getAttempts() {
        // 시도 회수 요구
        System.out.println("시도할 회수는 몇회인가요?");

        // 시도 회수 입력
        String inputAttempts = Console.readLine();
        int attempts = Integer.parseInt(inputAttempts);

        // 잘못된 입력에 대해 IllegalArgumentException 발생
        if (attempts <= 0) {
            throw new IllegalArgumentException();
        }
        return attempts;
    }

    // 각 자동차 값 4 이상일 때 전진하는 함수
    private static void forwardCar(String[] carNames, int[] carForward) {
        for (int i = 0; i < carNames.length; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                carForward[i]++;
            }
        }
    }

    // 진행 상황 출력 함수
    private static void printCar(String[] carNames, int[] carForward) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.print(carNames[i] + " : ");
            for (int j = 0; j < carForward[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 우승자 결정 함수
    private static String getWinner(String[] carNames, int[] carForward) {
        int winnerDistance = 0;
        for (int i = 0; i < carNames.length; i++) {
            if (carForward[i] > winnerDistance) {
                winnerDistance = carForward[i];
            }
        }
        String winner = "";
        for (int i = 0; i < carNames.length; i++) {
            if (carForward[i] == winnerDistance) {
                if (!winner.isEmpty()) {
                    winner += ", ";
                }
                winner += carNames[i];
            }
        }
        return winner;
    }
}
