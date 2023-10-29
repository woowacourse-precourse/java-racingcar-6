package racingcar.view;

import racingcar.controller.Input;
import racingcar.controller.Output;

public class progressView {
    private final Output carOut = new Output();
    private final Input carIn = new Input();

    private progressView() {}

    //car string : distance 출력 함수
    public void printDistance(int distanceSize) {
        for(int i = 0; i < distanceSize; i++) {
            System.out.print("-");
        }
    }

    public void printProgress() {
        for(int i = 0; i < carOut.getSize(); i++) {
            System.out.println(
                    carOut.getInstance().getComponentIndexOf(i).getName() + " : " );
            printDistance(carOut.getInstance().getComponentIndexOf(i).getDistance());
        }
    }

    //epoch 만큼 반복해서 출력해주는 함수
    public void printAllProgress() {
        for(int i = 0; i < carOut.getEpoch(); i++) {
            printProgress();
            carOut.getService().insertCarDistance();
            carOut.getInstance().updateDistance();
        }
    }

    //input string 함수
    public void inputCarString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carIn.inputName();
    }

    //input epoch 함수
    public void inputCarEpoch() {
        System.out.println("시도할 회수는 몇회인가요?");
        carIn.inputEpoch();
    }

    public void print() {
        inputCarString();
        inputCarEpoch();
        printAllProgress();
    }

    private static class SingleInstanceHolder {
        private static final progressView INSTANCE = new progressView();
    }

    public static progressView view() {
        return SingleInstanceHolder.INSTANCE;
    }
}
