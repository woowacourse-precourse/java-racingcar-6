package racingcar.model;

import camp.nextstep.edu.missionutils.Console;

public class StepCount {
    private int stepCount;

    public StepCount() {
        int stepCount = userInputToInt();
        if (!validateStepCount(stepCount)) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요");
        }
        this.stepCount = stepCount;
    }

    private boolean validateStepCount(int stepCount) {
        return stepCount > 0;
    }

    public int decreaseStep(){
        return --stepCount;
    }

    private int userInputToInt(){
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    public boolean isStepCountZero(){
        return stepCount==0;
    }

}
