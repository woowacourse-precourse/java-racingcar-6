package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class InputValue {

    public static String[] getRacingCarsNames() {

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

    public static int getRacingRange() {

        String input = Console.readLine();

        String temp = input.replaceAll(" ", "");

        if(!temp.matches("^[0-9]+$")) throw new IllegalArgumentException();

        return Integer.parseInt(temp);
    }

}
