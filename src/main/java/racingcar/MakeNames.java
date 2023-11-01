package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
