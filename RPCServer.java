import java.util.*;
import java.net.*;
import java.lang.Math; 
class RPCServer
{
    DatagramSocket ds;
    DatagramPacket dp;
    String str,methodName,result;
    float val1,val2;
    RPCServer()
    {
        result = "(Danilo) ";
        try
        {
            
            ds=new DatagramSocket(1200);
            byte b[]=new byte[8192];
            while(true)
            {
            dp=new DatagramPacket(b,b.length);
            ds.receive(dp);
            str=new String(dp.getData(),0,dp.getLength());
            if(str.equalsIgnoreCase("q"))
            {
                System.exit(1);
            }
            else
            {
                StringTokenizer st = new StringTokenizer(str," ");
                int i=0;
                while(st.hasMoreTokens())
                {
                    String token=st.nextToken();
                    methodName=token;
                    val1 = Float.parseFloat(st.nextToken());
                    val2 = Float.parseFloat(st.nextToken());
                }
            }
            System.out.println(str);
            InetAddress ia = InetAddress.getLocalHost();
            if(methodName.equalsIgnoreCase("add"))
            {
                result+= String.valueOf(add(val1,val2));
            }
            else if(methodName.equalsIgnoreCase("sub"))
            {
                result+= String.valueOf(sub(val1,val2);
            }
            else if(methodName.equalsIgnoreCase("mul"))
            {
                result+=String.valueOf(mul(val1,val2));
            }
            else if(methodName.equalsIgnoreCase("div"))
            {
                result+= String.valueOf(div(val1,val2));
            }
            else if(methodName.equalsIgnoreCase("pow"))
            {
                result+= String.valueOf(pow(val1,val2));
            }
            else if(methodName.equalsIgnoreCase("mod"))
            {
                result+= String.valueOf(mod(val1,val2));
            }
            byte b1[]=result.getBytes();
            DatagramSocket ds1 = new DatagramSocket();
            DatagramPacket dp1 = new DatagramPacket(b1,b1.length,InetAddress.getLocalHost(),1300);
            System.out.println("Result: "+result+"\n");
            ds1.send(dp1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public float add(float val1, float val2)
    {
        return val1+val2;
    }
    public float sub(float val3, float val4)
    {
        return val3-val4;
    }
    public float mul(float val3, float val4)
    {
        return val3*val4;
    }
    public float div(float val3, float val4)
    {
        return val3/val4;
    }

    public double pow(float val3, float val4)
    {
        return Math.pow(val3,val4);
    }

    public float mod(float val3, float val4)
    {
        return (int)val3 % (int)val4;
    }

    public static void main(String[] args)
    {
        new RPCServer();
    }
}
