# PROJECT_DIFFERENTATION_NEXT_JAVA
### 프로그램 목적
> 본 프로그램은  파워포인트 교육 기업 [디퍼런테이션]의 활동들의 투자 시간과 
> 수익을 계산하여, 투자 시간 대비 수익을 시뮬레이션해주는 프로그램이다.

### 프로그램 소개
![introduction](http://i.imgur.com/zvWEfDR.jpg)
![service1](http://i.imgur.com/3W3eP0Q.jpg)
![service2](http://i.imgur.com/OBh47ak.jpg)
![service3](http://i.imgur.com/xlK3sWJ.jpg)
![service4](http://i.imgur.com/8WNMibz.jpg)
![service5](http://i.imgur.com/j6H7PcD.jpg)

### 환경설정파일
각 환경설정파일로 시뮬레이션에 핵심이 되는 요소들을 결정할 수 있다.

TotalCustomerNumber.properties: \
디퍼런테이션의 총 타겟 고객을 설정할 수 있다.
```sh
//출처: 서울에 거주하는 통계청 20~30대 인구수
TOTAL_INDIVIDUAL_CUSTOMER = 2500000 //개인 총 고객

//추청
TOTAL_COMPANY_CUSTOMER = 50000 //기업 총 고객
TOTAL_UNIVERSITY_CUSTOMER = 50000 //대학 총 고객
``` 

PriceStrategy.properties: \
디퍼런테이션 교육의 가격 정책을 결정할 수 있다.
```sh
//임시 값
INDIVIDUAL_LECTURE = 90000
COMPANY_LECTURE = 400000
UNIVERSITY_LECTURE = 300000
``` 

InvestTimeStrategy.properties\
각 활동의 평균 투자시간을 결정할 수 있다.
```sh
//임시 값
BRANDMARKETING = 7
LECTURE_PROMOTION = 12
LECTURE_OF_INDIVIDUAL = 7
LECTURE_OF_COMPANY = 3
LECTURE_OF_UNIVERSITY = 3
``` 

DistributionStrategy.properties: \
모든 하늘의 뜻에 들어가는 요소의 평균과 표준편차를 설정할 수 있다.
```sh
AVERAGE_INCREASE_REPUTATION = 100 //명성 증가량의 평균
STDEV_INCREASE_REPUTATION = 25 //명성 증가량의 표준편차

AVERAGE_SET_BUSYSEASON_NUMBER = 2 //고객들의 바쁜 시즌(몇 달)에 대한 평균
STDEV_SET_BUSYSEASON_NUMBER = 1 //고객들의 바쁜 시즌(몇 달)에 대한 표준편차

AVERAGE_CHANGE_AMOUNT_OF_BUDGET = 0 //예산 변화량의 평균
STDEV_CHANGE_AMOUNT_OF_BUDGET = 100000 //예산 변화량의 표준편차

AVERAGE_CHANGE_AMOUNT_OF_NECESSITY = 0 //강의 필요성 변화량의 평균
STDEV_CHANGE_AMOUNT_OF_NECESSITY = 25 //강의 필요성 변화량의 표준편차

AVERAGE_CRITERIA_OF_REQUEST_FOR_INDIVIDUAL = 200 //강의요청 기준의 평균(개인)
STDEV_CRITERIA_OF_REQUEST_FOR_INDIVIDUAL = 25 //강의요청 기준의 표준편차

AVERAGE_CRITERIA_OF_REQUEST_FOR_ORGANIZATION = 200 //강의요청 기준의 평균(조직)
STDEV_CRITERIA_OF_REQUEST_FOR_ORGANIZATION = 25 //강의요청 기준의 표준편차

AVERAGE_SET_AMOUNT_OF_NECESSITY = 100 //초기 필요성 설정 평균
STDEV_SET_AMOUNT_OF_NECESSITY = 25 //초기 필요성 설정 표준편차

AVERAGE_SET_AMOUNT_OF_BUDGET = 200000 //초기 예산 설정 평균
STDEV_SET_AMOUNT_OF_BUDGET = 10000 //초기 예산 설정 표준편차

//총 고객 대비 증가 고객 수준(명성을 고려해서 변화될 예정) 평균과 표준편차
AVERAGE_INCREMENT_OF_INDIVIDUAL_CUSTOMER = 0.00000001 
STDEV_INCREMENT_OF_INDIVIDUAL_CUSTOMER = 0.0000000025 
AVERAGE_INCREMENT_OF_ORGANIZATION_CUSTOMER = 0.00000001 
STDEV_INCREMENT_OF_ORGANIZATION_CUSTOMER = 0.0000000025


PROBABILITY_CHAGE_DEALT_WITH_PROMOTION = 1.2 //프로모션의 효과 확률

PROBABILITY_OF_STUDENT = 0.9 //신규 개인고객이 학생일 확률
``` 

DayConfig.properties\
오늘의 날짜를 결정할 수 있고, 몇 일 단위로 활동할 지 결정할 수 있다.
```sh
//임시 값
CURRENT_DAY_DATA=20160103

DAY_STRATEGY=ONEWEEK //ONEWEEK, THREEWEEK ,MONTH 선택 가능
``` 





