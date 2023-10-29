package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static java.lang.System.exit;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] namelist = null;
        int[] scorelist;
        List<String> winner = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            namelist = getCarNames();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            exit(0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int N = getTrialNum();
        scorelist = new int[namelist.length];

//        입력받은 횟수만큼 반복
//        - 자동차 이름과 _로 전진 횟수 화면 출력
        for(int i=0; i<N; i++){
            judgeRunning(namelist, scorelist);
            for(int j=0; j<namelist.length; j++){
                System.out.println(namelist[j] + " : " + "_".repeat(scorelist[j]));
            }
            System.out.println();
        }

//        최종 우승자 결정
        for(int i=0; i<namelist.length; i++){
            if(scorelist[i] == Arrays.stream(scorelist).max().getAsInt()){
                winner.add(namelist[i]);
            }
        }

//        우승자 출력
//            - 우승자가 한 명이면 바로 출력
//            - 우승자가 두 명 이상이면 ',' 로 구분해서 출력
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winner.size()-1; i++){
            System.out.print(winner.get(i) + ", ");
        }
        System.out.println(winner.get(winner.size()-1));


    }

    public static String[] getCarNames() throws IllegalArgumentException{

        String name = Console.readLine();
        String[] names = name.split(",");

        for(int i=0; i<names.length; i++){
// fortest  System.out.println(names[i]);
            if(names[i].length() >5){
                throw new IllegalArgumentException();
            }
        }

        return names;
    }

    public static int getTrialNum(){
        int trial = 0;
        try {
            trial = Integer.parseInt(Console.readLine());
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input. You should input an integer type variable");
            exit(0);
        }

        return trial;
//        if(isInteger()){
//            throw new IllegalArgumentException();
//        }

    }
    //          - 자동차 마다 1~9 범위의 무작위 값을 추출
    //              - 4이상일때 전진
    //              - 3이하일 때 멈춤
    //              - 자동차별 전진 횟수 리스트 저장
    public static void judgeRunning(String[] namelist, int[] scorelist){

        for(int i=0; i<namelist.length; i++){
            int random = Randoms.pickNumberInRange(0,9);
            if(random>=4) scorelist[i]++;
        }

    }
}
