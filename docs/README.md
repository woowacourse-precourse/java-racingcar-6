# 🏎 미션 - 자동차 경주

---

## 🗒 기능 구현 목록

### ✔ 자동차 생성 기능
- 사용자가 입력한 값으로 자동차를 생성한다.
  - [**makeCar**] 메시지 ➡ 사용자 입력 문자열 (List)

### ✔ 자동차 이동 기능
- 랜덤 숫자에 따라 자동차가 멈출지 이동할지 결정한다.
  - [**moveCar**] 메시지 ➡ 랜덤 숫자 (int)

### ✔ 우승자 선정 기능
- 자동차 경주 게임을 완료하고 누가 우승했는지를 알려준다.
  - [**findWinner**]
  - [**findFarthestCar**]
  - [**findSameDistanceCar**]
- 자동차들의 위치를 비교한다.
  - [**compareTo**] 메시지 ➡ 자동차 객체 (Car)
  - [**isSameDistance**] 메시지 ➡ 자동차 객체 (Car)

--- 
## [유효성 검사 기능]
### ✔ 자동차 이름 길이 유효성 검사 기능
- 사용자가 입력한 자동차 이름이 1자 이상, 5자 이하인지 검사한다
  - [**validateCarNameLength**] 메시지 ➡ 자동차 이름 (String)

### ✔ 자동차 이름 Null, Empty 유효성 검사 기능
- 사용자가 입력한 자동차 이름이 null, Empty 인지 검사한다
  - [**validateCarNameEmptyOrNull**] 메시지 ➡ 자동차 이름 (String)

### ✔ 시도 횟수 숫자 여부 유효성 검사 기능
- 사용자가 입력한 시도 횟수가 숫자 인지 검사한다
  - [**validateTryNumberIsNumber**] 메시지 ➡ 시도 횟수 (String)
  
### ✔ 시도 횟수 Null, Empty 유효성 검사 기능
- 사용자가 입력한 시도 횟수가 Null, Empty 인지 검사 기능
  - [**validateTryNumberEmptyOrNull**] 메시지 ➡ 시도 횟수 (String)

--- 

## [입출력 기능]
### ✔ 시도 횟수 입력 기능
- 사용자가 시도 횟수를 입력한다.
  - [insertTryTimes]

### ✔ 자동차 이름 입력 기능
- 쉼표(,)를 기준으로 구분하여 자동차 이름을 입력한다.
  - [insertCarName]

### ✔ 이동 결과 출력 기능
- 시도 횟수마다 이동 결과를 출력한다.
  - [**printResult**] 메시지 ➡ 자동차 이름, 자동차 위치 (Map)

### ✔ 최종 우승자 출력 기능
- 최종 우승자를 출력한다
  - [**printWinner**] 메시지 ➡ 자동차 이름 (List)
--- 
## [추가 기능]
### ✔ 자동차 이름 입력 값 변경 기능
- 자동차 이름 입력 값을 String ➡ List 로 변경한다.
  - [**convertStringToList**] 메시지 ➡ 자동차 이름 (String)

### ✔ 시도 횟수 입력 값 변경 기능
- 시도 횟수 입력 값을 String ➡ int 로 변경한다.
  - [**convertStringToNumber**] 메시지 ➡ 시도 횟수 (String)

### ✔ 우승자 리스트 문자열 변경 기능
- 우승자 목록을 List -> String 으로 변경한다.
  - [convertListToString]

### ✔ 랜덤 숫자 발급 기능
- 0~9 사이 랜덤 숫자를 발급한다.
  - [makeRandomNumber]

---
## 📄클래스 다이어그램
![racingCar](https://github.com/study-hub-inu/study-hub-server/assets/97587573/5ac78ec2-5520-4967-8a3d-7618c3b4d7c3)
