package racingcar.view;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private final String oneStep = "-";
    public void printGameResult(List<Car> carList){
        for(Car car : carList){
            String totalStep = oneStep.repeat(car.getStep());
            System.out.println(car.getName() + " : " + totalStep);
        }
        System.out.println();
    }

    public void gameStartMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void getAttemptsMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void gameResultMessage() {
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
