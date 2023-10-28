package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    public List<String> InputCarName(){
        String cars = Console.readLine();
        StringTokenizer carsDivision = new StringTokenizer(cars, ",");

        List<String> carNameList = new ArrayList<>();
        while(carsDivision.hasMoreTokens()){
            carNameList.add(carsDivision.nextToken());
        }
        return carNameList;
    }

    public int InputTryNum(){
        String tryNum = Console.readLine();
        return Integer.parseInt(tryNum);
    }
}
