package racingcar.domain;

import java.util.List;

public class Play {
    public boolean isGo(int randomNumber){
        if (randomNumber >= 4)
            return true;
        return false;
    }

    // 객체를 받아서 객체 값 자체를 바꿀지?
    // 값을 받아서 이걸 호출한 함수에서 car에 적용할지
    // 값과 객체 둘 다 받아서 객체를 바꾸고 리턴할지?
    // 굳이 updateData() 만들지 않고 위에서 바꿔도 될 듯
}
