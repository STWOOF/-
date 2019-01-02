package 网络实验;

/**
*
* 该类为机器人英雄类
* 电脑的控制操作
* 继承接口Runnable
* @author WOOF
*
*/
public class RobotHero implements Runnable{
   WinDemo rha;
   String name;
   Hero enemyPl;
   boolean moveflag=false;
   int playernumber=2;
   int HP,MP,Exp,x,y;
   int level;
   int maxHP,maxMP,maxExp;
   int attack,attackArea;
   int isdead;

   /**
    * 设置对手的方法
    * @param e 对手英雄的引用
    */
   public void SetEnemy(Hero e)
   {
       enemyPl=e;
   }
   /**
    *
    * 机器人英雄类的构造函数
    * @param n 机器人的英雄名字
    */
   RobotHero(String n){

       name=n;
       HP=900;
       maxHP=900;
       MP=200;
       Exp=0;
       maxExp=200;
       level=0;
       attack=50;
       attackArea=1;
       isdead=1;
       x=0;y=500;

   }
   /**
    *
    * 此函数用于初始化英雄的坐标参数
    *
    * @param x1 英雄的横坐标
    * @param y1 英雄的纵坐标
    */
   public void Setxy(int x1,int y1)
   {
       x=x1;
       y=y1;
   }
   /**
    * 这是为英雄设定地图
    * @param a 地图类的引用
    */
   public void SetWin(WinDemo a)
   {
       rha=a;
   }

   /**
    * 此函数用于输出英雄的属性信息
    */
   public void show()
   {
       System.out.printf("Name:%s HP:%d MP:%d Exp:%d AttackArea:%d isAlive:%d",name,HP,MP,Exp,attackArea,isdead);
       System.out.println();
       System.out.printf("Attack:%d",attack);
       System.out.println();
       System.out.printf("坐标x：%d, 坐标y：%d",x,y);
       System.out.println();
   }
   /**
    * 此函数提升英雄的经验值
    * 并且到达升级经验值后
    * 提升英雄的等级
    * 并且增加英雄的属性值
    * 回复部分生命HP和法力值MP
    */
   public void ExpUp()
   {
       Exp+=50;
       System.out.print("Exp增加");
       System.out.print(name);
       System.out.println("当前经验值为："+Exp);

       if(Exp>=maxExp)
       {
           level++;
           System.out.printf("%s level up! Level=%d",name,level);
           System.out.println();
           int more=Exp-maxExp;
           maxExp+=100;
           Exp=0;
           Exp+=more;
           maxHP+=100;
           maxMP+=100;
           MP=maxMP;
           attack+=15;
           if(HP+(maxHP/3)>maxHP)
           {
               HP=maxHP;
           }
           else
               HP+=(maxHP/3);
       }
   }

   /**
    * 生命恢复方法
    * 此函数回复英雄的HP
    *
    */
   public void ReviewHP()
   {
       if(HP+30<maxHP)
       {
           HP+=30;
       }
       else
           HP=maxHP;

   }
   /**
    * 英雄受到伤害的结算方法
    * @return 英雄的剩余HP
    */
   public int SufferAttack()
   {
       HP-=enemyPl.attack;
       if(HP<=0)
       {
           isdead=0;
           System.out.printf("%s is dead!",name);
           System.out.println();
           name="🚫";
       }
       return HP;
   }
   /**
    * 直接修改坐标函数
    *
    * @param p 玩家的操作指令
    * @param flag 玩家的轮次
    */
   public void ChangeXY(String p,int flag)
   {

       if(flag==1)
       {
           if(p.equals("w"))
               x--;

           else if(p.equals("s"))
               x++;

           else if(p.equals("a"))
               y--;

           else if(p.equals("d"))
               y++;

       }

   }
   /**
    * 本函数为攻击范围判断函数
    * 判断攻击范围内是否能够攻击
    * @return 1 则为能攻击；0 则为不能攻击
    */
   public int AttackArea()
   {

       if(attackArea*attackArea>=((enemyPl.x-x)*(enemyPl.x-x)+(enemyPl.y-y)*(enemyPl.y-y)))
           return 1;

       return 0;
   }


   /**
    *
    * 这是对run方法的实现
    * 运用线程的方法
    * 实现机器人英雄类的各种操作
    */

   @SuppressWarnings("resource")
   @Override
   public synchronized void run() {


       /*
       // TODO 自动生成的方法存根
       File file2 = new File("/Users/goden/Desktop/wzry文档输入.txt");
       Scanner sc = null;
       try {
           sc = new Scanner(file2);
       } catch (FileNotFoundException e) {
           // TODO 自动生成的 catch 块
           e.printStackTrace();
       }
       String move;
       int flag=0;

       move=sc.next();
       */


   }







}
