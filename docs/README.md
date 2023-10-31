# 🎆 2주차 자동차 경주 README

***

## 🔈 목차
- [패키지 구조](#패키지-구조)
- [기능 설계](#기능-설계)
- [구현 시 유의한 점](#구현-시-유의한-점)

***

## 🔎 패키지 구조
> service
> >gameService
> 
> > judgement
> 
> domain
> > carDTO
> 
> utility
> >exceptionHandler
> 
> >providerRandomValue
> 
> view
> >input
> 
> >output
> 
> constant
> >announce
> 
> >error
> 
> >judgmentCriteria
***

## 📄기능 설계
>모든 입력 값은 입력에 대한 예외 처리를 발생 (exceptionHandler)
> >입력에 대한 예외 처리 (exceptionHandler)
> 
> >오류가 났다면 constant - error의 데이터를 들고 와 예외 처리

📌 자동차 이름 입력 (input)
- 값에 대한 예외 처리
- carVO에 데이터 저장

📌 사용자로부터 경기 횟수 입력 (input)

📌랜덤 값 얻기 (providerRandomValue)
- 랜덤 값에 대한 결과 판별 (judgement)

📌실행 결과 출력 (output)

📌우승자 출력 (output)
*** 

## 📎구현 시 유의한 점
* [x] 객체지향적 프로그래밍
```
A -> B -> C (X)
A -> B, A -> C, A -> D (O)
```

* [x] 사용자 친화적 프로그래밍
```
1. 프로그램을 처음 써 보는 사람도 금방 적응해 사용할 수 있도록 UI 설계
2. 사용자에게 자유가 주어졌을 때, 그 자유에 대한 예외 처리 잡기
```

* [x] 객체들의 크기를 작게
```
메서드의 역할은 반드시 하나
```

* [x] 직관적 네이밍
```
주석 없이도 이해할 수 있는 코드를 짜기
```

* [x] 유의미한 공백
```
공백 또한 코딩 컨벤션
```