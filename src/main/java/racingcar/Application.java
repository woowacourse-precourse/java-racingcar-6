package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputCar = Console.readLine();
            String[] carNames = inputCar.split(","); // 자동차 이름을 쉼표(,)로 구분하여 배열에 저장
            for (String name : carNames) {
                if (name.length() > 5) {
                    throw new IllegalArgumentException();
                }
            }
            System.out.println("시도할 회수는 몇회인가요?");
            String inputNum = Console.readLine();
            int numberOfAttempts = Integer.parseInt(inputNum); // 시도 회수를 정수로 변환
            int[] carPositions = new int[carNames.length]; // 각 자동차의 위치 값을 저장하는 배열\
            simulateRace(carNames, numberOfAttempts, carPositions);
            String winners = determineWinners(carNames, carPositions);

            // 우승자 안내 문구 출력
            System.out.println("최종 우승자 : " + winners);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void simulateRace(String[] carNames, int numberOfAttempts, int[] carPositions) {
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            updateCarPositions(carNames, carPositions);
            printRaceProgress(carNames, carPositions);
        }
    }

    private static void updateCarPositions(String[] carNames, int[] carPositions) {
        for (int i = 0; i < carNames.length; i++) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            // 무작위 값이 4 이상이면 전진
            if (randomValue >= 4) {
                carPositions[i]++;
            }
        }
    }

    private static void printRaceProgress(String[] carNames, int[] carPositions) {
        for (int i = 0; i < carNames.length; i++) {
            StringBuilder result = new StringBuilder(carNames[i] + " : ");
            for (int j = 0; j < carPositions[i]; j++) {
                result.append("-");
            }
            System.out.println(result.toString());
        }
        System.out.println();
    }

    private static String determineWinners(String[] carNames, int[] carPositions) {
        int maxPosition = 0;
        StringBuilder winners = new StringBuilder();

        for (int i = 0; i < carNames.length; i++) {
            if (carPositions[i] > maxPosition) {
                maxPosition = carPositions[i];
                winners = new StringBuilder(carNames[i]);
            } else if (carPositions[i] == maxPosition) {
                winners.append(", ").append(carNames[i]);
            }
        }

        return winners.toString();
    }
}