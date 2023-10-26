package View;

import Config.GameConfig;
import Model.RacingCar;
import camp.nextstep.edu.missionutils.Console;
import Validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<RacingCar> getNames(){
        String names = Console.readLine();
        List<String> nameList;
        List<RacingCar> racingCars = new ArrayList<>();
        Validator.nameValidator(names);
        nameList = List.of(names.split(GameConfig.nameSeparator));
        for (String name : nameList){
            racingCars.add(new RacingCar(name));
        }
        return racingCars;
    }

    public int getTrial(){
        String trial = Console.readLine();
        Validator.trialValidator(trial);
        return Integer.parseInt(trial);
    }
}
