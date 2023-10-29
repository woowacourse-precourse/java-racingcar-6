package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] namelist = null;
        int[] scorelist;
        List<String> winner = new ArrayList<>();
        int N =0;

//      사용자에게 경주할 자동차 이름 집합 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            namelist = getCarNames();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            return ;
        }

        System.out.println("시도할 회수는 몇회인가요?");
        try {
            N = getTrialNum();
        }
        catch(NumberFormatException e){
            System.out.println("잘못된 입력입니다. 자연수를 입력하세요.");
            return ;
        }

        scorelist = new int[namelist.length];

//      입력받은 횟수만큼 반복
//        - 자동차 이름과 _로 전진 횟수 화면 출력
        for(int i=0; i<N; i++){
            judgeRunning(namelist, scorelist);
            for(int j=0; j<namelist.length; j++){
                System.out.println(namelist[j] + " : " + "_".repeat(scorelist[j]));
            }
            System.out.println();
        }

//      최종 우승자 결정
        for(int i=0; i<namelist.length; i++){
            if(scorelist[i] == Arrays.stream(scorelist).max().getAsInt()){
                winner.add(namelist[i]);
            }
        }

//      우승자 출력
//          - 우승자가 한 명이면 바로 출력
//          - 우승자가 두 명 이상이면 ',' 로 구분해서 출력
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winner.size()-1; i++){
            System.out.print(winner.get(i) + ", ");
        }
        System.out.println(winner.get(winner.size()-1));


    }

//  이름 입력받기
    public static String[] getCarNames() throws IllegalArgumentException{
//    - 이름은 ,를 기준으로 구분
//      - string 배열에 자동차 이름 저장
        String name = Console.readLine();
        String[] names = name.split(",");

        for(int i=0; i<names.length; i++){
//          - 이름은 다섯자 이하의 string type
            if(names[i].length() >5){
                throw new IllegalArgumentException();
            }
        }

        return names;
    }
// 시도 횟수 입력받기
    public static int getTrialNum() {
        int trial = 0;
        trial = Integer.parseInt(Console.readLine());

        return trial;
    }

//     전진 여부 결정하기
    public static void judgeRunning(String[] namelist, int[] scorelist){
//      - 자동차 마다 1~9 범위의 무작위 값을 추출
//      - 자동차별 전진 횟수 리스트 저장
        for(int i=0; i<namelist.length; i++){
            int random = Randoms.pickNumberInRange(0,9);
            if(random>=4) scorelist[i]++;
        }

    }
}
