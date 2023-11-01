package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Refree {
    public List<Car> cars;
    public List<String> winners;
    public void playRace() {
        CarGenerator carGenerator = new CarGenerator();
        winners = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carList = Console.readLine();
        carNameInputError(carList);

        cars = carGenerator.createCar(carList);

        System.out.println("시도할 회수는 몇회인가요?");
        int moveNum = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for(int i = 0; i < moveNum; i++) {
            playTurn();
        }
        System.out.println();
    }
    public Boolean isForward(int num) {
        return num >= 4;
    }

    public void playTurn() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (Car car : cars) {
            int randNum = numberGenerator.createRandomNumber();
            if (isForward(randNum)) {
                car.moveForward();
            }
        }

        for (Car car : cars) {
            car.printStatus();
        }
    }

    public void getWinners() {
        int max_count = 0;
        for (Car car : cars) {
            if(max_count < car.forward_count) {
                max_count = car.forward_count;
            }
        }

        for (Car car : cars) {
            if(max_count == car.forward_count) {
                this.winners.add(car.name);
            }
        }
    }

    public void printWinners() {
        System.out.print("최종 우승자 : ");
        String winnersName = String.join(",",this.winners);
        System.out.println(winnersName);
    }

    public void carNameInputError(String input) {
        if(input.length() == 0) {
            throw new IllegalArgumentException();
        }
        String[] carNames = input.split(",");
        for(String name : carNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

}
