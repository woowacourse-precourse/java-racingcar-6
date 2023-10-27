package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Input {
    public List<String> getCarNameList() {
        List<String> carNameList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(Console.readLine(), ",");
        while (stringTokenizer.hasMoreTokens()) {
            carNameList.add(stringTokenizer.nextToken());
        }

        return carNameList;
    }

    public int getTryCount(){
        int tryCount = Integer.parseInt(Console.readLine());
        return tryCount;
    }
}
