# 구현할 기능 목록

## 게임 시작

- [x] 게임 시작 시 ``경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`` 출력
- [x] 자동차 입력 받기
    - [ ] 쉼표를 기준으로 5자 이하만 가능 - 아닐 시 ``IllegalArgumentException``
    - 자동차 수는 무제한
- [x] `시도할 회수는 몇회인가요?` 출력
- [x] readline으로 횟수 n 입력

## 게임 실행

- [x] `실행결과` 출력
- [x] 자동차별 전진조건에 의해 움직임 카운트
- [x] n번 반복하며 움직인 거리 출력

## 게임 마무리

- [ ] 움직인 거리에 많은 사람 출력(동점시 `,`를 기준으로 구분하여 출력)

## 에러처리 - `IllegalArgumentException`

- [ ] 이름이 5글자 이상일 때
    - `abcde`
    - `abc,abcde`
- [ ] 시도할 회수가 숫자가 아닐 때

## 클래스 설계

- [x] RacingCarGame
    - Integer tryNumber
    - `List<RacingCar> racingcarList`
    - void requestCarNames()
    - void requestTryNumber()
    - void play()
    - void tryOnce()
    - void printWinners()
- [x] RacingCar
    - String name
    - Integer movedDistance
        - 초기 값 0
    - RacingCar(String name)
        - 이름 5자 이하 검증
    - void tryMoving() // 랜덤값에 따라 movedDistance 증가 또는 유지
    - void printResult() // 각 차수별 실행결과 출력
    - Integer getMovedDistance()