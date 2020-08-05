
use zhbitt

Create table t_Manager --管理员表
(
	PK_Manager int identity(1,1) primary key Not NULL,
	ManagerID varchar(15) unique not null,  -- 15位字符登陆
	Mname varchar(10) NOT NULL,
	Mpassword varchar(15) NOT NULL,
)
Create table t_Food  --餐品信息表
(
	PK_Food int identity(1,1) primary key NOT NULL,
	FoodID varchar(15) unique not null,
	FoodName varchar(30) NOT NULL,
	FoodPrice float NOT NULL,
	FoodRemark varchar(100) NOT NULL, --备注（介绍）信息
	FoodPicture  varchar(100) NOT NULL,
	Classify varchar(10) NOT NULL,
    
);
Create table t_Queue  --排号表
(
	PK_Queue int identity(1,1) primary key Not NULL,
	QueueID varchar(15) unique not null,
	QueueTime datetime not null,
	QueueState varchar(10) not null,
	QueueHao varchar(10) not null,
	QueueNum int not null
)
Create table t_Customer --顾客信息表
(
	PK_Customer int identity(1,1) primary key Not NULL,
	CustomerID varchar(15) unique not null, 	
	Cpassword varchar(15) NOT NULL,
	Cname varchar(10) NOT NULL,
	Cbirthday varchar(10) NOT NULL,
	Cphonenumber varchar(11) not null, --手机号登陆

)

Create table t_Advertisement --广告信息表
(
	PK_Advertisement int identity(1,1) primary key Not NULL,
	AdID varchar(15) unique not null,
	Admessage varchar(1000) NOT NULL,
	AdImg  varchar(100) NOT null,
	AdSourse varchar(20) NOT NULL,
	
)
Create table t_Statistics  --数据统计表
(
	PK_Statistics int identity(1,1) primary key Not NULL,
	StatisticsID varchar(15) unique not null,
	StatisticalObjects varchar(30) NOT NULL,
	StatisticalNumber INT NOT NULL,
	StatisticalTime date not null
)
Create table t_Waiter  --服务员信息表
(
	PK_Waiter int identity(1,1) primary key Not NULL,
	WaiterID varchar(15) unique not null, 
	Wname varchar(10) NOT NULL,
	Wpassword varchar(15) NOT NULL,
	Wphonenumber varchar(11) not null,
	
)

Create table t_Tables --餐桌信息表
(
	PK_Tables int identity(1,1) primary key Not NULL,
	TablesID varchar(15) unique not null,
	SeatNumber int  not null,
	TableState	bit not null, -- sql中的boolean为 0或1
	OrderState bit not null
)

Create table t_Order  --订单信息表
(
	PK_Order int identity(1,1) primary key NOT NULL,
	OrderID  varchar(15) unique not null,
	TotlaPrice float NOT NULL,
	OrderTime datetime not null,
	NowState varchar(10) not null,
	FK_Order_Customer int FOREIGN KEY REFERENCES t_Customer(PK_Customer),
	FK_Order_Tables int FOREIGN KEY REFERENCES t_Tables(PK_Tables)
);

Create table t_Message  --留言信息表
(
	PK_Message int identity(1,1) primary key Not NULL,
	MessageID varchar(15) unique not null,
	LeaveTime datetime not null,
	Words varchar(100),
	FK_Message_CustomerID int FOREIGN KEY REFERENCES t_Customer(PK_Customer)--PKManager
)
Create table t_OrderMessage  --订单详细信息表
(
	PK_Message int identity(1,1) primary key Not NULL,
	OrderMessageID varchar(15) unique not null,
	FoodNumber int  not null,
	FK_OrderMessage_Order int FOREIGN KEY REFERENCES t_Order(PK_Order),
	FK_OrderMessage_Food int FOREIGN KEY REFERENCES t_Food(PK_Food)
)


--插入数据

