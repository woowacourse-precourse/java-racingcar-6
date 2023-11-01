package racingcar;

import static racingcar.Constants.*;
import static racingcar.Exception.checkCarNameLengthOver;
import static racingcar.Exception.checkEmptyCarName;
import static racingcar.Exception.checkInteger;
import static racingcar.Exception.checkWithinRange;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Car> carList;
    private Integer tryNumber;

    public Game() {
        this.carList = new ArrayList<>();
        this.tryNumber = 0;
    }

    public void run() {
        alertEnterCarName();
        saveCarName();
        alertEnterTryNumber();
        saveTryNumber();
        while (tryNumber > 0) {
            race();
            tryNumber--;
        }
        informWinner();
    }

    private void alertEnterCarName() {
        System.out.println(ALERT_ENTER_CAR);
    }

    private void saveCarName() {
        String readLine = Console.readLine();
        String[] names = readLine.split(CAR_DIVISION);

        checkEmptyCarName(names);
        checkCarNameLengthOver(names);

        carList = addCar(names);
    }

    private void alertEnterTryNumber() {
        System.out.println(ALERT_ENTER_TRY_NUMBER);
    }

    private void saveTryNumber() {
        String readLine = Console.readLine();
        tryNumber = convertStringToInteger(readLine);

        checkInteger(tryNumber);
        checkWithinRange(tryNumber);
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
        List<String> winnerNames = pickWinner();

        System.out.print(ALERT_WINNER_IS);
        String result = arrangeWinner(winnerNames);
        System.out.println(result);
    }

    private Boolean isMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (randomNumber >= MOVE_FORWARD_MIN) {
            return true;
        }
        return false;
    }

    private List<Car> addCar(String[] nameArray) {
        return Arrays.stream(nameArray)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private Integer convertStringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private List<String> pickWinner() {
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
        return winnerNames;
    }

    private String arrangeWinner(List<String> winnerNames) {
        return String.join(WINNER_DIVISION, winnerNames);
    }
}
