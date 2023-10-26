# 기능 목록
## 게임 진행 순서
1. 자동차 입력
2. 자동차 생성
3. 시도 횟수 입력
4. 게임 진행
5. 결과 출력

## 클래스
- Car 클래스
  - 자동차 이름, 위치를 멤버변수로 가짐
- CarList 클래스
  - 자동차 리스트를 감싸는 일급컬렉션

## 자동차 입력 기능
- [ ] getCarInput 메서드
  - 사용자로부터 자동차 이름 목록을 입력받는다.
- [ ] validateCarInput 메서드
  - 문자열을 인수로 받아 자동차 이름 목록 형식에 적합한지 검사한다.
    - 빈 문자열인 경우 `IllegalArgumentException` 발생
    - 자동차 이름이 5자 이상이라면 `IllegalArgumentException` 발생
    - 중복된 자동차 이름이 있다면 `IllegalArgumentException` 발생

## 수행 횟수 입력 기능
- [ ] getAttemptInput 메서드
  - 사용자로부터 수행 횟수를 입력받는다.
- [ ] validateAttemptInput 메서드
  - 문자열을 인수로 받아 수행 횟수 형식에 적합한지 검사한다.
    - 빈 문자열인 경우 `IllegalArgumentException` 발생
    - 숫자가 아니라면 `IllegalArgumentException` 발생

## 게임 진행 기능
- [ ] moveRandomCar 메서드
  - CarList를 인수로 받아 랜덤한 Car 전진
  - [ ] move 메서드
    - 자동차를 앞으로 움직인다.

## 결과 출력 기능
- [ ] findWinners 메서드
  - 우승자가 담긴 CarList 반환
- [ ] printResult 메서드
  - CarList를 인수로 받아 결과 출력