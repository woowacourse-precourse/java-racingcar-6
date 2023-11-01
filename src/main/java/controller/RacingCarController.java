package controller;

import Service.RacingService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingCarController {
    private final RacingService racingService;
    public RacingCarController() {
        this.racingService = new RacingService();
    }

    public void addCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        String[] s = Console.readLine().split(",");
        carNameConfirm(s);
        racingService.addCar(s);
    }

    public void startCarRace() {
        System.out.println("시도할 회수는 몇회인가요?");
        int i = Integer.parseInt(Console.readLine());
        System.out.println("실행 결과");
        List<String> car = racingService.getCar();
        for (int j = 0; j < i; j++) {
            List<String> racingResult = racingService.racing();//각 차수별 경주 결과를 구한다.
            for (int k = 0; k <racingResult.size(); k++) {
                System.out.println(car.get(k) + " : " +racingResult.get(k));
            }
            System.out.println();
        }
    }
    public void carNameConfirm(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void resultCarRace() {
        System.out.print("최종 우승자 : ");
        int maxSize = racingService.getMaxSize();
        List<String> winner = racingService.findWinner(maxSize);
        for (int i = 0; i <winner.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winner.get(i));
        }
    }
}
