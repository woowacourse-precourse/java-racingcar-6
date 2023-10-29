package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class Application {

    // 전진 함수
    public static boolean forward(){
        int condition = pickNumberInRange(0, 9);

        if(condition >= 4 ){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {



    }
}
