package view;

import model.Car;

public class OutputView {
    public void printPosition(Car car){
        System.out.printf("%s : ", car.getName());
        for(int i = 0; i<car.getPosition(); i++){
            System.out.printf("-");
        }
        System.out.printf("\n");
    }
    public void printResult(){
    }
}
