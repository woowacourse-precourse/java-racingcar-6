package racingcar;
import java.util.ArrayList;

public class Finishing {
    public Finishing(){
    }

    public void findingMax(ArrayList<String> carList, ArrayList<String>[] result){
        ArrayList<Integer> distanceList = new ArrayList<>();
        int max = 0;

        for(int i = 0; i < result.length; i++){
            distanceList.add(result[i].size());
        } // 총 얼마 갔는 지 입력하기

        for(int j = 0; j < (distanceList.size() - 1); j++){
            if(j == 0){
                max = distanceList.get(0);
            }
            else if(max <= distanceList.get(j)){
                max = distanceList.get(j);
            }
            else{
                continue;
            }
        } // 가장 큰 값 구하기

        int cnt = 0;
        for(int k = 0; k < distanceList.size(); k++) {
            if(distanceList.get(k) == max){
                if(cnt == 0){
                    System.out.print("최종 우승자 : " + carList.get(k));
                    cnt++;
                }
                else{
                    System.out.print(", " + carList.get(k));
                }
            }
        } // 우승자 구하기
    }
}
