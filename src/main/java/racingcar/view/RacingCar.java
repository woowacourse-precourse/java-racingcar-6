package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public List<String> gameStart() throws IOException {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String carName = bufferedReader.readLine();
            String[] userCar = carName.split(",");
            String tryNumber = bufferedReader.readLine();

            // Check for a trailing comma
            if (carName.endsWith(",")) {
                throw new IllegalArgumentException("유효하지 않은 데이터입니다.");
            }

            List<String> resultList = new ArrayList<>();
            resultList.add(tryNumber);

            for (String car : userCar) {
                resultList.add(car);
            }

            return resultList;

        } catch (Exception e) {
            throw new IllegalArgumentException("View>> 유효하지 않은 데이터입니다.");
        }
    };

    public void showLoad(List<String> name, List<String> location, int carNum){
        for(int i=0;i<carNum;i++){
            System.out.println(name.get(i)+ " : "+location.get(i));
        }
    }
}
