package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Car {


    public String[] build(){
        String carnameinput = Console.readLine();
        String[] carnames = carnameinput.split(",");

        for (int i = 0; i < carnames.length; i++) {
            String carname = carnames[i];

            if(carname.length()>5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하입니다");
            }
        }
        return carnames;
    }
    public int move() {
        int position = 0;
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
        return position;
    }
}
