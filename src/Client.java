/**
 * Created by xl on 2017/4/19.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //为了简单起见，所有的异常都直接往外抛
        String host = "192.168.0.244";  //要连接的服务端IP地址
        int port = 8898;   //要连接的服务端对应的监听端口
        //与服务端建立连接
        Socket client = new Socket(host, port);
        //建立连接后就可以往服务端写数据了
        BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out=new PrintWriter(client.getOutputStream());
        BufferedReader wt=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("请输入:");
            String str=wt.readLine();
            out.println(str);
            out.flush();
            if(str.equals("end"))
            {
                break;
            }
            System.out.println(in.readLine());
        }

        client.close();
        System.out.println("you are quit");
    }

}
