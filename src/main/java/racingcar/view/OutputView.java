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
        System.out.println("실행 결과");
    }

    public void printWinner(List<Car> carList){
        int maxStep = carList.get(0).getStep();
        for (Car car : carList) {
            if (car.getStep() > maxStep) {
                maxStep = car.getStep();
            }
        }
        List<Car> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getStep() == maxStep) {
                winnerList.add(car);
            }
        }
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
