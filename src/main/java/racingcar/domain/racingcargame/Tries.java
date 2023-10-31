package racingcar.domain.racingcargame;

public class Tries {

    // 시도 횟수를 저장하는 필드
    int tries;

    // 시도 횟수의 예외를 확인하기 위한 체크 필드
    String chk;

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public String getChk() {
        return chk;
    }

    public void setChk(String chk) {
        this.chk = chk;
    }
}
