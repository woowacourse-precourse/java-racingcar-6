package view;

import static view.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import controller.RacingcarController;
import model.RacingcarModel;


public class RacingcarView {
    RacingcarController rc = new RacingcarController();
    public void run(){
        RacingcarModel rm;
        String car_names;
        String repeat_n;

        System.out.println(INPUT_NUMBER);
        car_names = Console.readLine();
        System.out.println(START_GAME);
        repeat_n = Console.readLine();
        rc.RacingStart(car_names, repeat_n);
    }


}
