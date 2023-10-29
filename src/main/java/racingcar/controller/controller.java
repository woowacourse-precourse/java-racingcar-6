package racingcar.controller;

import racingcar.view.output;
import racingcar.view.input;

public class controller {

    public static void Run() {
        output.Start_Message();
        input.input_names();
        output.Attempts_Message();
        input.input_attempts();
        System.out.println("test");
    }

}
