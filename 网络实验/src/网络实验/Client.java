package 网络实验;


import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.Scanner;
/**
 * 这是客户端的实现
 * @author goden
 *
 */

public class Client {

    public static void main(String[] args) {
        Hero player = new Hero("/Users/goden/Desktop/sx70cheng101.png");
        RobotHero other=new RobotHero("/Users/goden/Desktop/ls101cheng70.png");
        WinDemo own=new WinDemo();
        own.SetPlayer(player,other);
        String hostname;
        if(args.length>0)
            hostname = args[0];
        else
            hostname="localhost";
        try
        {
            Socket theSocket = new Socket(hostname,13);
            System.out.println("客户端已开启");
            Scanner input = new Scanner(System.in);
            //获取输入流，并读取客户端信息
            InputStream in = theSocket.getInputStream();
            OutputStream out = theSocket.getOutputStream();
            //把字节流转换成字符流
            InputStreamReader isr = new InputStreamReader(in);
            //为字符流增加缓冲区
            BufferedReader bfr = new BufferedReader(isr);
            System.out.print("客户端发送");
            String str = input.nextLine();
            out.write(str.getBytes());
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            String str2 = new String(buf,0,len);
            System.out.println("客户端接收："+str2);
            System.out.println("收到请求");
            out.close();
            in.close();
            theSocket.close();
        }
        catch (UnknownHostException e){System.err.println(e);}
        catch (IOException e){System.err.println(e);}
    }
}
