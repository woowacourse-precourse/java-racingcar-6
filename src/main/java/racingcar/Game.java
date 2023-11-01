package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private static HashMap<String,String> players= new HashMap<>();
    public Map<String, String> createName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] cars = camp.nextstep.edu.missionutils.Console.readLine().split(",");

        for (String name : cars) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            players.put(name,"");
        }
        return players;
    }

    public int tryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
    }

    }
