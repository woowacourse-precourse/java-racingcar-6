package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameStart {
    public static void run(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] carsList = carNames.split(",");

        RacingCar[] RacingCars = createRacingCars(carsList);

        for(int i = 0; i< carsList.length; i++){
            RacingCar car = new RacingCar(carsList[i].trim(),0);
            car.checkNameLength(car.getName());
            RacingCars[i] = car;
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        int num = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");
        for(int i=0; i<num; i++){
            for(int j=0; j< carsList.length; j++){
                RapsResult rR = new RapsResult(RacingCars[j]);
                System.out.println(rR.forwardOrNot());
            }
            System.out.println();
        }

        PrintWinner pW = new PrintWinner(RacingCars);
        System.out.print(pW.winnerListPrint());

    }

    private static RacingCar[] createRacingCars(String[] carNames) {
        RacingCar[] racingCars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            racingCars[i] = new RacingCar(carNames[i].trim(), 0);
        }
        return racingCars;
    }
}
