package racingcar.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static java.lang.Integer.parseInt;

public class AskPlayer {
    public Cars askName(){
        Cars cars = new Cars();
        String names = Console.readLine();
        for (String name: names.replaceAll(" ", "").split(",")){
            if (name.length() > 5){
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 프로그램이 종료됩니다.");
            }
            cars.addCar(name);
        }
        return cars;
    }

    public int askHowMany(){
        String snum = Console.readLine();
        int num = 0;
        try {
            num = parseInt(snum);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 프로그램이 종료됩니다.");
        }
        return num;
    }

}
