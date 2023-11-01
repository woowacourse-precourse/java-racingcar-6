package racingcar.domain.racing.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.IndexModel;

/**
 * 레이싱 게임에 참가하는 자동차를 나타냅니다. IndexModel 추상 클래스를 상속하여 Repository에 순차적인 index를 가지는 방식으로 저장될 수 있습니다.
 */
public class Car extends IndexModel {

    private final Name name;
    private final Positions positions = Positions.create();

    private Car(String strName) {
        name = Name.create(strName);
    }

    /**
     * 주어진 이름으로 새로운 자동차 인스턴스를 생성하는 정적 팩토리 메서드입니다.
     *
     * @param strName 자동차의 이름
     * @return 새로운 자동차 인스턴스
     */
    public static Car create(String strName) {
        return new Car(strName);
    }

    /**
     * 문자열 자동차 이름 리스트에서 자동차 인스턴스 리스트를 생성합니다.
     *
     * @param strNameList 문자열 자동차 이름 리스트
     * @return 자동차 인스턴스 리스트
     */
    public static List<Car> createList(List<String> strNameList) {
        return strNameList.stream()
                .map(Car::create)
                .collect(Collectors.toList());
    }

    /**
     * 자동차의 이름을 반환합니다.
     *
     * @return 자동차의 이름
     */
    public String getName() {
        return name.getName();
    }

    /**
     * 자동차의 위치 중 가장 큰 위치를 계산하여 반환합니다.
     *
     * @return 가장 높은 위치
     */
    public int calcMaxPosition() {
        return positions.calcMaxPosition();
    }

    /**
     * 특정 턴에서 자동차의 위치를 조회합니다.
     *
     * @param index 위치를 조회할 턴 수
     * @return 해당 턴에서의 위치
     */
    public int findPositionAt(int index) {
        return positions.findPositionAt(index);
    }

    /**
     * 랜덤 숫자에 기반하여 자동차의 위치를 업데이트합니다.
     *
     * @param randomNum 랜덤 숫자
     */
    public void addPositionByRandomNum(int randomNum) {
        positions.addPositionByRandomNum(randomNum);
    }

    /**
     * 자동차의 현재 위치가 주어진 위치와 동일하거나 큰지 확인합니다.
     *
     * @param position 비교할 위치
     * @return 현재 위치가 주어진 위치와 동일하거나 크면 true, 그렇지 않으면 false
     */
    public boolean isCurrPositionSameOrOver(int position) {
        return positions.isCurrPositionSameOrOver(position);
    }
}