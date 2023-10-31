package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String[] inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameList = readLine().split(",");
        isCorrectName(nameList);
        return nameList;

    }

    private void isCorrectName(String[] nameList) {
        try {
            isCorrectLength(nameList);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }


    public String inputTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        String trial = readLine();
        isCorrectNumber(trial);
        return trial;
    }

    private void isCorrectNumber(String trial) {
        try {
            Double.parseDouble(trial); // 입력값이 문자가 아닌지 확인
            isCorrectTrialCount(trial);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void isCorrectLength(String[] nameList) {
        for (int i = 0; i < nameList.length; i++) {
            if (nameList[i].length() > 5 || nameList[i].isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void isCorrectTrialCount(String trial) {
        int trialCount = Integer.parseInt(trial);
        if (trialCount < 0) {
            throw new IllegalArgumentException();
        }
    }
}
