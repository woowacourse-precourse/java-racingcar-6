# 자동차 경주 - 구현 기능 목록




---
## Controller

---
* 사용자 입력 처리 :white_check_mark:
* 모듈을 이용해 레이스 진행 :white_check_mark:


## Car

---

* 이름, 위치를 가짐 :white_check_mark:
* getName(): 이름 반환 :white_check_mark:
* getCurLocation(): 위치 반환 :white_check_mark:
* moveCar(): 1-9 사이의 랜덤값에 따라 4 이상이라면 위치 +1 :white_check_mark:

## Cars

---
* Car 객체를 ArrayList 형태로 가진다 :white_check_mark:
* ArrayList의 Car 객체들을 이동시키는 메소드를 가진다 :white_check_mark:
* 이동 후 결과 문자열을 생성한다. :white_check_mark:
* ArrayList의 Car 객체 중 이동 거리가 가진 큰 객체를 확인하는 메소드를 가진다 :white_check_mark:

## Message

---
* 메세지 출력 :white_check_mark:

## Validator

---
#### nameInput 오류 발생 조건
* 입력이 null일 때 :white_check_mark:
* 이름이 0글자, 혹은 6글자 이상일 때 :white_check_mark:
* 이름이 공백으로만 이뤄졌을 때 :white_check_mark:
* 같은 이름이 중복으로 들어갔을 때 :white_check_mark:

#### tryTimeInput 오류 발생 조건
* 입력이 null일 때 :white_check_mark:
* 입력이 숫자가 아닐 때 :white_check_mark:
* 입력이 양수가 아닐 때 :white_check_mark: