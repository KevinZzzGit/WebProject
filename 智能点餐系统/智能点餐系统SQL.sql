
use zhbitt

Create table t_Manager --����Ա��
(
	PK_Manager int identity(1,1) primary key Not NULL,
	ManagerID varchar(15) unique not null,  -- 15λ�ַ���½
	Mname varchar(10) NOT NULL,
	Mpassword varchar(15) NOT NULL,
)
Create table t_Food  --��Ʒ��Ϣ��
(
	PK_Food int identity(1,1) primary key NOT NULL,
	FoodID varchar(15) unique not null,
	FoodName varchar(30) NOT NULL,
	FoodPrice float NOT NULL,
	FoodRemark varchar(100) NOT NULL, --��ע�����ܣ���Ϣ
	FoodPicture  varchar(100) NOT NULL,
	Classify varchar(10) NOT NULL,
    
);
Create table t_Queue  --�źű�
(
	PK_Queue int identity(1,1) primary key Not NULL,
	QueueID varchar(15) unique not null,
	QueueTime datetime not null,
	QueueState varchar(10) not null,
	QueueHao varchar(10) not null,
	QueueNum int not null
)
Create table t_Customer --�˿���Ϣ��
(
	PK_Customer int identity(1,1) primary key Not NULL,
	CustomerID varchar(15) unique not null, 	
	Cpassword varchar(15) NOT NULL,
	Cname varchar(10) NOT NULL,
	Cbirthday varchar(10) NOT NULL,
	Cphonenumber varchar(11) not null, --�ֻ��ŵ�½

)

Create table t_Advertisement --�����Ϣ��
(
	PK_Advertisement int identity(1,1) primary key Not NULL,
	AdID varchar(15) unique not null,
	Admessage varchar(1000) NOT NULL,
	AdImg  varchar(100) NOT null,
	AdSourse varchar(20) NOT NULL,
	
)
Create table t_Statistics  --����ͳ�Ʊ�
(
	PK_Statistics int identity(1,1) primary key Not NULL,
	StatisticsID varchar(15) unique not null,
	StatisticalObjects varchar(30) NOT NULL,
	StatisticalNumber INT NOT NULL,
	StatisticalTime date not null
)
Create table t_Waiter  --����Ա��Ϣ��
(
	PK_Waiter int identity(1,1) primary key Not NULL,
	WaiterID varchar(15) unique not null, 
	Wname varchar(10) NOT NULL,
	Wpassword varchar(15) NOT NULL,
	Wphonenumber varchar(11) not null,
	
)

Create table t_Tables --������Ϣ��
(
	PK_Tables int identity(1,1) primary key Not NULL,
	TablesID varchar(15) unique not null,
	SeatNumber int  not null,
	TableState	bit not null, -- sql�е�booleanΪ 0��1
	OrderState bit not null
)

Create table t_Order  --������Ϣ��
(
	PK_Order int identity(1,1) primary key NOT NULL,
	OrderID  varchar(15) unique not null,
	TotlaPrice float NOT NULL,
	OrderTime datetime not null,
	NowState varchar(10) not null,
	FK_Order_Customer int FOREIGN KEY REFERENCES t_Customer(PK_Customer),
	FK_Order_Tables int FOREIGN KEY REFERENCES t_Tables(PK_Tables)
);

Create table t_Message  --������Ϣ��
(
	PK_Message int identity(1,1) primary key Not NULL,
	MessageID varchar(15) unique not null,
	LeaveTime datetime not null,
	Words varchar(100),
	FK_Message_CustomerID int FOREIGN KEY REFERENCES t_Customer(PK_Customer)--PKManager
)
Create table t_OrderMessage  --������ϸ��Ϣ��
(
	PK_Message int identity(1,1) primary key Not NULL,
	OrderMessageID varchar(15) unique not null,
	FoodNumber int  not null,
	FK_OrderMessage_Order int FOREIGN KEY REFERENCES t_Order(PK_Order),
	FK_OrderMessage_Food int FOREIGN KEY REFERENCES t_Food(PK_Food)
)


--��������

