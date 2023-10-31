package racingcar;

import java.util.List;
import java.util.Map;

public class Car {

    public void makeCarListToMap(String nameList, Map<String, Integer> carMap ) {

        List<String> carNameList = List.of( nameList.split(",") );

        for ( String carName : carNameList ) {
            carMap.put( carName, 0 );
        }
    }

    public boolean validCarName( String nameList ) {
        List<String> carNameList = List.of( nameList.trim().split(",") );

        this.checkMinNumber( carNameList );

        for ( String carName : carNameList ) {

            this.checkNameLength( carName );
            this.checkIsEmpty( carName );
        }
        this.checkIsDuplicate( carNameList );

        return true;
    }

    private void checkNameLength( String name ) {

        if ( name.trim().length() > 5 ) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
        }
    }

    private void checkIsEmpty( String name ) {

        if ( name.trim().isEmpty() ) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 존재할 수 없습니다.");
        }
    }

    private void checkIsDuplicate( List<String> names ) {

        int originSize = names.size();
        int removeDuplicate = (int) names.stream().distinct().count();

        if ( originSize != removeDuplicate ) {
            throw new IllegalArgumentException("중복인 자동차 이름이 존재할 수 없습니다.");
        }
    }

    private void checkMinNumber( List<String> names ) {

        if ( names.size() <= 1 ) {
            throw new IllegalArgumentException("자동차 경주를 위해서는 2대 이상의 자동차가 존재해야 합니다.");
        }
    }
}
