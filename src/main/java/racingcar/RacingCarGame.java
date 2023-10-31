package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> cars = new ArrayList<RacingCar>();
    private int moveCnt;
    private InputValidator inputValidator = new InputValidator();

    public void setRacingCarsByConsole() {
        String line = readLine();
        inputValidator.setRacingCars(line);
        String[] split = line.split(",");
        for (int i = 0; i < split.length; i++) {
            cars.add(new RacingCar(split[i]));
        }
    }

    public void setMoveCntByConsole() {
        String line = readLine();
        moveCnt = Integer.parseInt(line);
    }

    public void printCarRacingProcess() {
        for (int i = 0; i < moveCnt; i++) {
            for (RacingCar car : cars) {
                moveTry(car);
                car.printLocation();
            }
            System.out.println();
        }
    }

    private void moveTry(RacingCar car) {
        if (car.isAvailableMove()) {
            car.moveForward();
        }
    }

    public void printWinner() {
        List<String> winnerNames = new ArrayList<>();
        if (cars.size() == 0) {
            return;
        }

        int maxDistance = cars.get(0).getMoveDistance();

        for (RacingCar car : cars) {
            if (car.getMoveDistance() > maxDistance) {
                maxDistance = car.getMoveDistance();
            }
        }

        for (RacingCar car : cars) {
            if (car.getMoveDistance() == maxDistance) {
                winnerNames.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winnerNames.size(); i++) {
            System.out.print(winnerNames.get(i));
            if (i < winnerNames.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    public void printCarsLocation() {
        for (RacingCar car : cars) {
            car.printLocation();
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public int getMoveCnt() {
        return moveCnt;
    }
}
