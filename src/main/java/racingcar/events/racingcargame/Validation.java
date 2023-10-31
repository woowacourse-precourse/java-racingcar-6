package racingcar.events.racingcargame;

import java.util.Objects;

public class Validation {

    public String[] progressValidate(int count, String progress[], int j){
        // 랜덤 선택 결과가 4이상인지 검증
        if(count >= 4){
            progress[j] += "-";
        }
        return progress;
    }

    public int maxLengthValidate(String[] input, String[] progress, int max){

        max = progress[0].length();
        // 최대 길이 판단 메소드
        for(int i=1; i<input.length; i++){
            max = whatIsMax(progress, max, i);
        }
        return max;
    }

    private static int whatIsMax(String[] progress, int max, int i) {
        // 최대길이를 판단하는 메소드
        if(max < progress[i].length()){
            max = progress[i].length();
        }
        return max;
    }

    public String winnerValidate(String[] input, String[] progress, String winner, int max){
        // 승자 판단 메소드
        for(int i=0; i<input.length; i++){
            winner = whoIsWinner(input, progress, winner, max, i);
        }
        return winner;
    }

    private static String whoIsWinner(String[] input, String[] progress, String winner, int max, int i) {
        // 최대 길이와 길이가 같으면 승자로 판단, 다수의 사용자일 경우 ", "를 추가하고 승자 이름을 입력한다.
        if(max == progress[i].length() && !Objects.equals(winner, "")){
            winner += ", " ;
            winner += input[i];
        }else if(max == progress[i].length()){
            winner += input[i];
        }
        return winner;
    }

}
