package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingController {
    private final CarService carService = new CarService();
    private final RacingService racingService = new RacingService();

    public void racing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> splitInput = Arrays.asList(input.split(","));

        List<Car> carList = this.carService.getCars(splitInput);

        System.out.println("시도할 회수는 몇회인가요?");
        String input2 = Console.readLine();

        int cnt = Integer.parseInt(input2);

        System.out.println("실행 결과");

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < carList.size(); j++) {
                this.racingService.move(carList.get(j));
                System.out.printf("%s : %s\n", carList.get(j).getName(), "-".repeat(carList.get(j).getDistance()));
            }
            System.out.println();
        }

        List<Car> winnerList = this.racingService.getWinner(carList);

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i).getName());
            if (i < winnerList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
