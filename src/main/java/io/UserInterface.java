package io;

import static constant.Constant.CAR_NAME_REQUEST_MESSAGE;

import basis.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;

public class UserInterface {
    Converter converter = new Converter();

    public LinkedHashMap<String, String> getCarNameHashMap() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
        String carName = Console.readLine();
        return converter.splitAndAddToMap(carName);
    }
}