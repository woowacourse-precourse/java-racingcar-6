package racingprocess;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingProcess {
    String count;
    String name;
    public RacingProcess(String count, String name) {
        this.count = count;
        this.name = name;

        isPlusNumber(count);
        startRacingGame(count, name);
    }


    // 양의 정수인지 확인
    private void isPlusNumber(String count) throws IllegalArgumentException {
        int number = checkInt(count);
        if (number <= 0){
            throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
        }
    }

    // 입력값이 정수인지 확인
    private int checkInt(String count) throws IllegalArgumentException{
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력값을 넣어 오류발생");
        }
    }

    private void startRacingGame(String count, String name) {
        String[] nameList = name.split(",");
        String[][] output = new String[nameList.length][2];

        for(int i =0; i< output.length; i++) {
            output[i][0] = nameList[i];
            output[i][1] = "0";
        }

        for(int i=0; i < Integer.parseInt(count); i++) {
            String[][] result = decisionGoFowardNumber(output);
            outputPrint(result);
        }
    }

    private void outputPrint(String[][] result) {
        for (String[] strings : result) {
            System.out.printf("%s : %s%n", strings[0], "-".repeat(Integer.parseInt(strings[1])));
        }
        System.out.println();
    }

    private String[][] decisionGoFowardNumber(String[][] output) {
        for(int i =0; i< output.length; i++){
            int randomNumber = Randoms.pickNumberInRange(0,9); //실제로는 랜덤한 숫자가 생성
            int go = decisionGoFoward(randomNumber);
            output[i][1] = String.valueOf(Integer.parseInt(output[i][1]) + go);

        }
        return output;
    }

    private int decisionGoFoward(int randomNumber) {
        if(randomNumber >= 4) {
            return 1;
        } else{
            return 0;
        }
    }


}
