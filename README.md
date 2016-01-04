# PROJECT_DIFFERENTATION_NEXT_JAVA

![introduction](http://i.imgur.com/5vrwKN5.jpg)

### ���α׷� ����
> �� ���α׷���  �Ŀ�����Ʈ ���� ��� [���۷����̼�]�� Ȱ������ ���� �ð��� 
> ������ ����Ͽ�, ���� �ð� ��� ������ �ùķ��̼����ִ� ���α׷��̴�.

### ���α׷� �Ұ�
![service1](http://i.imgur.com/IiVNdwW.jpg)
![service2](http://i.imgur.com/gX8gSpg.jpg)
![service3](http://i.imgur.com/hnuGkV3.jpg)
![service4](http://i.imgur.com/WMD9d70.jpg)
![service5](http://i.imgur.com/QweHvqu.jpg)
![service6](http://i.imgur.com/If4ZBsb.jpg)


### ȯ�漳������
�� ȯ�漳�����Ϸ� �ùķ��̼ǿ� �ٽ��� �Ǵ� ��ҵ��� ������ �� �ִ�.

TotalCustomerNumber.properties: \
���۷����̼��� �� Ÿ�� ���� ������ �� �ִ�.
```sh
//��ó: ���￡ �����ϴ� ���û 20~30�� �α���
TOTAL_INDIVIDUAL_CUSTOMER = 2500000 //���� �� ��

//��û
TOTAL_COMPANY_CUSTOMER = 50000 //��� �� ��
TOTAL_UNIVERSITY_CUSTOMER = 50000 //���� �� ��
``` 

PriceStrategy.properties: \
���۷����̼� ������ ���� ��å�� ������ �� �ִ�.
```sh
//�ӽ� ��
INDIVIDUAL_LECTURE = 90000
COMPANY_LECTURE = 400000
UNIVERSITY_LECTURE = 300000
``` 

InvestTimeStrategy.properties\
�� Ȱ���� ��� ���ڽð��� ������ �� �ִ�.
```sh
//�ӽ� ��
BRANDMARKETING = 7
LECTURE_PROMOTION = 12
LECTURE_OF_INDIVIDUAL = 7
LECTURE_OF_COMPANY = 3
LECTURE_OF_UNIVERSITY = 3
``` 

DistributionStrategy.properties: \
��� �ϴ��� �濡 ���� ����� ��հ� ǥ�������� ������ �� �ִ�.
```sh
AVERAGE_INCREASE_REPUTATION = 100 //�� �������� ���
STDEV_INCREASE_REPUTATION = 25 //�� �������� ǥ������

AVERAGE_SET_BUSYSEASON_NUMBER = 2 //������ �ٻ� ����(�� ��)�� ���� ���
STDEV_SET_BUSYSEASON_NUMBER = 1 //������ �ٻ� ����(�� ��)�� ���� ǥ������

AVERAGE_CHANGE_AMOUNT_OF_BUDGET = 0 //���� ��ȭ���� ���
STDEV_CHANGE_AMOUNT_OF_BUDGET = 100000 //���� ��ȭ���� ǥ������

AVERAGE_CHANGE_AMOUNT_OF_NECESSITY = 0 //���� �ʿ伺 ��ȭ���� ���
STDEV_CHANGE_AMOUNT_OF_NECESSITY = 25 //���� �ʿ伺 ��ȭ���� ǥ������

AVERAGE_CRITERIA_OF_REQUEST_FOR_INDIVIDUAL = 200 //���ǿ�û ������ ���(����)
STDEV_CRITERIA_OF_REQUEST_FOR_INDIVIDUAL = 25 //���ǿ�û ������ ǥ������

AVERAGE_CRITERIA_OF_REQUEST_FOR_ORGANIZATION = 200 //���ǿ�û ������ ���(����)
STDEV_CRITERIA_OF_REQUEST_FOR_ORGANIZATION = 25 //���ǿ�û ������ ǥ������

AVERAGE_SET_AMOUNT_OF_NECESSITY = 100 //�ʱ� �ʿ伺 ���� ���
STDEV_SET_AMOUNT_OF_NECESSITY = 25 //�ʱ� �ʿ伺 ���� ǥ������

AVERAGE_SET_AMOUNT_OF_BUDGET = 200000 //�ʱ� ���� ���� ���
STDEV_SET_AMOUNT_OF_BUDGET = 10000 //�ʱ� ���� ���� ǥ������

//�� �� ��� ���� �� ����(���� ����ؼ� ��ȭ�� ����) ��հ� ǥ������
AVERAGE_INCREMENT_OF_INDIVIDUAL_CUSTOMER = 0.00000001 
STDEV_INCREMENT_OF_INDIVIDUAL_CUSTOMER = 0.0000000025 
AVERAGE_INCREMENT_OF_ORGANIZATION_CUSTOMER = 0.00000001 
STDEV_INCREMENT_OF_ORGANIZATION_CUSTOMER = 0.0000000025


PROBABILITY_CHAGE_DEALT_WITH_PROMOTION = 1.2 //���θ���� ȿ�� Ȯ��

PROBABILITY_OF_STUDENT = 0.9 //�ű� ���ΰ��� �л��� Ȯ��
``` 

DayConfig.properties\
������ ��¥�� ������ �� �ְ�, �� �� ������ Ȱ���� �� ������ �� �ִ�.
```sh
//�ӽ� ��
CURRENT_DAY_DATA=20160103

DAY_STRATEGY=ONEWEEK //ONEWEEK, THREEWEEK ,MONTH ���� ����
``` 





