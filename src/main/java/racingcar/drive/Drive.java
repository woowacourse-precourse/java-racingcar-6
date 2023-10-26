package racingcar.drive;

import camp.nextstep.edu.missionutils.Randoms;

public class Drive {
    
    public int lapsToDrive(String input) {
        int userNum;
        try {
            userNum = Integer.parseInt(input);
            if (userNum < 0) {
                throw new IllegalArgumentException("0 이상의 숫자를 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력해 주세요.");
        }

        int lapsToDrive = 0;
        for (int opportunity = 0; opportunity < userNum; opportunity++) {
            int randomNum = Randoms.pickNumberInRange(0,9);
            if (4 <= randomNum && randomNum <= 9) {
                lapsToDrive++;
            }
        }

        return lapsToDrive;
    }
}
