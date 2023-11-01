package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeNames {
    public List<String> makeNames(){
        List<String> names;
        Utils utils = new Utils();
        String originalStr;
        IntegrityCheck integrityCheck = new IntegrityCheck();

        originalStr = utils.inputStr();
        if (integrityCheck.originalNameIntegrityCheck(originalStr)){
            throw new IllegalArgumentException();
        }
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
