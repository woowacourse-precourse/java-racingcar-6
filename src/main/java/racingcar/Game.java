package racingcar;

import static racingcar.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Car> carList;
    private Integer moveNumber;

    public Game() {
        carList = new ArrayList<>();
        moveNumber = 0;
    }

    public void run() {
        alertEnterCarName();
        saveCarName();
        alertEnterMoveNumber();
        saveMoveNumber();
        while (moveNumber > 0) {
            race();
            moveNumber--;
        }
        informWinner();
    }

    private void alertEnterCarName() {
        System.out.println(ALERT_ENTER_CAR);
    }

    private void saveCarName() {
        String names = Console.readLine();
        String[] nameArray = names.split(CAR_DIVISION);
        if (nameArray.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String name : nameArray) {
            if (name.length() > CAR_NAME_MAX) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < nameArray.length; i++) {
            carList.add(new Car(nameArray[i]));
        }
    }

    private void alertEnterMoveNumber() {
        System.out.println(ALERT_ENTER_MOVE_NUMBER);
    }

    private void saveMoveNumber() {
        String readLine = Console.readLine();
        try {
            moveNumber = Integer.parseInt(readLine);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (moveNumber <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void race() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            if(isMoveForward()) {
                car.addForward();
            }
            System.out.print(car.getName() + CAR_IS);
            System.out.println(car.getForward());
        }
        System.out.println();
    }

    private void informWinner() {
        List<String> winnerNames = new ArrayList<>();
        int maxForward = 0;
        for (Car car : carList) {
            if (maxForward == car.getForwardNumber()) {
                winnerNames.add(car.getName());
            }
            if (maxForward < car.getForwardNumber()) {
                winnerNames.clear();
                winnerNames.add(car.getName());
                maxForward = car.getForwardNumber();
            }
        }
        System.out.print(ALERT_WINNER_IS);
        String result = winnerNames.stream().collect(Collectors.joining(WINNER_DIVISION));
        System.out.println(result);
    }

    private Boolean isMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (randomNumber >= MOVE_FORWARD_MIN) {
            return true;
        }
        return false;
    }
}
