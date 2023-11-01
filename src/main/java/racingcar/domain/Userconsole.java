package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class Userconsole {
    public ArrayList<String> makingCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carname = Console.readLine();
        if(carname.equals("")){
            throw new IllegalArgumentException();
        }
        ArrayList<String> cars = new ArrayList<String>(Arrays.asList(carname.split(",")));
        if(cars.size() < 1){
            throw new IllegalArgumentException();
        }
        for(int i=0; i<cars.size(); i++){
            if(cars.get(i).length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return cars;
    }

    public int askRounds(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        int rounds = Integer.parseInt(input);
        return rounds;
    }
}
