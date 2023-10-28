package racingcar;

public class Winner {
    public static String findWinner(RCar[] cars) {
        int maxForwardCount = 0;
        StringBuilder winners = new StringBuilder();

        // 최대 전진 횟수 찾기
        for (RCar car : cars) {
            int forwardCount = car.getForwardCount();
            if (forwardCount > maxForwardCount) {
                maxForwardCount = forwardCount;
                // 새로운 최대 전진 횟수를 찾으면 우승자 목록을 초기화하고 현재 자동차를 추가
                winners = new StringBuilder(car.getName());
            } else if (forwardCount == maxForwardCount) {
                // 최대 전진 횟수와 동일한 경우 현재 자동차를 추가
                winners.append(", ").append(car.getName());
            }
        }

        // 우승자가 없는 경우 빈 문자열 반환, 있으면 쉼표로 구분된 우승자 목록 반환
        return winners.toString();
    }
}
