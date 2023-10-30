package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    public List<String> inputCarnames() {
        String rawCarnames = Console.readLine();
        return splitCarnames(rawCarnames);
    }

    private List<String> splitCarnames(String rawCarnames) {
        List<String> splitCarnames = new ArrayList<>();
        String nowCarnames = rawCarnames;

        if (rawCarnames.contains(",")) {


            while (nowCarnames.contains(",")) {
                int index = nowCarnames.indexOf(",");
                String tempCarnames = nowCarnames.substring(0, index).trim();
                checkCarnameSize(tempCarnames);
                splitCarnames.add(tempCarnames);
                nowCarnames = nowCarnames.substring(index + 1);
            }
        }
        if(!nowCarnames.isEmpty()) {
            checkCarnameSize((nowCarnames));
            splitCarnames.add(nowCarnames);
        }
        if(nowCarnames.isEmpty()) {
            checkCarnameSize(rawCarnames);
            splitCarnames.add(rawCarnames);
        }
        return splitCarnames;
    }
    private void checkCarnameSize(String Carname) {
        if (Carname.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
