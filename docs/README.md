<h1 align="center"> 🚗 자동차 경주 게임 </h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0-blue.svg?cacheSeconds=2592000" />
  <a href="https://github.com/dongho108/java-racingcar-precourse/tree/dh" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
</p>


## 자동차 경주 게임이란?

- Random Number(0~9)를 생성하고 Random Number가 4이상일 경우 자동차는 한 칸 전진합니다.
- 사용자에게 ,(쉼표)로 구분된 자동차 이름을 입력받고, 시도할 횟수도 입력받은 뒤 게임은 시작됩니다.
- 시도할 횟수가 지나면 최종 우승자 (여러 자동차일 수 있음)를 출력합니다.

## 🚀 기능 목록

- 사용자의 입력을 받아 저장해야한다.
    - 자동차 이름을 받아 파싱해 car객체에 저장해야한다.
    - 시도할 횟수를 저장해야 한다.
    - 잘못된 값을 입력할 경우 ```IllegalArgumentException```을 발생시키고 app 종료해야한다.
- car객체의 포지션을 이동시킬 수 있어야 한다.
- 무작위 값을 구해야한다.
- 무작위 값으로 전진해야할지 말지 판단해야한다.
- 시도 횟수마다 자동차들의 포지션 score를 출력해야한다.
- 시도 횟수가 끝난 후 우승자를 판단해야한다.
    - 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.


⌨️ 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

🖥 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

💻 사용 예시

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

