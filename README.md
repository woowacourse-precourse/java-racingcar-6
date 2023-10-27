<p align="center">
    <img src="https://i.namu.wiki/i/SkMTyiOBeQBy4NXE89AWo53cPQM1lMbEz82RGF8MTdhB9xjLY5WSV7u9NXMVbxfQ5Ie84YQd9l96-tyTbCDZFQ.webp" alt="우아한테크코스" width="250px">
</p>

# 프리코스 2주차 미션 - 자동차 경주

![Generic badge](https://img.shields.io/badge/precourse-week2-green.svg)

[//]: # (![Generic badge]&#40;https://img.shields.io/badge/test-2_passed-blue.svg&#41;)

> 우아한테크코스 6기 프리코스 2주차 미션, 자동차 경주를 구현한 저장소입니다.

#### 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

---

# 목차
- [기능 목록](#기능-목록)
  - [게임 시작 전 세팅](#게임-시작-전-세팅)
  - [게임 시작](#게임-시작)
  - [게임 종료](#게임-종료)

---


## 기능 목록

### 게임 시작 전 세팅

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)을 입력받는다.
  - 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
    - 자동차 이름이 5자보다 긴 경우 (ex. avante, ab cde(공백 포함 6자))
- 시도할 횟수 값을 입력받는다.
  - 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
    - 시도할 횟수 값이 0 또는 음수인 경우 (ex. 0, -1)
    - 시도할 횟수 값이 문자인 경우 (ex. a, b)

### 게임 시작

- 각 자동차의 무작위 값을 구한다.
  - 무작위 값이 4 이상일 경우 (5,6,7,8,9)
    - 자동차는 한 칸 전진한다.
  - 무작위 값이 4보다 작을 경우 (0,1,2,3)
    - 자동차는 그 자리에 멈춘다.
  횟수마다 결과를 자동차 이름과 같이 출력한다.
  - 전진할 경우 `-`를 자동차 결과에 추가

### 게임 종료

- 주어진 횟수가 끝나면 우승자를 출력한다.
  - 단독 우승자 안내 문구
    - ``` 최종 우승자 : pobi ```
  - 공동 우승자 안내 문구
    - ``` 최종 우승자 : pobi, jun ```

