package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CreateCarList;
import java.util.HashMap;

public class SettingCar {
    public static HashMap<String, Integer> settingcar(){
        String input_carName = Console.readLine();
        CreateCarList createCar = new CreateCarList();
        return createCar.createCar_list(input_carName);
    }
}
