package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {





    public static String inputcarName() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)기준으로 구분)");
        String carnames = readLine();
        carRacingNum();

        String[] car;
        String colons = " : " ;
            car = carnames.split(",");
            for (int i = 0; i < car.length; i++) {
                String carname = car[i];
                System.out.println(car[i] + " : ");


            }
        return null;
    }

    public static int carRacingNum() {

        System.out.println("시도할 회수는 몇회 인가요?");
        int racingNum = Integer.parseInt(readLine());
        return racingNum;
    }

    public static String carracingsGame(){
        int a = 0;
        while (a < carRacingNum()) {

            a++;
            int carracings = Randoms.pickNumberInRange(0, 9);
        }


        return null;
    }



        public static void main (String[]args){
            inputcarName();



        }




}
