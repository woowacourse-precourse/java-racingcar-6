package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class PrintView {

  public void inputCarNameView() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  public void inputTryNumView() {
    System.out.println("시도할 횟수는 몇회인가요?");
  }

  public void carForwardView(List<Car> car) {
    System.out.println("실행 결과");
    for(int i=0;i<car.size();i++) {
      System.out.print(car.get(i).getName() + " : ");
      for(int k=0;k<car.get(i).getForward();k++)
        System.out.print("-");
    }
    System.out.println();
  }

  public void winnerView(List<Car> winnerList) {
    System.out.print("최종 우승자 : ");
    for (int i = 0; i < winnerList.size(); i++) {
      Car winner = winnerList.get(i);
      System.out.print(winner.getName());

      if (i < winnerList.size() - 1) {
        System.out.print(", ");
      }
    }
  }

}
