package model;

import java.util.ArrayList;
public class racingGameModel {
    public ArrayList<String> racingCarNames = new ArrayList<>();

    public ArrayList<String> listUpRacingCar(String[] namesArray){
        utilityModel utilityModel = new utilityModel();
        number num = new number();

        ArrayList<String> racingCarNames = new ArrayList<>();
        int maxLength = num.MAX_NAME_LENGTH;

        for(String name : namesArray){
            if(utilityModel.isValidName(maxLength, name)){
                racingCarNames.add(name);
            }
        }

        return racingCarNames;
    }
}