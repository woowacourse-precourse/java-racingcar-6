package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    public static void start(){
        HashMap<String, Integer> map =  new HashMap<String, Integer>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerString = Console.readLine();
        map = PlayerGenerator.generate(map, playerString);

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        Boolean again = true;
        while (again) {
            Race.race(map);
            if(count == 5){
                again = false;
            } else {
                count += 1;
            }

        }
    }
}
