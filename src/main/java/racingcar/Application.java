package racingcar;

import racingcar.domain.InputHandler;
import racingcar.domain.TrialRepeat;

import java.util.Hashtable;
import java.util.List;

public class Application {
    public static List<String> names;
    public static int trialToDo;
    public static Hashtable<String, Integer> scoreboard;
    public static int trialCurrent = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler input = new InputHandler();
        names = input.nameToList(input.inputName());
        scoreboard = input.generateScoreboard(names);
        trialToDo = input.trialToInt(input.inputTrial());

        System.out.println(TrialRepeat.RESULT_PRINT_TEXT);
        TrialRepeat trial = new TrialRepeat(scoreboard);
        while (trialCurrent < trialToDo) {
            trial.trialExecution();
        }
        scoreboard = trial.sb;


    }
}
