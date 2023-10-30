package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private CarList carList;

    public Game() {
        carList = new CarList();
    }

    public void run() {
        alertEnterCarName();
        saveCarName();
        alertEnterMoveNumber();
    }

    private void alertEnterCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private void saveCarName() {
        String names = Console.readLine();
        String[] nameArray = names.split(",");
        if (nameArray.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String name : nameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < nameArray.length; i++) {
            carList.add(new Car(nameArray[i]));
        }
    }

    private void alertEnterMoveNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void race() {

    }

}
