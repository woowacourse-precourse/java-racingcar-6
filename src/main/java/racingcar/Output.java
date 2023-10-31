package racingcar;

import java.util.ArrayList;

public class Output {
    public static ArrayList<String> resultSum(ArrayList<String>resultArray, ArrayList<String>userArray,int[] raceCount,int max){
        for (int i = 0; i < raceCount.length; i++) {
            if (raceCount[i] == max) {
                resultArray.add(userArray.get(i)); // 더 큰 값을 발견하면 최대값을 업데이트
            }
        }
        return resultArray;
    }

    public void printresult(ArrayList<String>resultArray){
        System.out.print("최종 우승자 : ");

        if(resultArray.size() == 1){
            System.out.print(resultArray.get(0));
        } else {
            System.out.print(resultArray.get(0));
            for(int i = 1; i < resultArray.size();i++){
                System.out.print(","+resultArray.get(i));

            }
        }
    }
}
