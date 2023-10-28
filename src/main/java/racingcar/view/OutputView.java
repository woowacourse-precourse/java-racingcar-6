package racingcar.view;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    String oneStep = "-";
    public void printGameResult(List<Car> carList){
        for(Car car : carList){
            String totalStep = oneStep.repeat(car.getStep());
            System.out.println(car.getName() + " : " + totalStep);
        }
        System.out.println();
    }

    public void GameResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printWinner(List<Car> winnerList){
        System.out.print("최종 우승자 : ");
        for(int i=0;i<winnerList.size();i++){
            if(i != winnerList.size() -1){
                System.out.print(winnerList.get(i).getName()+", ");
            } else if (i == winnerList.size()-1) {
                System.out.print(winnerList.get(i).getName());
            }

        }
    }

}
