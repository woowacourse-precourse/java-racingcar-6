package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = Console.readLine();
        String[] car = inputCar.split(",");
        final int carCount = car.length;

        //예외처리
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

        System.out.println();
        System.out.println("실행 결과");

        RandomNumberGenerator randNum = new RandomNumberGenerator();
        CarSimulate carSimulate = new CarSimulate();

        for (int i = 0; i < time; i++) {
            for (int j = 0; j < track.size(); j++) {
                randNum.generateRandomNumber();
                int randomNumber = randNum.getRandomNumber();
                carSimulate.goSimulate(randomNumber, j, track);
            }
            carSimulate.viewCurrentProgress(car, track);
            System.out.println();
        }

        Winner winner = new Winner();
        int bestRecord = winner.calculateBestRecord(track);
        List<Integer> result = winner.findWinnerindex(track, bestRecord);
        winner.printResult(result, car);
    }
}
