package racingcar;

import java.util.List;


public class Game {
    public static List<Car> players;
    public List<Car> createName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        for (String name : camp.nextstep.edu.missionutils.Console.readLine().split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            players.add(new Car(name));
        }

        return players;
    }

    public int tryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
    }

    }
