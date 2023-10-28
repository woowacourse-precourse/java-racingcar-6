package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.PrintResult;

import java.util.List;

public class CarMove {
    public static boolean moveCheck(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
    public static void move(List<String> car_list, StringBuilder[] move_result){
        for (int i = 0; i<car_list.size(); i++){
            if (moveCheck()){
                move_result[i].append("-");
            }
        }
        PrintResult.printMove(car_list,move_result);
        System.out.println();
    }
}