--�������Ա����
insert into t_Manager values('admin','С��','123456');
--�����źű�����
insert into t_Queue values('0001','2020-5-05 13:58:48','����','A01','1');
insert into t_Queue values('0002','2020-5-05 13:58:49','����','B01','3');
insert into t_Queue values('0003','2020-5-05 13:59:00','����','C01','6');
--�������Ա����
insert into t_Waiter values('xiaogang','С��','123456','13812345987');
insert into t_Waiter values('xiaozhi','С��','123456','13646598766');
insert into t_Waiter values('xiaoming','С��','123456','13226598766');
insert into t_Waiter values('xiaodu','С��','123456','13624598766');
--����˿�
insert into t_Customer values('customer','customer','�˿ͻ�Ա','2020.10.01','12345678911');
insert into t_Customer values('xiaoli','123456','С��','2019.11.16','15846579889');
insert into t_Customer values('xiaowang','123456','С��','2016.09.15','13942587994');

insert into t_Customer values('duolaameng','123456','����A��','2016.07.07','13427645255');
insert into t_Customer values('fuermosi','123456','����Ħ˹','1854.01.06','13825647865');
insert into t_Customer values('xiaoma','123456','С��','1998.03.07','13625644455');

insert into t_Customer values('gongtengxinyi','123456','����������','1990.05.04','13825647755');
insert into t_Customer values('xiaojun','123456','С��','2016.07.07','13825647865');
insert into t_Customer values('yebidaxiong','123456','Ұ�ȴ���','2016.07.07','13825647865');

insert into t_Customer values('zengxiaoxian','123456','��С��','2016.07.07','13825647865');
insert into t_Customer values('xiaowei','123456','Сκ','2016.07.07','13826649985');
insert into t_Customer values('lixiaokui','123456','�����','2016.07.07','13825647865');
--�����������
insert into t_Tables values('A01','2','0','0');
insert into t_Tables values('A02','2','0','0');
insert into t_Tables values('A03','2','0','0');
insert into t_Tables values('B01','4','0','0');
insert into t_Tables values('B02','4','0','0');
insert into t_Tables values('B03','4','0','0');
insert into t_Tables values('C01','6','0','0');
insert into t_Tables values('C02','6','0','0');
insert into t_Tables values('C03','6','0','0');
--�����Ʒ����
insert into t_Food values('0001','��ɫ�ײ�1','165','�ײˣ�1�ݣ�,��Ʒ��ţ��1�ݣ�,�����⣨1�ݣ�,���ţ�⣨1�ݣ�,Ϻ����һ�ݣ�,���ϣ�1�ݣ�,˫ƴ���ס�','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=121655349,417846728&fm=26&gp=0.jpg','�ײ�');
insert into t_Food values('0002','��ɫ�ײ�2','140','�����⣨1�ݣ�,������1�ݣ�,���ϣ�1�ݣ�,Ϻ����1�ݣ�,ţ���裨1�ݣ�,��ź��1�ݣ�,˫ƴ���ס�','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1242740088,3740081894&fm=26&gp=0.jpg','�ײ�');

insert into t_Food values('0003','Ľ˹������','6','6Ԫ/ֻ���������𣬿ڸв�һ�㣡','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2127191094,2431764790&fm=26&gp=0.jpg','��Ʒ');
insert into t_Food values('0004','���ţ��','29','����ˬ����ʧ��������ͷ���ܳ���������ţ�⡫','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3094379805,2771264796&fm=26&gp=0.jpg','��Ʒ');

insert into t_Food values('0005','��ɳ��Ƭ','29','��ɳ��������ϸ�塢ζ�����������ḻά���ء������ʣ���Ҫ�Ǹƣ���Ӫ��Ԫ�ء�','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=294451966,978776973&fm=26&gp=0.jpg','��ɫ��');
insert into t_Food values('0006','�ƺ�','31','�ṩ���幹������֯����İ����ᣬ�������ڵ�ˮ�֡������ƽ��','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2670858390,2158631557&fm=26&gp=0.jpg','��ɫ��');

