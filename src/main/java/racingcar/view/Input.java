package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static racingcar.constant.Constant.INIT_CAR_NAME;
import static racingcar.constant.Constant.INIT_NUMBER;

public class Input {

    public String[] InputCarName(){
        System.out.println(INIT_CAR_NAME);
        String input = Console.readLine();
        if(!input.contains(" "))
            throw new IllegalArgumentException("쉽표(,)를 통해 구분해 주세요.");

        String[] cars = input.split(",");
        if(cars.length == 1)
            throw new IllegalArgumentException("자동차는 2대 이상이 경기에 참여해야 합니다");
        for(String carName : cars){
            if(carName.length() < 6){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        return cars;
    }

    public int InputMovingNumber(){
        System.out.println(INIT_NUMBER);
        String input = Console.readLine();

        if(!Pattern.matches("^[1-9]+$",input))
            throw new IllegalArgumentException("숫자외 다른 문자는 쓸 수 없습니다.");

        return Integer.parseInt(input);
    }
}
