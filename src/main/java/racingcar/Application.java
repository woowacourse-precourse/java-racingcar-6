package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String[] carNames = getCarNamesFromUser();
        int numRounds = getNumberOfRoundsFromUser();
        int numCars = carNames.length;
        int[] carPositions = new int[numCars];
        java.util.Random random = new java.util.Random();

        System.out.println("\nExecution Results");

        for (int round = 1; round <= numRounds; round++) {
            System.out.println("Round " + round);
            
            for (int i = 0; i < numCars; i++) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    carPositions[i]++;
                }
                displayCarProgress(carNames[i], carPositions[i]);
            }
            System.out.println();
        }

        String winners = findWinners(carNames, carPositions);
        System.out.println("The final winner(s): " + winners);
    }

    private static String[] getCarNamesFromUser() {
        System.out.println("Enter the names of the cars to race. (Separated by a comma)");
        String input = Console.readLine();
        return input.split(",");
    }

    private static int getNumberOfRoundsFromUser() {
        System.out.println("How many rounds do you want to race?");
        int numRounds = Randoms.pickNumberInRange(1, 10);
        return numRounds;
    }

    private static void displayCarProgress(String carName, int position) {
        System.out.print(carName + ": " + "-".repeat(position) + "\n");
    }

    private static String findWinners(String[] carNames, int[] carPositions) {
        int maxPosition = -1;
        
        for (int position : carPositions) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }

        StringBuilder winners = new StringBuilder();
        
        for (int i = 0; i < carNames.length; i++) {
            if (carPositions[i] == maxPosition) {
                winners.append(carNames[i]);
                if (i < carNames.length - 1) {
                    winners.append(", ");
                }
            }
        }
        return winners.toString();
    }
}
