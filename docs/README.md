# 자동차 경주 - 구현 기능 목록

---
Car 객체는 ArrayList로 관리한다.


---
## Controller

---
* Car 객체 생성
* 사용자 입력 처리
* 지정 횟수만큼 Car 배열을 순회, Car 객체를 이동시킨다


## Car

---

* 이름, 위치를 가짐
* getName(): 이름 반환
* getCurLocation(): 위치 반환
* moveCar(): 1-9 사이의 랜덤값에 따라 4 이상이라면 위치 +1 

## Message

---
* 메세지 출력

## Validator

---

* 이름이 6글자 이상이면 오류 발생
* 입력이 없다면 오류 발생
* 이름이 공백이면 오류 발생