package racingcar.domain;

public class GoOrNot {
    Boolean judgeNumber(int num) {
        if (4 <= num) {
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }
}
