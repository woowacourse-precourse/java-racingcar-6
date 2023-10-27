package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CarMove {
    public static boolean moveCheck(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        boolean checkMove = true;
        if (randomNumber < 4){
            checkMove = false;
        }
        return checkMove;
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
