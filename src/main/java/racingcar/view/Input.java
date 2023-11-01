package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static racingcar.constant.Constant.INIT_CAR_NAME;
import static racingcar.constant.Constant.INIT_NUMBER;

public class Input {

    InputException inputException = new InputException();

    public String[] inputCarName(){
        System.out.println(INIT_CAR_NAME);
        String input = Console.readLine();

        inputException.inputSeparatorException(input);

        String[] cars = input.split(",");
        inputException.inputCarsSizeException(cars);
        for(String carName : cars){
            if(carName.length()  > 5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        return cars;
    }

    public int inputMovingNumber(){
        System.out.println(INIT_NUMBER);
        String input = Console.readLine();

        if(!Pattern.matches("^[1-9]+$",input))
            throw new IllegalArgumentException("숫자외 다른 문자는 쓸 수 없습니다.");

        return Integer.parseInt(input);
    }
}
