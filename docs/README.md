# 미션 - 자동차 경주

## 🔍 기능 구현 목록

- [x] 경주할 자동차 이름 입력 받기
  - [x] 예외 사항
    - [x] 입력받은 이름이 5자 이하가 아닌 경우
- [x] 시도 횟수 입력 받기
  - [x] 예외 사항
    - [x] 숫자가 아닌 경우
    - [x] 0 이하인 경우
- [x] 게임 시작
  - [x] 0 ~ 9 사이 무작위 값 뽑기
  - [x] 전진
    - [x] 4 이상의 값을 뽑았을 경우
    - [x] 전진한 숫자만큼 대쉬(-)로 변환
  - [x] 정지
    - [x] 전진 조건에 맞지 않을 경우 정지
  - [x] 각 차수별 실행 결과 출력
- [x] 최종 우승자 출력
  - [x] 최대 이동 거리 구하기
  - [x] 최대 이동 거리와 동일한 자동차 이름 구하기
  - [x] 공동 우승자 쉼표 구분

## 🗂️ 디렉터리 구조

 📦src<br/>
 ┣ 📂main<br/>
 ┃ ┗ 📂java<br/>
 ┃ ┃ ┗ 📂racingcar<br/>
 ┃ ┃ ┃ ┣ 📂Controller<br/>
 ┃ ┃ ┃ ┃ ┗ 📜RacingController.java<br/>
 ┃ ┃ ┃ ┣ 📂Model<br/>
 ┃ ┃ ┃ ┃ ┣ 📜MemberState.java<br/>
 ┃ ┃ ┃ ┃ ┗ 📜RacingGame.java<br/>
 ┃ ┃ ┃ ┣ 📂View<br/>
 ┃ ┃ ┃ ┃ ┣ 📜InputView.java<br/>
 ┃ ┃ ┃ ┃ ┗ 📜OutputView.java<br/>
 ┃ ┃ ┃ ┗ 📜Application.java<br/>
 ┗ 📂test<br/>
 ┃ ┗ 📂java<br/>
 ┃ ┃ ┣ 📂racingcar<br/>
 ┃ ┃ ┃ ┗ 📜ApplicationTest.java<br/>
 ┃ ┃ ┗ 📂study<br/>
 ┃ ┃ ┃ ┗ 📜StringTest.java<br/>