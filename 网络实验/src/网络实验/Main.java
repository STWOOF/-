package 网络实验;
public class Main {

    public static void main(String[] args) {

        Hero pl = new Hero("/Users/goden/Desktop/70cheng101.png");
        RobotHero ro = new RobotHero("/Users/goden/Desktop/蔡明老师101cheng70.png");
        Thread rb=new Thread(ro);
        rb.start();
    }





}