--插入管理员数据
insert into t_Manager values('admin','小曾','123456');
--插入排号表数据
insert into t_Queue values('0001','2020-5-05 13:58:48','过号','A01','1');
insert into t_Queue values('0002','2020-5-05 13:58:49','过号','B01','3');
insert into t_Queue values('0003','2020-5-05 13:59:00','过号','C01','6');
--插入服务员数据
insert into t_Waiter values('xiaogang','小刚','123456','13812345987');
insert into t_Waiter values('xiaozhi','小智','123456','13646598766');
insert into t_Waiter values('xiaoming','小明','123456','13226598766');
insert into t_Waiter values('xiaodu','小度','123456','13624598766');
--插入顾客
insert into t_Customer values('customer','customer','顾客会员','2020.10.01','12345678911');
insert into t_Customer values('xiaoli','123456','小李','2019.11.16','15846579889');
insert into t_Customer values('xiaowang','123456','小王','2016.09.15','13942587994');

insert into t_Customer values('duolaameng','123456','哆啦A梦','2016.07.07','13427645255');
insert into t_Customer values('fuermosi','123456','福尔摩斯','1854.01.06','13825647865');
insert into t_Customer values('xiaoma','123456','小马','1998.03.07','13625644455');

insert into t_Customer values('gongtengxinyi','123456','江户川柯南','1990.05.04','13825647755');
insert into t_Customer values('xiaojun','123456','小军','2016.07.07','13825647865');
insert into t_Customer values('yebidaxiong','123456','野比大雄','2016.07.07','13825647865');

insert into t_Customer values('zengxiaoxian','123456','曾小贤','2016.07.07','13825647865');
insert into t_Customer values('xiaowei','123456','小魏','2016.07.07','13826649985');
insert into t_Customer values('lixiaokui','123456','李筱奎','2016.07.07','13825647865');
--插入餐桌数据
insert into t_Tables values('A01','2','0','0');
insert into t_Tables values('A02','2','0','0');
insert into t_Tables values('A03','2','0','0');
insert into t_Tables values('B01','4','0','0');
insert into t_Tables values('B02','4','0','0');
insert into t_Tables values('B03','4','0','0');
insert into t_Tables values('C01','6','0','0');
insert into t_Tables values('C02','6','0','0');
insert into t_Tables values('C03','6','0','0');
--插入菜品数据
insert into t_Food values('0001','特色套餐1','165','白菜（1份）,精品肥牛（1份）,羔羊肉（1份）,火锅牛肉（1份）,虾滑（一份）,冬瓜（1份）,双拼锅底。','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=121655349,417846728&fm=26&gp=0.jpg','套餐');
insert into t_Food values('0002','特色套餐2','140','羔羊肉（1份）,土豆（1份）,冬瓜（1份）,虾滑（1份）,牛肉丸（1份）,莲藕（1份）,双拼锅底。','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1242740088,3740081894&fm=26&gp=0.jpg','套餐');

insert into t_Food values('0003','慕斯酸奶兔','6','6元/只，酸酸甜甜，口感不一般！','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2127191094,2431764790&fm=26&gp=0.jpg','新品');
insert into t_Food values('0004','火锅牛肉','29','肉质爽滑不失嚼劲，舌头就能尝出是新鲜牛肉～','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3094379805,2771264796&fm=26&gp=0.jpg','新品');

insert into t_Food values('0005','巴沙鱼片','29','巴沙鱼其肉质细腻、味道鲜美，含丰富维生素、矿物质（主要是钙）等营养元素。','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=294451966,978776973&fm=26&gp=0.jpg','特色菜');
insert into t_Food values('0006','黄喉','31','提供身体构造新组织所需的氨基酸，调节体内的水分、电解质平衡','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2670858390,2158631557&fm=26&gp=0.jpg','特色菜');

