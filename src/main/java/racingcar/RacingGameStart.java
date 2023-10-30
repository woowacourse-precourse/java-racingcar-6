package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameStart {
    public static void run(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        String[] carsList = carNames.split(",");
        RacingCar[] racingCars = createRacingCars(carsList);

        System.out.println("시도할 횟수는 몇회인가요?");
        int num = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");
        runRace(racingCars, num);

        printWinners(racingCars);
    }

    private static RacingCar[] createRacingCars(String[] carNames) {
        RacingCar[] racingCars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            checkNameLength(carNames[i]);
            racingCars[i] = new RacingCar(carNames[i].trim(), 0);
        }
        return racingCars;
    }

    private static void runRace(RacingCar[] racingCars, int num){
        for(int i=0; i<num; i++){
            for(RacingCar car : racingCars){
                RapsResult rR = new RapsResult(car);
                System.out.println(rR.forwardOrNot());
            }
            System.out.println();
        }
    }

    private static void printWinners(RacingCar[] racingCars) {
        PrintWinner pW = new PrintWinner(racingCars);
        System.out.print(pW.winnerListPrint());
    }

    public static void checkNameLength(String name){
        if(name.length() > 5){

            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
