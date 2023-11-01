package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램
        playGame();
    }

    private static void playGame(){

        String[] carNameArray=getCarName();
        int[] carForwardArray=new int[carNameArray.length];

        if (!isValidCarNames(carNameArray)) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }

        int attempts=getAttempts();
        getGameResult(carNameArray,carForwardArray,attempts);
    }

    private static String[] getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames=Console.readLine();
        return carNames.split(",");
    }

    private static int getAttempts(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static boolean isValidCarNames(String[] carNameArray){
        for (String name: carNameArray){
            if (name.length()>5){
                return false;
            }
        }
        return true;
    }

    private static void moveCars(String[] carNameArray,int[] carForwardArray) {
        for (int j=0; j<carNameArray.length; j++){
            int randomValue= Randoms.pickNumberInRange(0,9);
            if (randomValue>=4){
                carForwardArray[j]++;
            }
        }
    }

    private static void printForwardCounts(String[] carNameArray,int[] carForwardArray){
        StringBuilder result=new StringBuilder();
        for (int i=0;i<carNameArray.length;i++){
            result.append(carNameArray[i]).append(" : ").append("-".repeat(carForwardArray[i]));
            if (i < carNameArray.length-1){
                result.append(", ");
            }
        }
        System.out.println(result);
    }

    private static void getGameResult(String[] carNameArray, int[] carForwardArray,int attempts){
        System.out.println("실행 결과");

        for (int i=0;i<attempts;i++){
            moveCars(carNameArray,carForwardArray);
            printForwardCounts(carNameArray,carForwardArray);
        }
        int maxForwardCount=Arrays.stream(carForwardArray).max().orElse(0);
        String[] winners=getWinners(carNameArray,carForwardArray,maxForwardCount);
        printWinners(winners);

    }

    private static String[] getWinners(String[] carNameArray,int[] carForwardArray,int maxForwardCount){
        List<String> winnerList=new ArrayList<>();

        for (int i=0;i<carNameArray.length;i++){
            if (carForwardArray[i]==maxForwardCount){
                winnerList.add(carNameArray[i]);
            }
        }
        return winnerList.toArray(new String[0]);
    }

    private static void printWinners(String[] winners) {
        String winnersString=String.join(",",winners);
        System.out.println("최종 우승자 : "+winnersString);

    }
}