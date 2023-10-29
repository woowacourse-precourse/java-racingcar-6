package racingcar.controller;

import java.util.HashMap;
import java.util.List;

import racingcar.view.output;
import racingcar.view.input;

public class controller {

    public static void Run() {
        output.Start_Message();
        List<String> names = input.input_names();
        output.Attempts_Message();
        int attempt = input.input_attempts();
        output.Game_Start();
        HashMap<String, Integer> result = output.Game_exe(attempt, names);
        output.Game_result(result);
    }

}
