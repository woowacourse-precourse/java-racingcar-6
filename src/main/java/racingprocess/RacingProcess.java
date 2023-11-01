package racingprocess;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
        List<String> Winner = null;

        for(int i=0; i < Integer.parseInt(count); i++) {
            String[][] result = decisionGoFowardNumber(output);
            outputPrint(result);
            Winner = whoIsBestDriver(result);
        }
        System.out.println("최종 우승자 : " + String.join(", ", Winner));
    }

    private void outputPrint(String[][] result) {
        for (String[] strings : result) {
            System.out.printf("%s : %s%n", strings[0], "-".repeat(Integer.parseInt(strings[1])));
        }
        System.out.println();
    }

    private List<String> whoIsBestDriver(String[][] result) {

        int topScore = findTopScorers(result);
        List<String> winnerSearch = findTopPlayers(result, topScore);
        return winnerSearch;
    }
    // 최고 스코어 값 추출

    private int findTopScorers(String[][] result) {
        int maxScore = 0;

        for (int i = 0; i < result.length; i++) {
            int score = Integer.parseInt(result[i][1]);

            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }


    // 최고 스코어를 가진 드라이버 이름 추출
    private List<String> findTopPlayers(String[][] result, int topScore) {
        List<String> topPlayers = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            int score = Integer.parseInt(result[i][1]);

            if (score == topScore) {
                topPlayers.add(result[i][0]);
            }
        }
        return topPlayers;
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
