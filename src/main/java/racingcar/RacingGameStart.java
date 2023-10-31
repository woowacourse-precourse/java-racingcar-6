package racingcar;

import camp.nextstep.edu.missionutils.Console;
import pojo.RacingCar;

public class RacingGameStart {
    private static final int NAME_LENGTH = 5;
    private static final String ENUM_ERROR_MESSAGE = "이름은 5자 이하만 가능합니다";

    public static void run() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        //레이싱 대회에 참가할 자동차 객체 배열을 생성합니다.
        RacingCar[] racingCars = createRacingCars(carNames);

        System.out.println("시도할 횟수는 몇회인가요?");
        int num = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");
        //runRace 메소드를 호출하여 자동차 객체 배열과 실행 횟수(num)를 전달하고, 게임의 진행 상황을 출력합니다.
        runRace(racingCars, num);
        //게임이 종료된 후, 우승자(들)의 이름을 출력합니다.
        printWinners(racingCars);
    }


    private static RacingCar[] createRacingCars(String carNames) {

        String[] carNamesList = carNames.split(",");
        RacingCar[] racingCars = new RacingCar[carNamesList.length];

        for (int i = 0; i < carNamesList.length; i++) {
            racingCars[i] = createRacingCar(carNamesList[i]);
        }

        return racingCars;
    }

    public static RacingCar createRacingCar(String carName) {

        String name = carName.trim();
        checkNameLength(name);

        return new RacingCar(name, 0);
    }


    private static void runRace(RacingCar[] racingCars, int num) {

        for (int i = 0; i < num; i++) {
            for (RacingCar car : racingCars) {
                RapsResult rR = new RapsResult(car);
                System.out.println(rR.forwardOrNot());
            }
            System.out.println();
        }
    }

    private static void printWinners(RacingCar[] racingCars) {

        PrintWinner printWinner = new PrintWinner(racingCars);

        System.out.print(printWinner.winnerListPrint());
    }

    public static void checkNameLength(String name) {

        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(ENUM_ERROR_MESSAGE);
        }
    }
}
