자동차 경주 미션 구현 목록

1. InputValidator : 사용자의 입력을 검증
    1) checkNames(String input) : 자동차의 이름 길이 검증
    2) checkCount(String input) : 이동할 횟수 검증
2. InputView : 사용자의 입력을 받는 클래스
    1) getCarsName() : 경주에 참여하는 자동차들의 이름을 입력받음
    2) getPlayCount() : 이동할 횟수를 입력받음
3. Moving : 이동 횟수마다 이동 여부를 결정하는 클래스
    1) decideAllCars(int cars) : 각 자동차들의 전진하는 조건 확인 후 반환
4. Car : 각 자동차를 나타내는 엔티티
    1) move() : 한 번 전진
5. RacingGameService : 게임을 진행하는 서비스 클래스
    1) init() : 게임 초기 설정 진행
    2) start() : 게임 시작
6. OutputView : 화면에 게임을 출력하는 클래스
    1) printCarScores(List<Car> cars) : 각 자동차의 이동 결과 출력
    2) printStart() : 시작 메세지 출력
    3) printPlayCount() : 게임 진행 횟수 입력 메세지 출력
    4) printWinner(String winners) : 게임 우승자 출력

프로젝트 진행 시 주의사항

1. 각 기능을 구현할 때 마다 커밋
2. 클래스마다 테스트 코드 작성
3. 메서드, 변수, 커밋 메세지는 의미 있게