package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputUtil {
    public static List<String> inputNames(String str){
        StringTokenizer st = new StringTokenizer(str,",");
        List<String> results = new ArrayList<>();

        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            if(temp.length()>5) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다!");
            results.add(temp);
        }

        return results;
    }
}
