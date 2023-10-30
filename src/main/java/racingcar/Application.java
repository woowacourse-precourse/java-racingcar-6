package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racers = Console.readLine();
        String[] racersList = racers.split(",");

        RacingCar[] RacingCars = new RacingCar[racersList.length];

        for(int i = 0; i< racersList.length; i++){
            RacingCar car = new RacingCar(racersList[i].trim(),0);
            car.checkNameLength(car.getName());
            RacingCars[i] = car;
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        int num = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");
        for(int i=0; i<num; i++){
            for(int j=0; j< racersList.length; j++){
                RapsResult rR = new RapsResult(RacingCars[j]);
                System.out.println(rR.forwardOrNot());
            }
            System.out.println();
        }

        PrintWinner pW = new PrintWinner(RacingCars);
        System.out.print(pW.winnerListPrint());

    }
}
