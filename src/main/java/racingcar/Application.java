package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import org.junit.platform.commons.util.StringUtils;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO : 자동차 이름 입력받음
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> winnerCarName = new ArrayList(); // 작으면 나오고 같거나 크면 들어간다.
        HashMap<String,Integer> carInfoMap = new HashMap<>();
        String inputStr = Console.readLine(); // 입력받은걸 , 를 기준으로 나눠서 배열에 저장해야됨.
        int maxCarNumber = 0; // 가장 멀리 간 자동차의 거리


        String[] splitStr = inputStr.split(",");

        if(splitStr.length<2){ // 2 이상 또는 음수 X (-> 정규식으로처리??)
            throw new IllegalArgumentException("게임 진행을 위해 자동차 이름을 최소 2개 이상 입력해주세요.");
        }
        for(String str : splitStr){ // 앞뒤 공백이 있을 경우 다 제거후에 리스트에 저장.
            //     carNameList.add(str.strip());
            if(str.strip().length()>5 || str.strip().length()==0){
                throw new IllegalArgumentException("이름은 최소 한글자 이상 다섯글자 이하로 작성해 주세요.");
            }
            carInfoMap.put(str.strip(),0);

            //     System.out.println(str.strip().length());
        }
        // todo : 공백 제거 하기. -> 이름 사이에 공백이 있는 경우는?
        // 1. 값을 하나씩 배열에 저장할때 마다 공백을 없애고 저장한다.
        // 2. 다른 방법을 찾아본다.
        System.out.println("시도할 회수는 몇회인가요?");
        int repeatNumber = Integer.parseInt(Console.readLine());



        // todo : 경주 시작 -> 랜덤으로 수를 뽑아서 경주를 진행한다.
        // 자동차 이름과 해당 위치 수가 짝이니까 해쉬를 이용하는게 좋을것 같음.

        // 해당 자동차의 랜덤 값이 4 이상이면 그 자동차 수를 하나 늘려줌.
        // 근데 해쉬 맵으로 할경우 key,value 중 value가 가장 큰 자동차를 고르기

        for(int i=0; i<repeatNumber; i++){ // 해당 횟수만큼 경기 진행
            for(Entry<String,Integer> entry:carInfoMap.entrySet()){
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if(randomNumber>=4) {
                    Integer value = entry.getValue();
                    entry.setValue(++value);
                }
            }


            for(Entry<String,Integer> entry:carInfoMap.entrySet()){
                System.out.printf("%s : %s\n",entry.getKey(),"-".repeat(entry.getValue()));
            }
            System.out.println();

        }
        for(Entry<String,Integer> entry:carInfoMap.entrySet()){ // 우승자 결정
            int tmp = entry.getValue();
            if(maxCarNumber<tmp){ // 기존 최대값보다 크거나 같으면(공동우승자 가능)
                maxCarNumber=tmp;// 최대값 갱신
                winnerCarName.clear(); // 전체 삭제
                winnerCarName.add(entry.getKey()); // 추가
            }else if(maxCarNumber==tmp){
                winnerCarName.add(entry.getKey()); // 추가
            }else{
                // nothing
            }
            // 기존 최댓값 보다 클경우 -> 리스트에 있던 값 전체 삭제하고 새로운 값 추가
            // 기존 최댓값과 같을 경우 -> 그냥 새로운 값만 추가
            // 기존 최댓값 보다 작을경우 -> nothing

        }
  //      System.out.println("최종 우승자 목록 : "+winnerCarName);
        String join = String.join(",",winnerCarName);
        System.out.printf("최종 우승자 : %s",join);



    // class를 어떤식으로 분리를 해야 할까 ?
        // 우선 Game 클래스에서는 게임을 진행한다.
        // Game.class
            //


    }
}

