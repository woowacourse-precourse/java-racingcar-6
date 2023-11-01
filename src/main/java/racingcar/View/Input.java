package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.GameConfig;
import racingcar.validator.Validator;
import racingcar.dto.CarNameRequst;
import racingcar.dto.MoveCountRequest;
import racingcar.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Input {

    public Input(){};
    public List<CarNameRequst> getInputForNames(){
        String inputData = reanLineValidateNull();
        String [] names = StringUtil.seperate(inputData, GameConfig.CAR_NAME.getSeperator());

        return  Arrays.stream(names)
                .map(CarNameRequst::new)
                .collect(Collectors.toList());
    }

    public MoveCountRequest getInputForMoveCount(){
        String inputData = reanLineValidateNull();

        Validator.validNumberic(inputData);
        Validator.validateNull(inputData);

        return new MoveCountRequest(Integer.parseInt(inputData));
    }

    public String reanLineValidateNull(){
        String input = Console.readLine();
        Validator.validateNull(input);
        return input;
    }
}
