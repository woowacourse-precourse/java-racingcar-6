package domain;

import java.util.Arrays;
import java.util.List;
import domain.Car;
import validate.ValidateWinner;

public class CarDrive {


    static Car[] carsList;
    static int carnumbers;
    public static void getCarNames(List<String> carNames){
        carnumbers = carNames.size();
        //
        carsList = new Car[carnumbers];
        for(int i=0; i<carnumbers; i++){
            carsList[i] = new Car();
            carsList[i].setCarname(carNames.get(i));
        }
    }

    public static void driving(int tries){
        for(int i=0 ; i<tries ; i++){
            outPutCars();
            System.out.println();
        }
    }
    public static void outPutCars(){
        for(int i=0; i<carnumbers; i++){
            GameOutput.carNameOutput(carsList[i].getCarname());
            carsList[i].appendDistance();
            GameOutput.carDistance(carsList[i].getDistance());
        }
    }

    public static String Winner() {
        return ValidateWinner.checkJointWinner(carsList,carnumbers);
        //조인트 위너면 걍 , + " " + 카이름 추가
    }



}
