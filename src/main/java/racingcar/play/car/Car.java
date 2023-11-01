package racingcar.play.car;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.CarException;

public class Car {
    public static String[] input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String s = Console.readLine();
        String[] names = s.split(",");

        //이름 유효성 체크
        for(String name : names){
            CarException.checkName(name);
        }

        return names;
    }
}
