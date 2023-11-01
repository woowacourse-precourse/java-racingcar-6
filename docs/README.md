## ✏️ 구현할 기능 목록

### 객체

1. car : 자동차

- 자동차 이름 저장하는 변수
- 이동 거리 저장하는 변수

- 메서드
    - move() : 조건에 만족하여 전진
    - canMove() : 전진 가능한지 조건 체크

# Enum

- Standard
    - Four(4) : 무작위 숫자가 4 이상 일지 비교시 사용
    - Five(5) : 자동차 이름이 5자리 이하 인가? 비교시 사용

# Constant

- 정적 메시지 모음

### Service (클래스 별 테스트 코드 추가)

1. PlayRacingGame : 비지니스 로직(레이싱 게임), 자동차 이동 현황 출력
2. PrintResult : 최종 우승자 출력
3. UserInput : 사용자 입력 값 (자동차 이름, 시도 할 횟수)
4. UserInputValidate : 사용자 입력 값 검증
    1. 자동차 이름 검증
        - 입력 값이 null 인가?
        - 입력 값이 빈 값 인가?
        - 자동차 이름이 5자리 이하인가?
    2. 시도 할 횟수 검증
        - 입력 값이 null 인가?
        - 입력 값이 1이상의 정수인가?

### 주요 메서드 정의 & 설명

1. inputCarName() : 자동차 이름 입력
2. validate(String[] names) : 자동차 이름 검증 (이름은 5자 이하만 가능)
3. tryCount() : 시도할 회수는 입력
4. tryCountValidate(String moveCount) : 시도할 회수 입력값 검증 (1이상의 숫자여야 합니다.)
3. play(int moveCount, List<Car> cars) : 레이싱 게임 시작
4. printCarStatus(List<Car> cars) : 게임 중간 캐릭터별 전진 상황 출력
5. printWinner() : 최종 우승자 출력  