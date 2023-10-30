package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public Game() {

    }

    public void run() {
        alertEnterCarName();
        saveCarName();
        alertEnterMoveNumber();
        saveMoveNumber();
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
            Car car = new Car(name);
        }
    }

    private void alertEnterMoveNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private void saveMoveNumber() {
        String readLine = Console.readLine();
        // 양수인 Integer 값이 아닌 경우
        try {
            int moveNumber = Integer.parseInt(readLine);
            if (moveNumber <= 0) {
                throw new IllegalArgumentException();
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
