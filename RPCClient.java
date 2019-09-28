import java.io.*;
import java.net.*;
class RPCClient
{
    RPCClient()
    {
        try
        {
            InetAddress ia = InetAddress.getByName("10.106.6.107");  
            //InetAddress ia = InetAddress.getLocalHost();
            System.out.println("\nRPC Client\n");
            System.out.println("Insira a operação (ex: add, sub, mult, div) e os números que deseja calcular \n");
            while (true)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                byte b[] = str.getBytes();
                DatagramPacket dp =  new DatagramPacket(b,b.length,ia,1200);
                ds.send(dp);
                dp = new DatagramPacket(b,b.length);
                ds1.receive(dp);
                String s = new String(dp.getData(),0,dp.getLength());
                System.out.println("\nResultado =" + s +"\n");

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main (String[] args)
    {
        new RPCClient();
    }
}
