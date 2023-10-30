package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = Console.readLine();
        String[] car = inputCar.split(",");
        int carCount = car.length;

        for (int i = 0; i < carCount; i++) {
            if (car[i].length() > 5) {
                throw new IllegalArgumentException("잘못된 입력");
            }

        }

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTime = Console.readLine();
        int time = Integer.parseInt(inputTime);

        InputCarName inputCarName = new InputCarName();
        List<Integer> track = inputCarName.makeTrack(carCount);

        CarSimulate carSimulate = new CarSimulate();
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < time; i++) {
            carSimulate.goSimulate(carCount, track);
            carSimulate.viewCurrentProgress(carCount, car, track);
            System.out.println();
        }

        Winner winner = new Winner();
        List<Integer> result = winner.decisionWinner(track);
        winner.printResult(result, car);
    }
}
