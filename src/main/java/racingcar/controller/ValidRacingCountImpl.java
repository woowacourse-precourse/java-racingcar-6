package racingcar.controller;

import racingcar.model.RemainRacingCount;
import racingcar.view.InputView;

public class ValidRacingCountImpl implements ValidRacingCount{

    public RemainRacingCount getValidRacingCount() {
        InputView inputView=new InputView();
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
