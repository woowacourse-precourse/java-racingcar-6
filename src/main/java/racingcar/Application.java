package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.GenerateRandomNum;
import racingcar.domain.InputCarName;
import racingcar.domain.InputUser;
import racingcar.domain.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputCarName carName = new InputCarName();
        GenerateRandomNum randomNum = new GenerateRandomNum();
        InputUser inputUser = new InputUser();
        View view = new View();
        List<String> result = new ArrayList<>();
        result = carName.createCar();
        for(int i = 0; i < inputUser.inputMove(); i++){
            view.viewResult(result);
        }



    }
}
