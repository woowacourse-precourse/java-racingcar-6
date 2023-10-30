package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RacingGame {
    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        Validator.validateName(inputName);

        String[] inputArray = inputName.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : inputArray) {
            carList.add(generateCar(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String inputRound = Console.readLine();
        Validator.validateRound(inputRound);

        System.out.println("실행 결과");
        int repeatNumber = Integer.parseInt(inputRound);
        for (int i = 0; i < repeatNumber; i++) {
            for (Car car : carList) {
                car.moveForward();
                System.out.printf("%s : %s%n", car.name, createPositionPrint(car.position));
            }
            System.out.println();
        }

        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            int maxPosition = getMaxPosition(carList);
            if (maxPosition == car.position) {
                winnerList.add(car.name);
            }
        }

        System.out.print("최종 우승자 : ");
        StringJoiner winnerPrint = new StringJoiner(", ");
        for (String winner : winnerList) {
            winnerPrint.add(winner);
        }
        System.out.print(winnerPrint);

    }

    private static Car generateCar(String name) {
        return new Car(name);
    }

    private static String createPositionPrint(int position) {
        return "-".repeat(position);
    }

    private static int getMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            if (maxPosition < car.position) {
                maxPosition = car.position;
            }
        }
        return maxPosition;
    }
}
