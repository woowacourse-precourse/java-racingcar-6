package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        String[] carNameList = carsInput.split(",");

        System.out.println("시도할 횟수는 몇회인가요?");
        int attempts = Integer.parseInt(Console.readLine());


        NumberGenerator Generator = new NumberGenerator();
        Car[] car = new Car[carNameList.length];
        WinnerManager winnerManager = new WinnerManager(car);
        RaceGameManager raceGameManager = new RaceGameManager(car);

        int i = 0;
        for (String carName : carNameList) { // 자동차 객체 생성 및 초기화
            car[i] = new Car(carName);
            i++;
        }

        while (attempts != 0) { // 입력받은 시도 횟수만큼 실행
            raceGameManager.noticeRacingResult(carNameList, Generator);
            attempts--;
        }

        for (int k = 0; k < carNameList.length; k++) {
            System.out.println(car[k].carName + "의 전진횟수: " + car[k].forwardCount);
        }

        raceGameManager.noticeWinner();



    }
}
