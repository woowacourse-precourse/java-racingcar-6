package racingcar;

import java.util.Arrays;

public class ExceptionInput {
    public static boolean checkNameLength(String[] names) {
        for(int i=0;i< names.length;i++) {
            int len = names[i].length();
            if( len < Constants.MIN_NAME_LEN || len > Constants.MAX_NAME_LEN) {
                return false;
            }
        }
        return true;
    }
}
