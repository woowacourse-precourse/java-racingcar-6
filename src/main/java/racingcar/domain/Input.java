package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public void InputCarName(List<Car> cars){
        String input;

        input = Console.readLine();

        String[] result = input.split(",");

        CheckCarNameException(result);

        for(String a : result){
            cars.add(new Car(a));
        }


    }

    public int InputGameNum(){
        String input;

        input = Console.readLine();

        int result = Integer.parseInt(input);

        CheckGameNumException(result);

        return result;
    }

    private void CheckCarNameException(String[] target){

        CheckCarNum(target);
        CheckLength(target);
        CheckSame(target);

    }

    private void CheckSame(String[] target){
        List<String> exist = new ArrayList<>();

        for(String a : target){
            if(exist.contains(a)){
                throw new IllegalArgumentException("이름이 중복되면 안됩니다.");
            }
            exist.add(a);
        }
    }

    private void CheckCarNum(String[] target){
        if(target.length < 2){
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private void CheckLength(String[] target){

        for(String a : target){
            if(a.length() > 5){
                throw new IllegalArgumentException("5글자를 넘기면 안됩니다.");
            }
        }
    }

    private void CheckGameNumException(int num){
        if(num < 1){
            throw new IllegalArgumentException("1이상의 횟수가 입력되야 합니다.");
        }
    }

}
