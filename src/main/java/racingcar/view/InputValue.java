package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.HashSet;
import java.util.List;

public class InputValue {

    public static String[] getRacingCars() {

        String input = Console.readLine();

        String temp = input.replaceAll(" ", "");

        String[] names = temp.split(",");

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < names.length; i++) {
            if(names[i].length() > 5) throw new IllegalArgumentException();
            set.add(names[i]);
        }

        if(set.size() != names.length) throw new IllegalArgumentException();

        return names;
    }

}
