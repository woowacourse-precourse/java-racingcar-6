package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class GameManager{

    public void run(){
        Cars cars = askCarNames();
        int tryCount = askTryCount();
    }

    private Cars askCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<String> names = Arrays.asList(input.split(","));
        return new Cars(names);
    }

    private int askTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            return Integer.parseInt(readLine());
        } catch (NumberFormatException NFE){
            throw new IllegalArgumentException("Try count input should be number format");
        }
    }

}
