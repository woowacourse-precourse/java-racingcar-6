package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

final class Race {
    private String[] carArray;
    private int tryNumber;
    private int[] raceAccumulations;

    private Race(String[] carArray, int tryNumber, int[] raceAccumulations) {
        this.carArray = carArray;
        this.tryNumber = tryNumber;
        this.raceAccumulations = raceAccumulations;
    }

    public String[] getCarArray() {
        return carArray;
    }


    public int[] getRaceAccumulations() {
        return raceAccumulations;
    }

    public static Race initializeRaceInformation() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        String[] carArray = carInput.split(",");
        checkNameError(carArray);
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine());
        int[] raceAccumulations = new int[carArray.length];
        return new Race(carArray, tryNumber, raceAccumulations);
    }

    private static void checkNameError(String[] carArray) {
        for (String carName : carArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("5자를 넘는 이름을 입력하셨습니다. 오류 발생");
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름으로 공백 값을 입력하셨습니다. 오류 발생");
            }
        }
    }

    public void playGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            for (int changeScore = 0; changeScore < carArray.length; changeScore++) {
                giveScore(changeScore);
            }
            printEachRace();
        }
    }

    private void giveScore(int chanceScore) {
        int randomNum = makeRandomNum();
        if (randomNum >= 4) {
            raceAccumulations[chanceScore] += 1;
        }
    }

    private void printEachRace() {
        for (int index = 0; index < carArray.length; index++) {
            System.out.print(carArray[index] + " : ");
            printEachCarScore(index);
            System.out.println();
        }
        System.out.println();
    }

    private int makeRandomNum() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }

    private void printEachCarScore(int index) {
        int substitutionNum = raceAccumulations[index];
        for (int printNum = 0; printNum < substitutionNum; printNum++) {
            System.out.print("-");
        }
    }

    private ArrayList<String> findFinalWinner() {
        int maxScore = 0;
        ArrayList<String> WinnerNames = new ArrayList<>();
        for (int index = 0; index < carArray.length; index++) {
            if (raceAccumulations[index] > maxScore) {
                maxScore = raceAccumulations[index];
                WinnerNames.clear();
                WinnerNames.add(carArray[index]);
            } else if (raceAccumulations[index] == maxScore) {
                WinnerNames.add(carArray[index]);
            }
        }
        return WinnerNames;
    }

    public void printFinalResult() {
        ArrayList<String> WinnerNames = findFinalWinner();
        System.out.print("최종 우승자 :");
        for (int winnerName = 0; winnerName < WinnerNames.size(); winnerName++) {
            if (winnerName == 0) {
                System.out.print(" " + WinnerNames.get(winnerName));
            } else {
                System.out.print(", " + WinnerNames.get(winnerName));
            }
        }
    }
}
