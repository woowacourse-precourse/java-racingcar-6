package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    String position = "";
    // 전진 조건 설정
    public int isMovable() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumber >= 4) return randomNumber;
        else return 0;
    }

    public String raceCar(List<String> cars,int times){

        while(times > 0){
            System.out.println("\n");
            // 자동차 한대씩 게임 실행
            for(String car:cars){
                moveForward();
                System.out.println(car+" : "+position);
            }
            times--;
        }
        return "게임종료";
    }

    public int moveForward(){
        int move = isMovable();
        if(move > 0){
            position += "-";
        }
        return move;
    }
}
