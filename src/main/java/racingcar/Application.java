package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.CarController;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnerDto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarController carController = new CarController();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarsDto carsDto = carController.generateCars(Console.readLine());

        System.out.println("시도할 회수는 몇회인가요?");
        printWinner(carController.gameStartNTimes(carsDto, Console.readLine()));


    }

    private static void printWinner(WinnerDto winnerDto) {
        String[] winners = winnerDto.names();
        if (winners.length == 1) {
            System.out.println("최종 우승자 : " + winners[0]);
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append("최종 우승자 : ");
            for (int i = 0; i < winners.length - 1; i++) {
                sb.append(winners[i]);
                sb.append(", ");
            }
            sb.append(winners[winners.length - 1]);

            System.out.println(sb);
        }
    }
}
