package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 사용자로부터 자동차 이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        int numCars = carNames.length;

        // 2. 사용자로부터 시도할 회수 입력받기
        System.out.println("시도할 회수는 몇회인가요?");
        int numAttempts = scanner.nextInt();

        if (numAttempts <= 0) {
            System.out.println("시도 횟수는 1 이상이어야 합니다.");
            return;
        }

        for (int attempt = 0; attempt < numAttempts; attempt++) {
            System.out.println("\n시도 " + (attempt + 1) + ":");

            // 3. 자동차 전진 여부 결정
            for (int i = 0; i < numCars; i++) {
                int randomValue = (int) (Math.random() * 10);
                if (randomValue >= 4) {
                    carNames[i] += "-";
                }
            }

            // 5. 우승자 결정
            int maxDistance = 0;
            for (String carName : carNames) {
                int carDistance = carName.length();
                maxDistance = Math.max(maxDistance, carDistance);
            }

            System.out.println("\n최종 우승자:");
            boolean firstWinner = true;

            for (int i = 0; i < numCars; i++) {
                if (carNames[i].length() == maxDistance) {
                    if (!firstWinner) {
                        System.out.print(", ");
                    }
                    System.out.print(carNames[i].split("-")[0]);
                    firstWinner = false;
                }
            }

            System.out.println();
        }
    }
}