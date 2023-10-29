package controller;

import static view.Constant.INPUT_NUMBER;
import static view.Constant.START_GAME;

import camp.nextstep.edu.missionutils.Console;
import model.RacingcarModel;
import view.RacingcarView;

public class RacingcarController {
    RacingcarView rv = new RacingcarView();

    public void run(){
        RacingcarModel rm;
        String car_names;
        String repeat_n;

        rv.Start();
        car_names = Console.readLine();
        rv.InputNuber();
        repeat_n = Console.readLine();
        rm = new RacingcarModel(car_names, repeat_n);
    }

}