insert into t_Food values('0007','骨头双拼锅底','28','新鲜大骨熬制。','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2244128618,415727032&fm=26&gp=0.jpg','锅底');
insert into t_Food values('0008','清油双拼锅底','22','纯植物油炒制，好吃不油腻，地道川味火锅。','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1598700100,3480613207&fm=26&gp=0.jpg','锅底');
insert into t_Food values('0009','酸辣金汤双拼锅底','25','番茄，胡萝卜，玉米，辣椒，酸辣可口。','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3167962640,1601242384&fm=26&gp=0.jpg','锅底');
insert into t_Food values('0010','番茄双拼锅底','26','番茄底料，鲜西红柿，菌汤粉调味料，香菇，高汤，三鲜盐包。','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3513250843,2960166431&fm=26&gp=0.jpg','锅底');
insert into t_Food values('0011','火锅牛肉','29','肉质爽滑不失嚼劲，舌头就能尝出是新鲜牛肉～','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3094379805,2771264796&fm=26&gp=0.jpg','肉类');
insert into t_Food values('0012','精品肥牛','35','色泽鲜红肉质细嫩的肥牛鲜嫩和入味','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3725199566,2447908822&fm=26&gp=0.jpg','肉类');
insert into t_Food values('0013','澳洲草原羔羊肉','28','营养丰富，肉质鲜嫩，口感好,无膻味,富含钙铁等多种矿物质和人体必须的氨基酸，是人们日常生活之佳品。','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1405968894,803912843&fm=26&gp=0.jpg','肉类');
insert into t_Food values('0014','生蚝','36','生蚝是很好的补钙食物，钙、锌、磷的含量都是很丰富的，而这些都是人体所需要的','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1405831851,2645797253&fm=26&gp=0.jpg','肉类');
insert into t_Food values('0015','扒皮鱼','22','营养成分包括微量的脂肪、钙、磷、铁等。鱼肉可做药用，治疗胃病、乳腺炎、消化道出血等。','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=338720928,757622682&fm=26&gp=0.jpg','肉类');
insert into t_Food values('0016','鱿鱼须','29','选用鱿鱼触角，速冻保鲜。锅开后再煮5分钟左右即可食用。','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3764039292,4255863526&fm=26&gp=0.jpg','肉类');

insert into t_Food values('0017','土豆','10','十大热门营养健康食品之一','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3059988281,3944722954&fm=26&gp=0.jpg','素类');
insert into t_Food values('0018','冬瓜','10','味甘、性寒，有消热、利水、消肿的功效','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1900680130,302673153&fm=26&gp=0.jpg','素类');
insert into t_Food values('0019','白菜','10','含丰富的维生素、膳食纤维和抗氧化物质，能促进肠道蠕动，帮助消化','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3766669065,214708942&fm=26&gp=0.jpg','素类');
insert into t_Food values('0020','菠菜','10','富含类胡萝卜素、维生素C、维生素K、矿物质（钙质、铁质等）、辅酶Q10等多种营养素','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1568299589,1057878020&fm=26&gp=0.jpg','素类');
insert into t_Food values('0021','莲藕','15','气味清香味道微甜且脆嫩爽口','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3075903400,1420488889&fm=26&gp=0.jpg','素类');

insert into t_Food values('0022','虾滑','36','主要材料有虾，辅料有肉、鱼类等','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=201051266,121412886&fm=26&gp=0.jpg','丸滑类');
insert into t_Food values('0023','牛肉丸','35','牛肉丸，是潮汕地区特色美食，潮汕特产，又称手捶牛肉丸','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3870064180,3109954796&fm=26&gp=0.jpg','丸滑类');
insert into t_Food values('0024','猪肉丸','30','中医认为，猪肉性平味甘，有润肠胃、生津液、补肾气、解热毒的功效','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2494957598,3170116463&fm=26&gp=0.jpg','丸滑类');
insert into t_Food values('0025','山药','13','经过去泥，挑选，去皮，清洗，切配，装盘而成。锅开后再煮3分钟左右即可食用。','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1473156971,1207832777&fm=26&gp=0.jpg','山珍菌类');
insert into t_Food values('0026','香菇','12','经过挑选，清洗，装盘而成。锅开后再煮5分钟左右即可食用。','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2229403864,755752503&fm=26&gp=0.jpg','山珍菌类');
insert into t_Food values('0027','金针菇','12','半份，100-150g菌盖滑嫩柄脆，煮3分钟。','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3116145482,2439984895&fm=26&gp=0.jpg','山珍菌类');
insert into t_Food values('0028','韩式泡菜五花肉炒饭','30','格外爽口开胃。','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=507659289,1356468767&fm=26&gp=0.jpg','主食');
insert into t_Food values('0029','泰式菠萝炒饭','25','消肿，护眼明目，利水。','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1171456123,421642655&fm=26&gp=0.jpg','主食');
insert into t_Food values('0030','白米饭','5','上等泰国香米','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3690559649,3565020567&fm=26&gp=0.jpg','主食');
insert into t_Food values('0031','慕斯酸奶兔','6','6元/只，酸酸甜甜，口感不一般。','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2127191094,2431764790&fm=26&gp=0.jpg','小吃');
insert into t_Food values('0032','酱黄瓜','9','脆嫩爽口、香甜鲜美。','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1846627441,1307847190&fm=26&gp=0.jpg','小吃');
insert into t_Food values('0033','橙汁','12','新鲜而营养价值高，可经过冷冻的方法饮用或直接饮用','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3334635717,2012774614&fm=26&gp=0.jpg','饮品');
insert into t_Food values('0034','可乐','12','是指有甜味、含咖啡因但不含酒精的碳酸饮料，非常流行','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2370172978,1480734805&fm=26&gp=0.jpg','饮品');
insert into t_Food values('0035','椰汁','12','椰汁蕴含蛋白质、脂肪、维生素C及钙、磷、铁、钾、镁、钠等矿物质，是营养极为丰富的饮料。','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=894670486,2448287113&fm=26&gp=0.jpg','饮品');
insert into t_Food values('0036','酸梅汁','18','消油解腻、开胃健脾','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2686140421,1536892850&fm=26&gp=0.jpg','饮品');


