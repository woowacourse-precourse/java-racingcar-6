package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Inputs {
    private static List<String> cars = new ArrayList<>();
    private static int count;

    public static List<String> getCars(){
        return cars;
    }

    public static int getCount(){
        return count;
    }

    public static void raiseIllegalArgumentException() {
        IllegalArgumentException e = new IllegalArgumentException();
        throw e;
    }



}
