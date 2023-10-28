package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램


    }

    // 게임 진행 메소드
    private static void playGame(){
        while (true) {
            System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput=Console.readLine();
            String[] carNames=carNamesInput.split(",");

            String attempts=Console.readLine();


        }

    }
    // 입력값 예외처리 해주는 메소드-이름, 횟수
    private static boolean isValidCarNames(String[] carNames){
        for (String name: carNames){
            if (name.length()>5){
                return false;
            }
        }
        return true;
    }
    // 입력된 자동차 각각 배열 지정해주는 메소드



    //각 자동차에 무작위 전진 횟수 지정 메소드



}
