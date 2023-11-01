package racingcar;

import static java.util.Objects.isNull;
import static racingcar.Constants.*;
import static racingcar.Check.checkCarNameLengthOver;
import static racingcar.Check.checkEmptyCarName;
import static racingcar.Check.checkIntegerType;
import static racingcar.Check.checkPositiveNumber;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
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

        checkEmptyCarName(nameArray);
        checkCarNameLengthOver(nameArray);

        carList = addCarName(nameArray);
    }

    private void alertEnterMoveNumber() {
        System.out.println(ALERT_ENTER_MOVE_NUMBER);
    }

    private void saveMoveNumber() {
        String readLine = Console.readLine();
        moveNumber = StringToInteger(readLine);

        if (isNull(moveNumber)) {
            checkIntegerType();
        }
        checkPositiveNumber(moveNumber);
    }

    private void race() {
        for(Car car : carList) {
            if (isMoveForward()) {
                car.addForward();
            }
            System.out.print(car.getName() + CAR_IS);
            System.out.println(car.getForward());
        }
        System.out.println();
    }

    private void informWinner() {
        List<String> winnerNames = new ArrayList<>();
        pickWinner(winnerNames);

        System.out.print(ALERT_WINNER_IS);
        String result = ListToString(winnerNames);
        System.out.println(result);
    }

    private Boolean isMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (randomNumber >= MOVE_FORWARD_MIN) {
            return true;
        }
        return false;
    }

    private List<Car> addCarName(String[] nameArray) {
        return Arrays.stream(nameArray)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private Integer StringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String ListToString(List<String> winnerNames) {
        return winnerNames.stream()
                .collect(Collectors.joining(WINNER_DIVISION));
    }

    private void pickWinner(List<String> winnerNames) {
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
    }
}
