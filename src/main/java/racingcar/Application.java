package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCarGame.printAskingForCarNamesMessage();
        String carNamesString = RacingCarGame.getUserInput();
        List<String> carNamesList = RacingCarGame.splitGamePlayers(carNamesString);

        RacingCarGame.validateCarNameLength(carNamesList);
        RacingCarGame.validateCarNameBlankness(carNamesList);
        RacingCarGame.validateCarNameRepetition(carNamesList);

        RacingCarGame.printAskingForTrialNumberMessage();
        String trialNumberString = RacingCarGame.getUserInput();

        int trialNumberInt = RacingCarGame.convertStringToInt(trialNumberString);
        RacingCarGame.validateTrialNumberRange(trialNumberInt);
        System.out.println();

        RacingCarGame.printExecutionResult();

        List<String>[] progressOfCarRacing = new ArrayList[carNamesList.size()];
        for (int i = 0; i < carNamesList.size(); i++) {
            progressOfCarRacing[i] = new ArrayList<>();
        }

        RacingCarGame.repeatExecution(trialNumberInt, carNamesList, progressOfCarRacing);
        List<String> winners = RacingCarGame.selectWinner(progressOfCarRacing, trialNumberInt, carNamesList);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
