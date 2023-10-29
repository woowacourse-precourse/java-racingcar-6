package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CreateCarList;

import java.util.List;

public class SettingCar {
    public static List<Car> settingcar(){
        String input_carName = Console.readLine();
        CreateCarList createCar = new CreateCarList();
        return createCar.createCar_list(input_carName);
    }
}
