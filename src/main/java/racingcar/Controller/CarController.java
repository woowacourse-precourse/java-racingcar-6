package racingcar.Controller;

import java.util.ArrayList;
import racingcar.Model.CarModel;

public class CarController {

    ArrayList<CarModel> carModelList;

    public void setCarModels(String[] carList){

        for(String carName : carList){

            carModelList.add(new CarModel(carName));
        }
    }

    public ArrayList<CarModel> getCarModelList() {
        return carModelList;
    }

    public void goFoward(CarModel car,int dice){

        if(dice>=4){
            car.goForwardDistance();
        }
    }

}