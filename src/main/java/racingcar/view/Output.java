package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class Output {

    public void printStart(){
        System.out.println("\n실행 결과");
    }

    public void printProgress(String name, int move){
        System.out.print(name + " : ");
        for(int i=0; i<move;i++){
            System.out.print("-");
        }
        System.out.println(" ");
    }

    public void printWinner(List<Car> winner){
        System.out.print("최종 우승자 : ");

        for(int i=0 ; i<winner.size() ; i++){
            System.out.print(winner.get(i).getName());
            if(i!=winner.size()-1){
                System.out.print(", ");
            }
        }
    }

}