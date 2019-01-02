package 网络实验;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.String;
/**
 * 
 * @author STWOOF
 * WinDemo类，属于战场控制模块
 * 
 */

public class WinDemo extends JFrame {

    Container panel;

    JLabel py;
    JLabel rob;

    Hero player;    //玩家的引用

    RobotHero robot;    //机器的引用


/**
 * 在地图上放置英雄的方法
 * @param p 玩家
 * @param r 对手
 */

    public void SetPlayer(Hero p,RobotHero r)
    {
        player=p;
        robot=r;
    }
/**
 * 战场控制模块的构造函数
 * 
 */
    
    public WinDemo() {

        JButton jb1,jb2;




        JPanel jbone,jbtwo;

        JPanel tfone,taone;

        jbone = new JPanel();
        jbtwo = new JPanel();
        taone = new JPanel();
        tfone = new JPanel();




        jb1=new JButton("pick me");


        jb2=new JButton("pick me");

        jbone.add(jb1);
        jbtwo.add(jb2);

        TextField tf = new TextField();
        JTextArea ta = new JTextArea();

        String str="显示文本框文字";
        tf.setText(str);


        tfone.add(tf);


        ta.setPreferredSize(new Dimension(200,150));

        ta.setText("欢迎来到王者荣耀");
        ta.setOpaque(true);

        taone.add(ta);



        panel = this.getContentPane();







        this.setTitle("英雄选择阶段");
        this.setSize(1500, 800);
        this.setLayout(null);     //默认的布局模式








        panel.add(tfone, "West");
        panel.add(taone, "East");


        panel.add(jbone);
        panel.add(jbtwo);

        this.add(jbone,BorderLayout.CENTER);
        this.add(jbtwo,BorderLayout.NORTH);


        //创建图片ImageIcon对象
        ImageIcon background = new ImageIcon("/Users/goden/Desktop/背景图.jpeg");

        JLabel label_b = new JLabel(background);

        label_b.setBounds(0, 0, this.getWidth(), this.getHeight());

        JPanel imagePanel = (JPanel) this.getContentPane();

        imagePanel.setOpaque(false);

        this.getLayeredPane().add(label_b, new Integer(Integer.MIN_VALUE));

        //创建图片ImageIcon对象
        ImageIcon choose_1 = new ImageIcon("/Users/goden/Desktop/70cheng101.png");

        JLabel label_1 = new JLabel(choose_1);

        label_1.setBounds(550, 250, 70, 101);

        label_1.setOpaque(true);
        panel.add(label_1);


        //创建图片ImageIcon对象
        ImageIcon choose_2 = new ImageIcon("/Users/goden/Desktop/蔡明老师101cheng70.png");

        JLabel label_2 = new JLabel(choose_2);

        label_2.setBounds(900, 250, 70, 101);

        label_2.setOpaque(true);
        panel.add(label_2);

        /**************************
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tf.setText("");
                tf.requestFocus();

            }


        });
**********************************/


        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
/**
 * 这是移动操作的计算方法
 * @param player 当前玩家的编号学习
 * @param k 服务器返回的移动信息
 * @return	玩家移动的结果
 */
    
    
    public static int[][] moveInformation(int player,int k[])
    {
        int moveResult[][]=new int[10][k.length];
        for(int i=0;i<10;i++)
            for(int j=0;j<k.length;j++)
                moveResult[i][j]=0;

        for(int i=0;i<k.length;i++)
            moveResult[player][i]=k[i];

        return moveResult;
    }
/**
 * 
 * 这是生命值变化的计算方法
 * @param target 服务器的操作信息
 * @return 生命值这算的结果
 */

    public int[][] healthInformation(String target)
    {
        int newHealth;
        char []a;
        a=target.toCharArray();
        if(a[0]==1)
        {
            newHealth=(-1)*player.SufferAttack();
        }
        else
        {
            newHealth=(-1)*robot.SufferAttack();
        }
        int healthResult[][]=new int[10][1];

        for(int i=0;i<10;i++)
            healthResult[i][1]=0;
        healthResult[a[0]][1]=newHealth;
        return healthResult;
    }
/**
 * 这是读取服务器数据并且在客户端做出相应操作的方法
 * @param str 服务器返回的数据
 */

    public void getInformation(String str)
    {
        int len=str.length();
        char []a;
        a=str.toCharArray();
        for (int i=0;i<len;i++)
        {
            if(a[0]=='1')
            {
                i++;
                if(a[i]=='a') {
                    robot.SufferAttack();
                    i++;
                }
                else
                {
                    int xnum=a[i]-'0';
                    int ynum=a[i+1]-'0';
                    player.Setxy(xnum,ynum);
                    i++;
                }
            }
            else{
                i++;
                if(a[i]=='a') {
                    player.SufferAttack();
                    i++;
                }
                else
                {
                    int xnum=a[i]-'0';
                    int ynum=a[i+1]-'0';
                    robot.Setxy(xnum,ynum);
                    i++;
                }
            }
        }
    }
}

