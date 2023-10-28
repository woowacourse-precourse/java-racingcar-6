package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
public class OutputView {
    public void gameStart(){
        System.out.println("실행 결과");
    }
    public void inputCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void inputCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void gameSituation(ArrayList<Car> carArrayList){
        for(int i=0;i<carArrayList.size();i++){
            System.out.println(carArrayList.get(i).toString());
        }
    }
    public void winner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }
}