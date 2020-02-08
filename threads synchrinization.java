//threads synchronization
class callme
{
    void print(String msg)
    {
    	//System.out.print("[" + msg);
    
    try
    {
       System.out.print("[" + msg);
     
        
        Thread.sleep(500);
    }
    catch(InterruptedException ie)
    {
        System.out.println(ie);
    }
    System.out.println("]");
    }
    
}
class caller extends Thread
{
    String msg;
    callme ta;
    public caller(callme ta, String s)
    {
    this.ta=ta;
    msg=s;
    
//    this.start();    
    }
    public void run()
    {
        for(int i=0;i<5;i++)
        	synchronized(ta)
        		
        	{
        	
        ta.print(msg);}
        
    }
}
class Threadsyn2
{
    public static void main(String[] args)
    {
        callme c=new callme();
        caller ob1=new caller(c,"hello");
        caller ob2=new caller(c,"deepika");
        caller ob3=new caller(c,"hai");
    try
        {
            ob1.start();
            ob2.start();
            ob3.start();
        }
        catch(Exception ie)
    {
        System.out.println(ie);
    }
    }
}


