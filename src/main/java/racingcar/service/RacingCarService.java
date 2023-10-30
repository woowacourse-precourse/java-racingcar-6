package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingCarService {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();


    public List<String> InputCarName() {

        inputView.carInput();
        String s1 = Console.readLine();

        List<String> carName = List.of(s1.split(","));
        Set<String> carNameSet = new HashSet<>(carName);

        for (String s : carName) {
            if(s.isEmpty()){
                throw new IllegalArgumentException("1개 이상의 자동차 이름을 입력 해야 합니다.");
            }
        }

        for (String s : carName) {
            if((int)s.charAt(0)==32){
                throw new IllegalArgumentException("첫 글자는 공백으로 시작 할 수 없습니다.");
            }
        }

        for (String s : carName) {
            if (s.length() > 4) {
                throw new IllegalArgumentException("5자 이상의 자동차 이름은 입력 할 수 없습니다.");
            }
        }

        if(carName.size() != carNameSet.size()){
            throw new IllegalArgumentException("자동차 이름이 중복 되었습니다.");
        }

        return carName;
    }
}
