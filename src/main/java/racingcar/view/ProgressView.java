package racingcar.view;

import java.util.ArrayList;
import racingcar.controller.Input;
import racingcar.controller.Output;

public class ProgressView {
    private final Output carOut = new Output();
    private final Input carIn = new Input();

    private ProgressView() {}

    //car string : distance 출력 함수
    public void printDistance(int distanceSize) {
        for(int i = 0; i < distanceSize; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printProgress() {
        for(int i = 0; i < carOut.getSize(); i++) {
            System.out.print(
                    carOut.getInstance().getComponentIndexOf(i).getName() + " : " );
            printDistance(carOut.getInstance().getComponentIndexOf(i).getDistance());
        }
    }

    //epoch 만큼 반복해서 출력해주는 함수
    public void printAllProgress() {
        for(int i = 0; i < carOut.getEpoch(); i++) {
            carOut.getInstance().updateDistance();
            printProgress();
            System.out.println();
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

    public void printWinner() {
        ArrayList<Integer> haveMaxDistanceIndex = new ArrayList<>();
        int maxDistance = 0;

        for(int i = 0; i < carOut.getSize(); i++) {
            int currentDistance = carOut.getInstance().getComponentIndexOf(i).getDistance();
            if(currentDistance > maxDistance) {
                maxDistance = currentDistance;
                haveMaxDistanceIndex.clear();
                haveMaxDistanceIndex.add(i);
            } else if (currentDistance == maxDistance) {
                haveMaxDistanceIndex.add(i);
            }
        }

        System.out.print("최종 우승자 : ");

        for(var index : haveMaxDistanceIndex) {
            System.out.print(carOut.getInstance().getComponentIndexOf(index).getName() + " ");
        }
    }

    public void process() {
        inputCarString();
        inputCarEpoch();

        carOut.getService().carInit();
        printAllProgress();
        printWinner();
    }

    private static class SingleInstanceHolder {
        private static final ProgressView INSTANCE = new ProgressView();
    }

    public static ProgressView view() {
        return SingleInstanceHolder.INSTANCE;
    }
}
