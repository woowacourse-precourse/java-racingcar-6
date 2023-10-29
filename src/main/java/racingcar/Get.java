package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Get {

    // 사용자가 입력한 차 이름 받아오기
    public static String[] carName(){
        String[] cars = readLine().split(",");
        return cars;
    }

    // 사용자가 입력한 실행 횟수 받아오기
    public static int playCount(){
        int cnt = Integer.parseInt(readLine());
        return cnt;
    }

    /*
    // String[] -> List<String>
    public List<String> arrayTolist(String[] arr) {
        List<String> strList = new ArrayList(Arrays.asList(arr));

        return strList;
    }
    */
}


