package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public final class Race {
    private String[] carArray;
    private int tryNumber;
    private int[] raceAccumulations;

    private Race(String[] carArray, int tryNumber, int[] raceAccumulations) {
        this.carArray = carArray;
        this.tryNumber = tryNumber;
        this.raceAccumulations = raceAccumulations;
    }

    public int getCarArrayLength() {
        return carArray.length;
    }

    public String getCar(int carIndex) {
        return carArray[carIndex];
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public int getRaceAccumulation(int raceIndex) {
        return raceAccumulations[raceIndex];
    }

    public void increaseChanceScore(int raceIndex) {
        raceAccumulations[raceIndex] += 1;
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

    public List<String> findFinalWinner() {
        int maxScore = 0;
        List<String> WinnerNames = new ArrayList<>();
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
}
