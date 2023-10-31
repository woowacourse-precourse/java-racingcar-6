package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        try {
            String[] carNames = getCarNamesFromUser();
            int numRounds = getNumberOfRoundsFromUser();
            int numCars = carNames.length;
            int[] carPositions = new int[numCars];

            System.out.println("\n실행 결과");

            for (int round = 1; round <= numRounds; round++) {
                System.out.println("라운드 " + round);

                for (int i = 0; i < numCars; i++) {
                    if (Randoms.pickNumberInRange(0, 9) >= 4) {
                        carPositions[i]++;
                    }
                    displayCarProgress(carNames[i], carPositions[i]);
                }
                System.out.println();
            }

            String winners = findWinners(carNames, carPositions);
            System.out.println("우승자: " + winners);

        } catch (IllegalArgumentException e) {
            System.err.println("잘못된 입력 값이 감지되어 애플리케이션을 종료합니다.");
        }
    }

    private static String[] getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        
        if (carNames.length < 2) {
            throw new IllegalArgumentException("최소 2대의 자동차가 필요합니다.");
        }
        
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5자여야 합니다.");
            }
        }
        
        return carNames;
    }

    private static int getNumberOfRoundsFromUser() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numRounds = Integer.parseInt(Console.readLine());
        
        if (numRounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 양수여야 합니다.");
        }
        
        return numRounds;
    }

    private static void displayCarProgress(String carName, int position) {
        System.out.print(carName + ": ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static String findWinners(String[] carNames, int[] carPositions) {
        int maxPosition = 0;
        StringBuilder winners = new StringBuilder();

        for (int position : carPositions) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }

        for (int i = 0; i < carNames.length; i++) {
            if (carPositions[i] == maxPosition) {
                winners.append(carNames[i]).append(", ");
            }
        }

        return winners.substring(0, winners.length() - 2);
    }
}
