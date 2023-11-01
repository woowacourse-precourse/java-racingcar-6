package racingcar.controller;

import racingcar.model.RemainRacingCount;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;

public class ValidRacingCountImpl implements ValidRacingCount{

    private final InputView inputView;

    public ValidRacingCountImpl(InputView inputView){
        this.inputView=inputView;
    }
    public RemainRacingCount getValidRacingCount() {

        String s= inputView.inputRacingCount();
        int remainRacingCountNum;
        try{
            remainRacingCountNum=Integer.parseInt(s);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("정수가 아닌 입력입니다");
        }

        if(remainRacingCountNum<=0){
            throw new IllegalArgumentException("자연수가 아닌 입력입니다");
        }

        return new RemainRacingCount(remainRacingCountNum);


    }
}
