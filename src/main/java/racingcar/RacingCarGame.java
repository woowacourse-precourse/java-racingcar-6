package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarGame {
    static void printAskingForCarNamesMessage() {
        System.out.println(Constants.ASKING_FOR_CAR_NAMES_MESSAGE);
    }

    static String getUserInput() {
        return Console.readLine();
    }

    static List<String> splitGamePlayers(String userInput) {
        return Arrays.asList(userInput.split(Constants.COMMA));
    }

    static boolean validateCarNameLength(List<String> carNamesList) {
        boolean isPossible = true;
        for (int i = 0; i < carNamesList.size(); i++) {
            if (carNamesList.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return isPossible;
    }

    static boolean validateCarNameBlankness(List<String> carNamesList) {
        boolean isPossible = true;
        for (int i = 0; i < carNamesList.size(); i++) {
            if (carNamesList.get(i).trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
        return isPossible;
    }

    static boolean validateCarNameRepetition(List<String> carNamesList) {
        boolean isPossible = true;
        Set<String> carNamesSet = new HashSet<>(carNamesList);
        if (carNamesList.size() != carNamesSet.size()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static void printAskingForTrialNumberMessage() {
        System.out.println(Constants.ASKING_FOR_TRIAL_NUMBER_MESSAGE);
    }

    static int convertStringToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static boolean validateTrialNumberRange(int trialNumberInt) {
        if (trialNumberInt <= 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static void printExecutionResult() {
        System.out.println(Constants.EXECUTION_RESULT_MESSAGE);
    }

    static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    static void executePerCar(int i, List<String>[] progressOfCarRacing) {
        int number = getRandomNumber();
        if (number >= 4) {
            progressOfCarRacing[i].add(Constants.PROGRESS_EXPRESSION);
        }
    }

    static void executePerCycle(List<String> carNamesList, List<String>[] progressOfCarRacing) {
        for (int i = 0; i < carNamesList.size(); i++) {
            executePerCar(i, progressOfCarRacing);
            System.out.println(carNamesList.get(i) + " : " + String.join("", progressOfCarRacing[i]));
        }

    }

    static void repeatExecution(int trialNumberInt, List<String> carNamesList, List<String>[] progressOfCarRacing) {
        for (int i = 0; i < trialNumberInt; i++) {
            executePerCycle(carNamesList, progressOfCarRacing);
            System.out.println();
        }
    }

    static boolean isWinner(int sizeOfProgressPerCar, int trialNumberInt) {
        return sizeOfProgressPerCar >= trialNumberInt;
    }

    static List<String> selectWinner(List<String>[] progressOfCarRacing, int trialNumberInt, List<String> carNamesList) {
        List<String> winnerIndex = new ArrayList<>();
        for (int i = 0; i < progressOfCarRacing.length; i++) {
            if (isWinner(progressOfCarRacing[i].size(), trialNumberInt)) {
                winnerIndex.add(carNamesList.get(i));
            }
        }
        return winnerIndex;
    }
}
