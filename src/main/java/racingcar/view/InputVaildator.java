package racingcar.view;

import java.util.List;

public class InputVaildator {

    public void isNameLessThan5Char(List<String> carNames) {
        //리스트 길이만큼 돌리기
        //만약 5자 이하면 통과, 아니면 예외처리
        for (int i = 0; i < carNames.size(); i++) {
            if(carNames.get(i).length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }
}
