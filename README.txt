Parking
=======
ParkingManager任务分解1

given 一个停车场经理pm管理parkingboy1和parkingboy2，他们各自管理cp及cp1，经理自己管理cp2 
when  pm让parkingboy1停车，parkingboy1管理的停车场有空车位
then  parkingboy1停车管理的停车场空位总数减1

given 一个停车场经理pm管理parkingboy1和parkingboy2，他们各自管理cp及cp1，经理自己管理cp2 
when  pm让parkingboy1停车，parkingboy1管理的停车场无空车位
then  提示无车位

given 一个停车场经理pm管理parkingboy1和parkingboy2，他们各自管理cp及cp1，经理自己管理cp2
when  pm自己停车，pm管理的停车场有空车位
then  pm管理的停车场空位总数减1

given 一个停车场经理pm管理parkingboy1和parkingboy2，他们各自管理cp及cp1，经理自己管理cp2
when  pm自己停车，管理的停车场无空车位
then  提示无车位

given 一个停车场经理pm管理parkingboy1和parkingboy2，他们各自管理cp及cp1，经理自己管理cp2
when  取已停入的车
then  取到该车

given 一个停车场经理pm管理parkingboy1和parkingboy2，他们各自管理cp及cp1，经理自己管理cp2
when  取未停入的车
then  提示无该车