package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public Game() {

    }

    public void run() {
        alertEnterCarName();
        SaveCarName();
    }

    private void alertEnterCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private void SaveCarName() {
        String names = Console.readLine();
        String[] nameArray = names.split(",");
        if (nameArray.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String name : nameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            Car car = new Car(name);
        }
    }
}
