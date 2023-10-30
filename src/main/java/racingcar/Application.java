package racingcar;

import racingcar.domain.InputHandler;
import racingcar.domain.TrialRepeat;

import java.util.List;

public class Application {
    public static List<String> names;
    public static int trialToDo;
    public static int trialCurrent = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler input = new InputHandler();
        names = input.inputName();
        trialToDo = input.inputTrial();

        System.out.println(TrialRepeat.RESULT_PRINT_TEXT);
        while (trialCurrent < trialToDo) {
            TrialRepeat trial = new TrialRepeat();
            trial.trialExecution(names);
        }
    }
}
