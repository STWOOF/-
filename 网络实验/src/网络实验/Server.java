package 网络实验;

import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 * 这是服务器的实现
 * @author STWOOF
 *
 */

public class Server {
    public static void main(String[] args) {
        WinDemo a=new WinDemo();

        Socket socket = null;
        Scanner input = new Scanner(System.in);
        try {
            ServerSocket server=new ServerSocket(13);
            System.out.println("服务器已连接");
            for(;;)
            {
                Socket nextClient=server.accept();
                //获取输入流，并读取客户端信息
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
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
                socket.close();
            }
        }
        catch (BindException be) {
            System.err.println();
        }
        catch (IOException e) {}
    }
}

