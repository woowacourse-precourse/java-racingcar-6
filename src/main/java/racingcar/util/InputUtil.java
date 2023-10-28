package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputUtil {
    public static List<String> inputNames(String str){
        StringTokenizer st = new StringTokenizer(str,",");
        List<String> results = new ArrayList<>();

        while(st.hasMoreTokens()){
            results.add(st.nextToken());
        }

        return results;
    }
}