--广告 餐饮文化公司
insert into t_Advertisement values('001','火锅文化小故事1：
古代一些帝王与火锅有一定情结,元世祖忽必烈喜欢吃火锅,一年冬天,部队突然要开拔,而他饥肠辘辘,定要吃羊肉,厨师情急之中将羊肉切成薄片,放入开水锅并加调料,忽必烈食后赞不绝口并赐名为"涮羊肉"。相传乾隆皇帝吃火锅成癖于嘉庆元年正月大摆"千叟宴",是历史上最大的一次火锅盛宴!'
,'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2334551818,2896071832&fm=26&gp=0.jpg','火锅餐饮文化');

insert into t_Advertisement values('002','百搭蘸料：
小米椒+花生碎+辣椒面+葱花+香菜+蒜泥+醋+香油+耗油。相信我！真的强烈推荐给大家，拥有这款蘸料，无论涮什么锅都是美味的！吃什么都能蘸！什么蘸了都好吃！','https://wx1.sinaimg.cn/mw690/007g9YUlgy1g3xen76s1rj30u00u0e83.jpg','火锅餐饮文化');
insert into t_Advertisement values('003','番茄火锅：
味道清香，可以涮食海鲜、动物肉品、各类蔬菜。在涮锅前还可以品尝涮锅的汤料。番茄内富含人体所需的多种维生素，尤其是维C较多，维C有助于对人体的消化及减缓皮肤衰老，因此“特色番茄鱼头锅”比较适合老人、女士、儿童和醉酒的人士食用。','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4062886152,1424923429&fm=26&gp=0.jpg','火锅餐饮文化');

--广告 --好吃有限公司
insert into t_Advertisement values('004','特色套餐1：
这款火锅的主要原料是浓缩番茄酱，番茄含有丰富的维生素、矿物质、碳水化合物、有机酸及少量的蛋白质。它的汤底口感润滑，鲜美滋味。
所以即使是不能吃辣的朋友也可以放心食用,不必担心会刺激到肠胃。。','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=121655349,417846728&fm=26&gp=0.jpg','好吃有限公司');
insert into t_Advertisement values('005','虾滑：
虾滑是一种虾泥制品,主要材料有虾,辅料有肉、鱼类等。
虾滑的做法是把虾去壳,通过上千次的摔打,使肉具有粘性,让其保持原有的营养成分,又具有了爽脆的口感。
虾肉有补肾壮阳,通乳抗毒、养血固精、化瘀解毒、益气滋阳、通络止痛、开胃化痰等功效。','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=201051266,121412886&fm=26&gp=0.jpg','好吃有限公司');
insert into t_Advertisement values('006','澳洲草原羔羊肉：
营养丰富，肉质鲜嫩，口感好,无膻味,富含钙铁等多种矿物质和人体必须的氨基酸，是人们日常生活之佳品。','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1405968894,803912843&fm=26&gp=0.jpg','好吃有限公司');