package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class MakeNames {
    public List<String> makeNames(){
        List<String> names = new ArrayList<>();
        Utils utils = new Utils();
        String originalStr;

        originalStr = utils.inputStr();
        names = commaSplit(originalStr);
        return names;
    }

    public List<String> commaSplit(String originalStr){
        List<String> names;
        String[] tmpNames;

        tmpNames = originalStr.split(",");
        names = new ArrayList<String>(Arrays.asList(tmpNames));
        return names;
    }
    public int commaCheck(String str){
        int commaNum = 0;

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ',')
                commaNum++;
        }
        return commaNum;
    }
}
