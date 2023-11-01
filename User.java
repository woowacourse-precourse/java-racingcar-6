package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public void Name(String[] args) {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarNames = Console.readLine();
        String[] CarNamesArray = CarNames.split(",");
        int CarNameSize = CarNames.length();
        List<String> CarNamesList = new ArrayList<>();
        for (int i = 0; i < CarNamesArray.length; i++) {
            CarNamesList.add(CarNamesArray[i]);
        }
        System.out.print(CarNamesList);
        if (CarNameSize > 5 || CarNameSize == 0) {
            throw new IllegalArgumentException();
        }


//            public void CarNames_Exception(String[] args) {
//                int CarNameSize = CarNames.length();
//                if(CarNameSize > 5 || CarNameSize == 0) {
//
//                throw new IllegalArgumentException();
//                }
//            }

    }
}
