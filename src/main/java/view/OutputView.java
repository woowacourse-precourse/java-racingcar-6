package view;

import model.Car;
import model.Race;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OutputView {
    public void printPosition(Car car){
        System.out.printf("%s : ", car.getName());
        for(int i = 0; i<car.getPosition(); i++){
            System.out.printf("-");
        }
        System.out.printf("\n");
    }

    public void printResult(){
        System.out.printf("실행 결과\n");
    }

    public void printLine(){
        System.out.printf("\n");
    }

    public void printWinner(ArrayList<String> winnerlist){
        String winner = (String) winnerlist.stream().collect(Collectors.joining(", "));
        System.out.printf("최종 우승자 : %s", winner);
    }
}
