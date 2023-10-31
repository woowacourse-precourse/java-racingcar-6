package racingcar.controller;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RaceController {

    private int round = 0;

    public void setRound(int round) {
        checkRange(round);
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public List<RacingCar> ready(String input) {
        List<RacingCar> racingCarList = new ArrayList<>();
        // 입력에 콤마가 없을 경우 (최소 2대의 자동차 입력)
        checkAtLeastTwo(input);
        // 콤마 앞이나 뒤에 자동차 이름이 없는 경우 (문자열이 콤마로 시작하거나 끝나는 경우)
        checkInvalidNameFrontOrBack(input);

        String[] carNameList = input.split(",");
        for(String carName : carNameList) {
          // 콤마 사이에 자동차 이름이 없을 경우
          checkInvalidNameMiddle(carName);
          // 자동차 이름이 길이 제한(1~5자)을 벗어났을 경우
          checkLimitLength(carName);

          racingCarList.add(new RacingCar(carName));
        }

        return racingCarList;
    }

    public void start(List<RacingCar> racingCarList) {
        System.out.println("\n실행 결과");

        for(int i = 1; i <= round; i++) {
          playRace(racingCarList);
          checkRace(racingCarList);
        }
    }

    public void finish(List<RacingCar> racingCarList) {
        List<String> winnerList = getWinnerList(racingCarList);
        printWinnerList(winnerList);
    }

    private void checkRange(int round) {
        if(round < 1)
          throw new IllegalArgumentException("올바르지 않은 시도 회수입니다.");
    }

    private void checkAtLeastTwo(String input) {
        if(!input.contains(","))
          throw new IllegalArgumentException("최소 2대의 자동차가 필요합니다.");
    }

    private void checkInvalidNameFrontOrBack(String input) {
        if(input.startsWith(",") || input.endsWith(","))
          throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");
    }

    private void checkInvalidNameMiddle(String carName) {
        if(carName.isEmpty())
          throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");
    }

    private void checkLimitLength(String carName) {
        if(carName.length() > 5)
          throw new IllegalArgumentException("자동차 이름 길이 제한(1~5자)을 벗어났습니다.");
    }

    private void playRace(List<RacingCar> racingCarList) {
        for(RacingCar car : racingCarList)
          car.move();
    }

    private void checkRace(List<RacingCar> racingCarList) {
        for(RacingCar car : racingCarList) {
          car.display();
        }
        System.out.println();
    }

    private List<String> getWinnerList(List<RacingCar> racingCarList) {
        int max = 0;
        for(RacingCar car : racingCarList) {
          if(car.getPlace() > max)
            max = car.getPlace();
        }

        List<String> winnerList = new ArrayList<>();
        for(RacingCar car : racingCarList) {
          if(car.getPlace() == max)
            winnerList.add(car.getName());
        }

        return winnerList;
    }

    private void printWinnerList(List<String> winnerList) {
        System.out.print("최종 우승자 : ");

        for(int i = 0; i < winnerList.size(); i++) {
          System.out.print(winnerList.get(i));

          if(i+1 != winnerList.size())
            System.out.print(", ");
        }
    }
}
