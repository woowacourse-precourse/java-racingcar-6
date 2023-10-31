package view;

import model.Car;
import model.Race;

public class OutputView {
    public void printPosition(Car car){
        System.out.printf("%s : ", car.getName());
        for(int i = 0; i<car.getPosition(); i++){
            System.out.printf("-");
        }
        System.out.printf("\n");
    }

    public void printResult(Race race){
        System.out.printf("실행 결과\n");
        for(int i = 0;i<race.getLaps();i++){
            for(Car car:race.getCarArrayList()){
                printPosition(car);
            }
            System.out.printf("\n");
        }
    }
}
