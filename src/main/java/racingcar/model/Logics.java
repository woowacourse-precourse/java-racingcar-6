package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.DataObj;

public class Logics {
    public static String forwardOrNot () {
        int randomNumbers = Randoms.pickNumberInRange(0, 9);
        if(randomNumbers >= 4) {
            return "-";
        }
        return "";
    }

    public static String[] splitNames (String names) {
        return names.split(",");
    }

    public static String winners (DataObj[] Datas) {
        int maxNum = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Datas.length; i++) {
            int progressLength = Datas[i].getProgress().length();

            if (progressLength > maxNum) {
                maxNum = progressLength;
                result = new StringBuilder(Datas[i].getName());
            } else if (progressLength == maxNum) {
                result.append(", ").append(Datas[i].getName());
            }
        }

        return result.toString();
    }

}
