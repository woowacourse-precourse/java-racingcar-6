package racingcar;

import racingcar.domain.Exceptions;
import racingcar.domain.InputHandler;
import racingcar.domain.TrialRepeat;
import racingcar.domain.Winner;

import java.util.LinkedHashMap;
import java.util.List;

public class Application {
    public static List<String> names;
    public static LinkedHashMap<String, Integer> scoreboard;
    public static int trialToDo;
    public static int trialCurrent;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler input = new InputHandler();
        names = input.nameToList(input.inputName());
        Exceptions.validateNamesList(names);

        scoreboard = input.generateScoreboard(names);
        trialToDo = input.trialToInt(input.inputTrial());
        trialCurrent = 0;

        System.out.println(TrialRepeat.RESULT_PRINT_TEXT);
        TrialRepeat trial = new TrialRepeat(scoreboard);
        while (trialCurrent < trialToDo) {
            trial.trialExecution();
            trialCurrent++;
        }
        scoreboard = trial.sb;

        System.out.println(Winner.findWinner(scoreboard));
    }
}
