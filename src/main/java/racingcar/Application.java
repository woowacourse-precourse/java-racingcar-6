package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }
}

class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        int maxPosition = 0;
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            int currentPosition = car.getPosition();
            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
                winners.clear();
                winners.add(car);
            } else if (currentPosition == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    public void runRace(int numAttempts) {
        for (int i = 0; i < numAttempts; i++) {
            for (Car car : cars) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                car.move(randomValue);
            }
            printRaceState(); // 각 이동 후 경주 상태 출력
        }
    }

    public void printRaceState() {
        System.out.println("\n실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Utils {
    public static List<String> parseInput(String input) {
        String[] splitInput = input.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : splitInput) {
            if(name.length() > 5)
                throw new IllegalArgumentException();
            carNames.add(name);
        }
        return carNames;
    }  

    public static String formatWinners(List<Car> winners) {
        if (winners.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            builder.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    } 
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = Console.readLine();
        List<String> carNames = Utils.parseInput(inputCar);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String strTryCount = Console.readLine();

        try{
            int tryCount = Integer.parseInt(strTryCount);

            Race race = new Race(cars);
            race.runRace(tryCount);
            List<Car> winners = race.getWinners();
            System.out.println("최종 우승자 : " + Utils.formatWinners(winners));
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}