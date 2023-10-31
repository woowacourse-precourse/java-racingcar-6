package racingcar;

import java.util.ArrayList;

public class WinnerManager {
    Car[] car;

    ArrayList<String> winnersList = new ArrayList<>();
    ArrayList<Integer> maxIndexList = new ArrayList<>();
    int maxIndex;
    public WinnerManager(Car[] car) {
        this.car = car;
    }




    public void getIndexOfMaxForwardCount() { // 가장 많이 전진한 자동차의 인덱스 구하기
        for (int i = 0; i < car.length - 1; i++) {
            if (car[maxIndex].forwardCount < car[i + 1].forwardCount) {
                maxIndex = i + 1;
            }
        }
    }

    public void findValuesEqualToMax() { // 동점인 우승자가 있는지 구하기
        for (int i = 0; i < car.length; i++) {
            if (car[i].forwardCount == car[maxIndex].forwardCount) {
                maxIndexList.add(i);
            }
        }
    }

    public ArrayList<String> getWinnersByForwardCount() { // 우승자 명단 List를 반환

        return winnersList;
    }
}

