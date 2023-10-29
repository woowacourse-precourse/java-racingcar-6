package racingcar.Controller;

import java.util.ArrayList;
import racingcar.Model.CarModel;

public class CarController {

    ArrayList<CarModel> carModelList = new ArrayList<>();

    public void setCarModels(String[] carList){

        for(String carName : carList){

            carModelList.add(new CarModel(carName));
        }
    }

    public ArrayList<CarModel> getCarModelList() {
        return carModelList;
    }

    public void goForward(CarModel car, int dice){

        if(dice>=4){
            car.goForwardDistance();
        }
    }

    public void printDistance(){

        int distance;
        String carName;
        StringBuilder sb;

        for(CarModel car : carModelList){

            sb = new StringBuilder();
            distance = car.getForwardDistance();
            carName = car.getName();

            sb.append(carName).append(" : ");

            for(int i = 0; i < distance;i++){
                sb.append("-");
            }

            System.out.println(sb);
        }
    }

}