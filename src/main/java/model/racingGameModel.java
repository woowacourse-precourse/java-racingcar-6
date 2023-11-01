package model;

import static model.utilityModel.isValidName;
import static model.number.MAX_NAME_LENGTH;

import java.util.ArrayList;
public class racingGameModel {
    public ArrayList<String> racingCarNames = new ArrayList<>();
    public int racingCount = 0;
    public racingGameModel(ArrayList<String> inputRacingCarNames, int inputRacingCount) {
        racingCarNames.addAll(inputRacingCarNames);
        racingCount = inputRacingCount;
    }
}

