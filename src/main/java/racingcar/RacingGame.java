package racingcar;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    PrintStream printStream = System.out;
    List<Car> cars;
    int moveCount;

    public RacingGame() {
        this.cars = new ArrayList<Car>();
        this.moveCount = 0;
    }

    public void enterCarName() {
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (int i = 0; i < carNames.length; i++) {
            String carName = carNames[i];
            boolean isValidString = carName instanceof String;
            boolean isValidLength = carName.length() > 0 && carName.length() <= 5;
    
            if (!isValidString || !isValidLength) {
                throw new IllegalArgumentException();
            }

            this.cars.add(new Car(carName, 0));
        }
    }

    public void enterMoveCount() {
        String REGEXP_ONLY_NUM = "^[0-9]*$";
        String moveCount = Console.readLine();

        if (!Pattern.matches(REGEXP_ONLY_NUM, moveCount)) {
            throw new IllegalArgumentException();
        }

        this.moveCount = Integer.parseInt(moveCount);
    }

    public void start() {
        for (int i = 0; i < this.moveCount; i++) {
            this.run();

            List<String> currentMovedCarsReports = this.getCurrentMovedCarsReports();

            printStream.println(String.join("\n", currentMovedCarsReports));
            printStream.println();
        }
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<String>();
        int maxDistance = 0;

        Collections.sort(this.cars, new CarMovingDistanceComparator());

        for (int i = 0; i < this.cars.size(); i++) {
            Car car = this.cars.get(i);
            int movingDistance = car.getMovingDistance();

            if (maxDistance > movingDistance) {
                break;
            }
            winnerNames.add(car.getName());
            maxDistance = movingDistance;
        }

        return winnerNames;
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private String getMovingCommand() {
        int randomNumber = this.createRandomNumber();

        if (randomNumber >= 4) {
            return "FORWARD";
        }

        return "STOP";
    }

    private void run() {
        for (int i = 0; i < this.cars.size(); i++) {
            String movingCommand = getMovingCommand();
            Car car = this.cars.get(i);

            if (movingCommand == "FORWARD") {
                int movingDistance = car.getMovingDistance();
                
                car.setMovingDistance(movingDistance + 1);
            }
        }
    }

    private List<String> getCurrentMovedCarsReports() {
        int carsCount = this.cars.size();
        List<String> currentMovedCarsReports = new ArrayList<String>(carsCount);

        for (int i = 0; i < carsCount; i++) {
            Car car = this.cars.get(i);

            currentMovedCarsReports.add(car.toString());
        }

        return currentMovedCarsReports;
    }
}
