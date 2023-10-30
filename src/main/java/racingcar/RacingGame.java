package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingGame {

    private int count;
    private RacingCars racingCars;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        racingCars = new RacingCars();

        for (String carName : carNames) {
            validateCarName(carName);
            racingCars.add(new RacingCar(carName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        count = Integer.parseInt(input);

        System.out.println("실행 결과");
        while (count > 0) {
            racingCars.turnOn();

            for (RacingCar car : racingCars.getRacingCars()) {
                System.out.println(car.getName() + " : " + convertDistanceToDash(car.getDistance()));
            }
            System.out.println();
            count--;
        }

        System.out.println("최종 우승자 :" + convertWinnersToStr(racingCars.getWinners()));
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private String convertDistanceToDash(int distance) {
        String dash = "";
        while(distance-- >0) {
            dash += "-";
        }
        return dash;
    }

    private String convertWinnersToStr(List<String> winners) {
        String finalWinners = "";
        for (String winner : winners) {
            finalWinners += " " + winner +",";
        }
        return finalWinners.substring(0,finalWinners.length() - 1);
    }
}
