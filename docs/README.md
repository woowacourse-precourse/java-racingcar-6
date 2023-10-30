<p align="center">
  <img src="./img/우테코.png" alt="우아한테크코스" width=300px">
</p>

# 프리코스 1주차 미션 - 자동차 경주

---
![Generic badge](https://img.shields.io/badge/precourse-week2-green.svg)
![Generic badge](https://img.shields.io/badge/test-0_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.1-brightgreen.svg)

> 우아한테크코스 6기 프리코스 2주차 미션 <자동차 경주>를 구현한 저장소입니다.


# 목차
- [Model](Model)
  - [Car.java](Car.java)
  - [CarList.java](CarList.java)
- [View](view)
- [Controller](Controller)
- [Uitl](Util)
  - [CarNameValidator.java](CarNameValidator.java)

---

# Model
### Car.java
- String name
- int position
- Car()
- move()


### CarList.java
- List<Car> carList
- CarList()
- validate()


# Util
### CarNameValidator.java
- MIN_CARLIST_NUMBER = 2
- MAX_CARNAME_LENGTH = 5
- 자동차가 2대 이상인지 확인
- 자동차의 이름이 5자 이하인지 확인
- 메세지 enum으로 정리