insert into t_Food values('0007','��ͷ˫ƴ����','28','���ʴ�ǰ��ơ�','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2244128618,415727032&fm=26&gp=0.jpg','����');
insert into t_Food values('0008','����˫ƴ����','22','��ֲ���ͳ��ƣ��óԲ����壬�ص���ζ�����','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1598700100,3480613207&fm=26&gp=0.jpg','����');
insert into t_Food values('0009','��������˫ƴ����','25','���ѣ����ܲ������ף������������ɿڡ�','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3167962640,1601242384&fm=26&gp=0.jpg','����');
insert into t_Food values('0010','����˫ƴ����','26','���ѵ��ϣ����������������۵�ζ�ϣ��㹽�������������ΰ���','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3513250843,2960166431&fm=26&gp=0.jpg','����');
insert into t_Food values('0011','���ţ��','29','����ˬ����ʧ��������ͷ���ܳ���������ţ�⡫','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3094379805,2771264796&fm=26&gp=0.jpg','����');
insert into t_Food values('0012','��Ʒ��ţ','35','ɫ���ʺ�����ϸ�۵ķ�ţ���ۺ���ζ','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3725199566,2447908822&fm=26&gp=0.jpg','����');
insert into t_Food values('0013','���޲�ԭ������','28','Ӫ���ḻ���������ۣ��ڸк�,����ζ,���������ȶ��ֿ����ʺ��������İ����ᣬ�������ճ�����֮��Ʒ��','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1405968894,803912843&fm=26&gp=0.jpg','����');
insert into t_Food values('0014','���','36','����ǺܺõĲ���ʳ��ơ�п���׵ĺ������Ǻܷḻ�ģ�����Щ������������Ҫ��','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1405831851,2645797253&fm=26&gp=0.jpg','����');
insert into t_Food values('0015','��Ƥ��','22','Ӫ���ɷְ���΢����֬�����ơ��ס����ȡ��������ҩ�ã�����θ���������ס���������Ѫ�ȡ�','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=338720928,757622682&fm=26&gp=0.jpg','����');
insert into t_Food values('0016','������','29','ѡ�����㴥�ǣ��ٶ����ʡ�����������5�������Ҽ���ʳ�á�','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3764039292,4255863526&fm=26&gp=0.jpg','����');

insert into t_Food values('0017','����','10','ʮ������Ӫ������ʳƷ֮һ','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3059988281,3944722954&fm=26&gp=0.jpg','����');
insert into t_Food values('0018','����','10','ζ�ʡ��Ժ��������ȡ���ˮ�����׵Ĺ�Ч','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1900680130,302673153&fm=26&gp=0.jpg','����');
insert into t_Food values('0019','�ײ�','10','���ḻ��ά���ء���ʳ��ά�Ϳ��������ʣ��ܴٽ������䶯����������','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3766669065,214708942&fm=26&gp=0.jpg','����');
insert into t_Food values('0020','����','10','��������ܲ��ء�ά����C��ά����K�������ʣ����ʡ����ʵȣ�����øQ10�ȶ���Ӫ����','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1568299589,1057878020&fm=26&gp=0.jpg','����');
insert into t_Food values('0021','��ź','15','��ζ����ζ��΢���Ҵ���ˬ��','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3075903400,1420488889&fm=26&gp=0.jpg','����');

insert into t_Food values('0022','Ϻ��','36','��Ҫ������Ϻ���������⡢�����','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=201051266,121412886&fm=26&gp=0.jpg','�軬��');
insert into t_Food values('0023','ţ����','35','ţ���裬�ǳ��ǵ�����ɫ��ʳ�������ز����ֳ��ִ�ţ����','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3870064180,3109954796&fm=26&gp=0.jpg','�軬��');
insert into t_Food values('0024','������','30','��ҽ��Ϊ��������ƽζ�ʣ�����θ������Һ�������������ȶ��Ĺ�Ч','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2494957598,3170116463&fm=26&gp=0.jpg','�軬��');
insert into t_Food values('0025','ɽҩ','13','����ȥ�࣬��ѡ��ȥƤ����ϴ�����䣬װ�̶��ɡ�����������3�������Ҽ���ʳ�á�','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1473156971,1207832777&fm=26&gp=0.jpg','ɽ�����');
insert into t_Food values('0026','�㹽','12','������ѡ����ϴ��װ�̶��ɡ�����������5�������Ҽ���ʳ�á�','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2229403864,755752503&fm=26&gp=0.jpg','ɽ�����');
insert into t_Food values('0027','���빽','12','��ݣ�100-150g���ǻ��۱��࣬��3���ӡ�','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3116145482,2439984895&fm=26&gp=0.jpg','ɽ�����');
insert into t_Food values('0028','��ʽ�ݲ��廨�⳴��','30','����ˬ�ڿ�θ��','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=507659289,1356468767&fm=26&gp=0.jpg','��ʳ');
insert into t_Food values('0029','̩ʽ���ܳ���','25','���ף�������Ŀ����ˮ��','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1171456123,421642655&fm=26&gp=0.jpg','��ʳ');
insert into t_Food values('0030','���׷�','5','�ϵ�̩������','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3690559649,3565020567&fm=26&gp=0.jpg','��ʳ');
insert into t_Food values('0031','Ľ˹������','6','6Ԫ/ֻ���������𣬿ڸв�һ�㡣','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2127191094,2431764790&fm=26&gp=0.jpg','С��');
insert into t_Food values('0032','���ƹ�','9','����ˬ�ڡ�����������','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1846627441,1307847190&fm=26&gp=0.jpg','С��');
insert into t_Food values('0033','��֭','12','���ʶ�Ӫ����ֵ�ߣ��ɾ����䶳�ķ������û�ֱ������','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3334635717,2012774614&fm=26&gp=0.jpg','��Ʒ');
insert into t_Food values('0034','����','12','��ָ����ζ���������򵫲����ƾ���̼�����ϣ��ǳ�����','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2370172978,1480734805&fm=26&gp=0.jpg','��Ʒ');
insert into t_Food values('0035','Ҭ֭','12','Ҭ֭�̺������ʡ�֬����ά����C���ơ��ס������ء�þ���Ƶȿ����ʣ���Ӫ����Ϊ�ḻ�����ϡ�','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=894670486,2448287113&fm=26&gp=0.jpg','��Ʒ');
insert into t_Food values('0036','��÷֭','18','���ͽ��塢��θ��Ƣ','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2686140421,1536892850&fm=26&gp=0.jpg','��Ʒ');


