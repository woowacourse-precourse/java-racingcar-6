package model;

import static model.utilityModel.isValidName;
import static model.number.MAX_NAME_LENGTH;

import java.util.ArrayList;
public class racingGameModel {
    public ArrayList<String> racingCarNames = new ArrayList<>();
    public int racingCount = 0;

    public ArrayList<String> listUpRacingCar(String[] namesArray){
        ArrayList<String> racingCarNames = new ArrayList<>();

        for(String name : namesArray){
            if(isValidName(MAX_NAME_LENGTH, name)){
                racingCarNames.add(name);
            }
        }
        return racingCarNames;
    }
}