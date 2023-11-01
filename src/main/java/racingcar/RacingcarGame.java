package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {

    public void gameStart() {
        List<Car> cars = CarInput.getCarsFromUser();
        int numOfTrial = trialInput.getTrialFromUser();
        RaceManager.startRace(cars, numOfTrial);
        resultOutput.printResult(cars);
    }


    public class trialInput {
        public static int getTrialFromUser() {
            System.out.println("시도 할 횟수는 몇회인가요?");
            String userInput = Console.readLine();
            int numofTrial = Trial.validatenumOfTrial(userInput);
            return numofTrial;
        }
    }

    public class RaceManager {
        public static void startRace(List<Car> cars, int numOfTrial) {
            for (int i = 0; i < numOfTrial; i++) {
                System.out.println();
                for (Car car : cars) {
                    car.move();
                    car.finalresult();
                }
            }
        }
    }

    public class CarInput {
        public static List<Car> getCarsFromUser() {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String userInput = Console.readLine();
            List<String> names = Name.validateNames(userInput);

            List<Car> cars = Car.createCars(names);
            return cars;

        }
    }

    public class Trial {
        public static int validatenumOfTrial(String userInput) {
            int numofTrial;
            try {
                numofTrial = Integer.parseInt(userInput);
                if (numofTrial <= 0) {
                    throw new IllegalArgumentException("숫자 1 이상 입력하세요.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자를 입력하세요.");
            }
            return numofTrial;
        }
    }

    public class resultOutput {
        public static void printResult(List<Car> cars) {
            List<String> winner = raceWinner.getwinner(cars);
            System.out.println("\n최종 우승자 : " + String.join(", ",winner));
        }
    }

    public class raceWinner {
        public static List<String> getwinner(List<Car> cars) {
            List<String> winner = new ArrayList<>();
            int maxPosition = cars.stream()
                    .mapToInt(Car::carPosition)
                    .max()
                    .orElse(0);

            for (Car car : cars) {
                if (car.carPosition() == maxPosition) {
                    winner.add(car.carNamePrint());
                }
            }

            return winner;
        }
    }
}
