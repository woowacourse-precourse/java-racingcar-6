package racingcar;

import java.util.ArrayList;

public class RaceGameManager {
    Car[] car;

    public RaceGameManager(Car[] car) {
        this.car = car;
    }

    public void noticeRaceResult(String[] carNameList, NumberGenerator Generator) { // 레이싱 실행 결과 출력

        for (int j = 0; j < carNameList.length; j++) {
            car[j].randomNumber = Generator.createRandomNumber();
            car[j].moveForward(car[j].randomNumber);
            System.out.print(car[j].carName + " : ");
            for (int i = 0; i < car[j].forwardCount; i++) {
                System.out.print('-');
            }
            System.out.println();
        }
        System.out.println();

    }

    public void noticeWinner() { // 최종 우승자 출력
        WinnerManager winnerManager = new WinnerManager(car);
        ArrayList<String> winnersList = winnerManager.returnWinnerList();
        System.out.print("최종 우승자 : ");
        for (String winner : winnersList) {
            System.out.print(winner + ",");
        }
    }
}
