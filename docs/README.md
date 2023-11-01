# 자동차 경주 🏎

## 게임 시작 🕹️

- [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
- [x] 자동차 이름 입력 프롬프트
    - [x] 쉼표(,)를 기준으로 구분
    - [x] 잘못된 값을 입력시 `IllegalArgumentException`을 발생
        - [x] 이름은 5자 이하만 가능(잘못된 값을 입력시 `IllegalArgumentException`을 발생)
        - [x] (추가) 이름은 1자 이상만 가능(잘못된 값을 입력시 `IllegalArgumentException`을 발생)
- [x] "시도할 회수는 몇회인가요?" 출력
- [x] 시도할 회수 입력 프롬프트
    - [x] 잘못된 값을 입력시 `IllegalArgumentException`을 발생
        - [x] (추가) 양의 정수만 가능
- [x] "실행 결과"출력

## 게임 진행 🏎️

아래 절차를 시도할 회수 만큼 반복

- [x] 각 자동차 마다 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 0에서 9사이의 무작위 값을 추출
- [x] 무작위 값에 따라 전진
    - [x] 무작위 값이 4 이상일 경우 전진
- [x] 각 자동차마다 실행 결과를 출력
  ```
  pobi : --
  woni : ----
  jun : ---
  ```

## 최종 우승자 출력 🏆

- [x] 최종 우승자를 출력
  ```
  최종 우승자 : pobi
  ```
    - [x] 여러 명일 시 쉼표(,)를 이용하여 구분
      ```
      최종 우승자 : pobi, jun
      ```