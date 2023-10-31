package racingcar;

public class OutputWinner {
    public static void outputWinner(String[] player, String[] playerDash, int max){
        int cnt = 0;
        String result = "";
        System.out.print("최종 우승자 : ");
        for (String dash : playerDash) {
            if (max == dash.length()) {
                result = result + player[cnt] + ", ";
            }
            cnt++;
        }
        System.out.print(result.substring(0, result.length() - 2));
    }
}