package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class Game {
    public static void start(){
        HashMap<String, Integer> map =  new HashMap<String, Integer>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carString = Console.readLine();
        map = Generate.carGenerate(map, carString);

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        int currentAttempt = 0;
        while (currentAttempt < count) {
            Race.race(map);

            Generate.raceResultGenerate(map);

            if(currentAttempt == count){
                break;
            }
            currentAttempt++;
        }

        Generate.gameResultGenerate(map);
    }
}
