package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    Exception exception = new Exception();
    public List<String> setCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameInput = Console.readLine();
        List<String> carNames = List.of(nameInput.split(","));
        exception.isValidName(carNames);

        return carNames;
    }

    public int setMoves() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        exception.isValidNumber(input);

        return Integer.parseInt(input);
    }

    public void printResult (Car car) {
        String stringBuilder = car.getName() + " : " +
                "-".repeat(car.getDistance());
        System.out.println(stringBuilder);
    }

    public void listOfResult (List<Car> carList) {
        for (Car car : carList) {
            printResult(car);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
