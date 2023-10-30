package view;

import static view.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import controller.RacingcarController;

import java.util.List;


public class RacingcarView {
    RacingcarController rc = new RacingcarController();
    public void run(){
        String car_names;
        String repeat_n;

        System.out.println(START_GAME);
        car_names = Console.readLine();
        System.out.println(INPUT_NUMBER);
        repeat_n = Console.readLine();
        rc.RacingInputCheck(car_names, repeat_n);
    }

    public void showForwardCount(List<String> car_names, List<Integer> forward_count){
        System.out.println(EXECUTION_RESULT);
        for(int i=0; i<car_names.size(); i++){
            System.out.printf(car_names.get(i) + ": ");
            for(int j=0; j<forward_count.get(i); j++){
                System.out.printf("-");
            }
            System.out.println();
        }
    }

    public void showWinner(){

    }
}
