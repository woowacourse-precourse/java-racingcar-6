package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    List<String> cars;
    int attempts;
    public void start(){

        inputCarsNameMessage();
        cars = inputCarsName(Console.readLine());
        System.out.println(cars);

        inputAttemptsMessage();
        attempts = inputAttempts(Console.readLine());
        System.out.println(attempts);
    }

    public List<String> inputCarsName(String input){
        List<String> names = new ArrayList<String>();

        for(String name : input.split(",")){
            if(name.length() > 5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            names.add(name);
        }
        return names;
    }

    public int inputAttempts(String input){
        if(input.length() != 1){
            throw new IllegalArgumentException("한 자리의 숫자만 입력 가능합니다.");
        }

        char chrInput = input.charAt(0);
        if(!Character.isDigit(chrInput)){
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        int intInput = Integer.parseInt(input);
        if(intInput < 1){
            throw new IllegalArgumentException("1부터 9사이의 숫자만 입력 가능합니다.");
        }

        return intInput;
    }

    public void inputCarsNameMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void inputAttemptsMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

}