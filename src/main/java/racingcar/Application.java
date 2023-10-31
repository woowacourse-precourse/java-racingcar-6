package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.IllegalArgumentException;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNum = Console.readLine();
        String[] CarArray = carNum.split(",");

        //CarArray의 입력 check
        CheckCarArray(CarArray);

        System.out.println("시도할 회수는 몇회인가요?");
        String racingStr = Console.readLine();
        int racingNum = Integer.parseInt(racingStr);

        //레이싱 시작
        //StartRacing(CarArray, racingNum);














    }
    public static void CheckCarArray(String[] CarArray) {
        for(String s: CarArray) {
            if(s.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 입력합니다.");
            }
        }
    }


    //public static int StartRacing(String[] CarArray, int racingNum) {

    //}
}
