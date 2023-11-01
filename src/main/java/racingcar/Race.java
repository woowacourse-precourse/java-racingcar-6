package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;

    public void play() {
        cars = getCars();
        int attempt = getAttemptNumber();
        for(int i = 0; i < attempt; i++) {
            setForwardValues();
            printRaceResult();
        }
        getWinners();
    }

    private void getWinners() {
        int max = getMaxTotalForward();
        List<Car> winners = findWinners(max);
        printWinners(winners);
    }

    private void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        if(winners.size() == 1) {
            System.out.println(winners.get(0).getName());
        }
        else {
            String winnerName = "";
            for(Car winner : winners) {
                winnerName += winner.getName() + ", ";
            }
            System.out.println(winnerName.substring(0, winnerName.length()-2));
        }
    }

    private List<Car> findWinners(int max) {
        List<Car> winners = new ArrayList<>();
        for(Car car : cars) {
            if(car.getTotalForward() == max) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxTotalForward() {
        int max = 0;
        for(Car car : cars) {
            if(car.getTotalForward() > max) {
                max = car.getTotalForward();
            }
        }
        return max;
    }

    private void printRaceResult() {
        System.out.println("실행 결과");
        for(Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            if(car.getForwardValue() >= 4) {
                printHyphens(car.getForwardValue());
                car.addTotalForward();
            }
            else {
                System.out.println();
            }
        }
    }

    private void printHyphens(int forwardValue) {
        System.out.println("-".repeat(forwardValue));
    }

    private void setForwardValues() {
        for(Car car : cars) {
            car.setForwardValue(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


    private int getAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        isValidateInput(input);
        return Integer.parseInt(input);
    }

    private void isValidateInput(String input) {
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c < '0' || c > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    private List<Car> getCars() {
        return Car.getNames();
    }

}
