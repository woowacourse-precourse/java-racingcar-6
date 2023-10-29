package racingcar.view;

import racingcar.controller.Output;
import racingcar.model.CarObject;

public class progressView {
    private final Output car = new Output();

    //car string : distance 출력 함수
    //epoch 만큼 반복해서 출력해주는 함수
    //input string 함수
    //input epoch 함수

    public void printProgress() {

        for(int i = 0; i < car.getSize(); i++) {


            car.getService().insertCarDistance();
            car.getInstance().updateDistance();
        }
    }
}
