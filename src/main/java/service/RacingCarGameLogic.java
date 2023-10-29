package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.CarInformation;

public class RacingCarGameLogic {

    CarInformation carInformation = new CarInformation();
    List<String> carNames =new ArrayList<>();
    public void insertCarName(String[] carName){
        carNames.addAll(Arrays.asList(carName));
        carInformation.setCarNames(carNames);
    }
}
