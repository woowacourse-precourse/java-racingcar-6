# 자동차 경주 게임

## 기능 구현 목록
1. racingcar
    - Application: 게임을 실행하는 메인 클래스

2. domain 
   - Car: 자동차의 정보를 담은 클래스
   - CarDto : 자동차의 이름과 위치 정보를 데이터 전송 객체 형식으로 변환 후 전달하는 클래스
   - RandomNumberGenerator: 0에서 9 사이에서 무작위 값을 생성하는 클래스
   - MoveStrategy : 자동차가 움직일 수 있는지 여부를 결정하는 인터페이스
   - RandomMoveStrategy : MoveStrategy 인터페이스를 구현하는 클래스 
   
3. view
    - InputView.java: 사용자 입력 처리 뷰 클래스
    - OutputView.java: 게임 출력 뷰 클래스

4. controller
   - Controller: 자동차 경주 게임의 주요 로직 제어