任务分解
=================
###Task1：停车场停车、取车、显示剩余车位。     
1	停车场有剩余空位	停一辆车	        成功停入   
2	停车场无剩余空位	停一辆车	        警告无剩余车位   
3	停车场有车	        凭有效的停车凭证取车	成功取到此车并且剩余车位+1   
4	停车场有车	        凭无效的停车凭证取车	警告无车   
5	停车场无车	        取车			警告无车   
6	停车场有14个剩余空位	需要显示剩余车位	显示剩余14个空车位   
###Task2：停车仔们能够管理2个或多个停车场，其中普通停车仔将车停到第一个有空车位的停车场，聪明的停车仔将车停到空车位最多的那个停车场、超级停车仔将车停在空置率最高的那个停车场。   
前置条件：停车仔都管理3个停车场，停车位分别为20、40、20个。   
1	1号停车场剩余10个空位	普通停车仔停车		成功停入并且1号停车场剩余9个空位   
2	3个停车场都无剩余空位	普通停车仔停车		警告无剩余车位   
3	1号停车场剩余0空位2号停车场剩余30个空位	普通停车仔停车		成功停入并且2号停车场剩余29个空位   
4	车A已停入停车场		凭有效的停车凭证取A车	成功取到A车   
5	停车场有车		凭无效的停车凭证取车	警告无车     
6	停车场无车		取车			警告无车     
7	3个停车场剩余空位分别为10/20,30/40,20/20	聪明的停车仔停车	成功停入并且2号停车场剩余29个空位    
8	3个停车场剩余空位分别为10/20,30/40,20/20	超级停车仔停车		成功停入并且3号停车场剩余19个空位   
###Task3：停车场的经理能够管理多个停车仔，让他们停车，同时也可以自己随机停车。   
前置条件：一个停车场经理pm管理parkingboy1和parkingboy2，他们各自管理cp及cp1，经理自己管理cp2   
1	cp剩余20个空位		pm让parkingboy1停车	成功停入并且parkingboy1管理的停车场剩余19个空位   
2	cp1无剩余空位		pm让parkingboy2停车	警告无空位   
3	3个停车场均为空		pm自己停车		成功停入并且pm管理的停车场剩余89个空位   
4	3个停车场均无空位	pm自己停车		警告无空位   
5	车A已停入停车场		凭有效的停车凭证取A车	成功取到A车   
6	停车场无车		凭无效的停车凭证取车	警告无车   
###Task4：停车场主管能够看到一张包含经理和每个停车仔所管理的停车场的信息的报表。   
前置条件：一个停车场主管pd手下有一个停车场经理pm管理parkingboy1、parkingboy2和parkingboy3，parkingboy1管理cp1和cp4，parkingboy2和parkingboy3他们各自管理cp2及cp3，经理自己管理cp  
1	cp剩余20个空位			pd打印cp信息		成功打印cp信息     
2	Parkingboy1管理的cp1剩余30个空位，cp4剩余15个空位	pd打印parkingboy1信息	成功打印parkingboy1信息   
3	5个停车场均为空			pd打印pm信息 		成功打印pm信息   
