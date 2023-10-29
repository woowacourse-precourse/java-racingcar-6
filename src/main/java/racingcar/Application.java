package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String stringCarNames = Console.readLine();

        if(!checkCarNames(stringCarNames)) throw new IllegalArgumentException();

        System.out.println("시도할 회수는 몇회인가요?");
        String number = Console.readLine();

        if(!checkNumber(number)) throw new IllegalArgumentException();

        System.out.println();
        System.out.println("실행 결과");

        //데이터 가공
        Map<String,StringBuilder> statusOfRacing = new HashMap<>();
        String[] arrayCarNames = stringCarNames.split(",");
        for(int i=0;i<arrayCarNames.length;i++){
            statusOfRacing.put(arrayCarNames[i],new StringBuilder());
        }

        for(int i=0; i<Integer.valueOf(number);i++){
            updateStatusOfRacing(statusOfRacing,arrayCarNames);

            for(int j=0;j< statusOfRacing.size();j++){
                System.out.println(arrayCarNames[j]+" : "+statusOfRacing.get(arrayCarNames[j]));
            }
            System.out.println();
        }

        int longestDistance = 0;

        // 가장 길게 진행한 거리를 찾는다
        for(int i=0;i<statusOfRacing.size();i++){
            if(longestDistance < statusOfRacing.get(arrayCarNames[i]).length()){
                longestDistance = statusOfRacing.get(arrayCarNames[i]).length();
            }
        }

        //longestDistance와 일치하는 자동차
        ArrayList<String> winnerList = new ArrayList<>();
        for(int i=0;i<statusOfRacing.size();i++){
            if(longestDistance == statusOfRacing.get(arrayCarNames[i]).length()) winnerList.add(arrayCarNames[i]);
        }

        if(winnerList.size()==1) System.out.println("최종 우승자 : " + winnerList.get(0));
        else {
            System.out.print("최종 우승자 : " + winnerList.get(0));
            for(int i=1;i< winnerList.size();i++){
                System.out.print(", "+winnerList.get(i));
            }
        }



    }



    public static boolean checkCarNames(String stringCarNames) {

        if(!stringCarNames.contains(",")|| stringCarNames.contains(" ")) return false;

        String[] arrayCarNames = stringCarNames.split(",");

        for(int i=0;i<arrayCarNames.length;i++){
            if(arrayCarNames[i].length()>5) return false;
        }

        Set<String> set = new HashSet<>();
        for (String name : arrayCarNames) {
            set.add(name);
        }

        if (set.size() != arrayCarNames.length) return false;

        return true;
    }

    public static boolean checkNumber(String number){
        return number.matches("[0-9]+");
    }

    public static boolean decideToForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber>=4) return true;
        else return false;
    }

    public static void updateStatusOfRacing(Map<String, StringBuilder> statusOfRacing, String[] arrayCarNames) {
        for(int i=0;i< statusOfRacing.size();i++){
            if(decideToForward()){
                statusOfRacing.put(arrayCarNames[i],statusOfRacing.get(arrayCarNames[i]).append("-"));
            }
        }
    }

}