--��� �����Ļ���˾
insert into t_Advertisement values('001','����Ļ�С����1��
�Ŵ�һЩ����������һ�����,Ԫ���������ϲ���Ի��,һ�궬��,����ͻȻҪ����,����������,��Ҫ������,��ʦ�鼱֮�н������гɱ�Ƭ,���뿪ˮ�����ӵ���,������ʳ���޲����ڲ�����Ϊ"������"���ഫǬ¡�ʵ۳Ի������ڼ���Ԫ�����´��"ǧ����",����ʷ������һ�λ��ʢ��!'
,'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2334551818,2896071832&fm=26&gp=0.jpg','��������Ļ�');

insert into t_Advertisement values('002','�ٴ�պ�ϣ�
С�׽�+������+������+�л�+���+����+��+����+���͡������ң����ǿ���Ƽ�����ң�ӵ�����պ�ϣ�������ʲô��������ζ�ģ���ʲô����պ��ʲôպ�˶��óԣ�','https://wx1.sinaimg.cn/mw690/007g9YUlgy1g3xen76s1rj30u00u0e83.jpg','��������Ļ�');
insert into t_Advertisement values('003','���ѻ����
ζ�����㣬������ʳ���ʡ�������Ʒ�������߲ˡ����̹�ǰ������Ʒ���̹������ϡ������ڸ�����������Ķ���ά���أ�������άC�϶࣬άC�����ڶ����������������Ƥ��˥�ϣ���ˡ���ɫ������ͷ�����Ƚ��ʺ����ˡ�Ůʿ����ͯ����Ƶ���ʿʳ�á�','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4062886152,1424923429&fm=26&gp=0.jpg','��������Ļ�');

--��� --�ó����޹�˾
insert into t_Advertisement values('004','��ɫ�ײ�1��
���������Ҫԭ����Ũ�����ѽ������Ѻ��зḻ��ά���ء������ʡ�̼ˮ������л��ἰ�����ĵ����ʡ��������׿ڸ��󻬣�������ζ��
���Լ�ʹ�ǲ��ܳ���������Ҳ���Է���ʳ��,���ص��Ļ�̼�����θ����','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=121655349,417846728&fm=26&gp=0.jpg','�ó����޹�˾');
insert into t_Advertisement values('005','Ϻ����
Ϻ����һ��Ϻ����Ʒ,��Ҫ������Ϻ,�������⡢����ȡ�
Ϻ���������ǰ�Ϻȥ��,ͨ����ǧ�ε�ˤ��,ʹ�����ճ��,���䱣��ԭ�е�Ӫ���ɷ�,�־�����ˬ��ĿڸС�
Ϻ���в���׳��,ͨ�鿹������Ѫ�̾��������ⶾ������������ͨ��ֹʹ����θ��̵�ȹ�Ч��','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=201051266,121412886&fm=26&gp=0.jpg','�ó����޹�˾');
insert into t_Advertisement values('006','���޲�ԭ�����⣺
Ӫ���ḻ���������ۣ��ڸк�,����ζ,���������ȶ��ֿ����ʺ��������İ����ᣬ�������ճ�����֮��Ʒ��','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1405968894,803912843&fm=26&gp=0.jpg','�ó����޹�˾');