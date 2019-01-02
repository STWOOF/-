package 网络实验;


import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.logging.Handler;
/**
 * 这是多线程服务器的实现
 * @author STWOOF
 *
 */

public class EchoServer {
    WinDemo playground;
    private  int port=13;
    private ServerSocket serverSocket;
    public EchoServer()throws IOException{
        serverSocket=new ServerSocket(port);
        System.out.println("服务器启动");
    }

    public void service()
    {
        while(true) {
            Socket socket = null;

            try {
                socket = serverSocket.accept();
                playground = new WinDemo();
                //获取输入流，并读取客户端信息
                InputStream inp = socket.getInputStream();
                //把字节流转换成字符流
                InputStreamReader isr = new InputStreamReader(inp);
                //为字符流增加缓冲区
                BufferedReader bfr = new BufferedReader(isr);
                String info = null;
                while((info=bfr.readLine())!=null){//循环读取数据
                    System.out.println("客户端数据"+info);
                    }
                Thread workThread = new Thread(new handler(socket));
                workThread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
       new EchoServer().service();
    }
}


class handler implements Runnable{
    private Socket socket;
    public handler(Socket socket){this.socket=socket;}

    public void run(){
        try{
            while (true)
            {if(0==0)break;}
        } finally {
            try {
                if(socket!=null)socket.close();
            }catch (IOException e){e.printStackTrace();}
        }
    }

}


