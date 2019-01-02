package 网络实验;

/**
 * 此为创建英雄类的实现
 * 包含英雄的基本属性：名称、HP、MP、Exp、level、坐标x、y
 *
 */
public class Hero {
    WinDemo ha;
    RobotHero enemyRo;
    boolean moveflag=false;
    String name;
    int playernumber=1;
    int HP,MP,Exp,x,y;
    int level;
    int maxHP,maxMP,maxExp;
    int attack,attackArea;
    int isdead;

/**
 * 这是为英雄设定地图
 * @param a 地图类的引用
 */
    public void SetWin(WinDemo a)
    {
        ha=a;
    }

/**
 * 英雄类的构造函数
 * @param n 姓名
 */

    Hero(String n){

        name=n;
        HP=600;
        maxHP=600;
        MP=200;
        Exp=0;
        maxExp=200;
        level=0;
        attack=30;
        attackArea=3;
        isdead=1;
        x=0;y=0;

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
 * 设置对手玩家的方法
 * @param e 对方玩家的引用
 */
    public void SetEnemy(RobotHero e)
    {
        enemyRo=e;
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
            maxHP+=60;
            maxMP+=100;
            MP=maxMP;
            attack+=20;
            if(HP+(maxHP/3)>maxHP)
            {
                HP=maxHP;
            }
            else
                HP+=(maxHP/3);
        }
    }


    /**
     *
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
     *
     * 此函数结算英雄受到的伤害
     * 并且判断英雄是否死亡
     * @return 1 则为能攻击；0 则为不能攻击
     */
    public int AttackArea()
    {

        if(attackArea*attackArea>=((enemyRo.x-x)*(enemyRo.x-x)+(enemyRo.y-y)*(enemyRo.y-y)))
            return 1;

        return 0;
    }
   /**
    * 英雄受到伤害的结算方法
    * @return 英雄的剩余HP
    */
    public int SufferAttack()
    {
        HP-=enemyRo.attack;
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
     *
     * 此函数用于技能的释放
     * 根据不同的技能
     * 使用不同的方法进行构造
     * @return 无伤害技能返还0，有伤害技能返还伤害
     */
    public int Skill()
    {



        return 0;
    }

   /*
    @Override
    public synchronized void run() {
        // TODO 自动生成的方法存根
        Scanner sc = new Scanner(System.in);
        String move;
        move=sc.next();

        while(!move.equals("exit"))
        {







        }
	        	/*
	        	if(move.equals("w")||move.equals("a")||move.equals("s")||move.equals("d"))
	        	{
	        		int flag;

	        		flag=ha.Move(move, name, x, y);
	        		ChangeXY(move, flag);

	        	}
	        		move=sc.next();
	        	if(move.equals("f")&&enemyRo.isdead!=0)
				{
					int ok;
					ok = AttackArea();


					if(ok==1)
					{
						enemyRo.SufferAttack();
						if(enemyRo.HP-attack>0)
						{	System.out.printf("%s HP: %d",enemyRo.name,enemyRo.HP);
							System.out.println();
						}
					}


				}
	        }
			*/
}
