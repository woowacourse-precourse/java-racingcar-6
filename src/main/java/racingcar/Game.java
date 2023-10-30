package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> carList;

    public Game() {
        carList = new ArrayList<>();
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

    private void race() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            if(isMoveForward()) {
                car.addForward();
            }
            System.out.print(car.getName() + " : ");
            System.out.println(car.getForward());
        }
        System.out.println();
    }

    private Boolean isMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber > 4) {
            return true;
        }
        return false;
    }

}
