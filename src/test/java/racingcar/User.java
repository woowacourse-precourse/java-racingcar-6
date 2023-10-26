package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class User {
    private List<String> carNames;
    private int number;

    public void inputData(){
        try {
            System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
            String names = Console.readLine();
            carNames = Arrays.stream(names.split(",")).toList();
            System.out.println("시도할 회수");
            number = Integer.parseInt(Console.readLine());
        }catch(IllegalArgumentException e){
            System.out.println("유효하지 않은 값입니다. 프로그램 종료");
            return;
        }
    }
    public List<String> getCarNames(){
        return carNames;
    }
    public int getNumber(){
        return number;
    }

}
