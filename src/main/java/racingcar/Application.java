package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        Racing racing = new Racing();
        RCar[] cars = racing.separateCar(input);

        int racingGame = racing.racingCount(); 
        for (int i = 0; i < racingGame; i++){
            for (int j = 0; j < cars.length; j++){
                RandomNumber randomNumber = new RandomNumber();
                int number = randomNumber.createRandomNumber();
                Forward.forwardCar(number, cars[j]);
            }
            System.out.println();
        }

        Winner winner = new Winner();
        String winners = winner.findWinner(cars);

        // 우승자 출력
        System.out.println("최종 우승자 : " + winners);
    }
}
