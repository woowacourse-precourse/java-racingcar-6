package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingGameView {
    public void printInputPlayersMsg(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputGameTurnMsg(){
        System.out.println("시도할 회수는 몇회인가요?");
    }


    public void printInitResultMsg(){
        System.out.println();
        System.out.println("실행 결과");
    }
    public void printTurnResultMsg(List<Car> cars){
        for (Car car : cars){
            System.out.print(car.getName()+" : ");
            //score 출력
            for (int i = 0; i< car.getScore(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void printResultMsg(ArrayList<Car> winners){
        System.out.print("최종 우승자 : ");
        System.out.print(winners.remove(0).getName());
        while(!winners.isEmpty()){
            System.out.print(", " + winners.remove(0).getName());
        }

    }
}
