package racingcar;

import org.mockito.internal.matchers.Null;
import racingcar.service.AddValueService;
import racingcar.service.VerificationService;
import racingcar.view.InputValues;
import racingcar.view.OutputValues;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        AddValueService addValueService = new AddValueService();
        addValueService.addCarNames("test1,test2");
        for (int i = 0 ; i < addValueService.carNameList.length ; i ++) {
            System.out.println(addValueService.carNameList[i]);

        }
        }
        // TODO: 프로그램 구현
    }

