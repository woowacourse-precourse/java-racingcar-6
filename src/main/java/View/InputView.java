package View;

import Config.GameConfig;
import Model.RacingCar;
import camp.nextstep.edu.missionutils.Console;
import Validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputView {

    public List<RacingCar> getNames(){
        String names = Console.readLine();
        List<RacingCar> racingCars = new ArrayList<>();
        List<String> nameList = Stream.of(names.split(GameConfig.nameSeparator))
                .map(String::strip)
                .toList();
        Validator.nameValidator(nameList);
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
