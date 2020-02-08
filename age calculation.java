
//age calculation 



import java.applet.*;
import java.awt.event.*;
import java.awt.*;
//import java.lang.String;
import java.util.*;
  class age extends Frame implements ActionListener{
    Button b1,b2;
    Label l1,l2,l3,l4,l5,l6,l7,l8;
    TextField t1,t2,t3,t4,t5,t6,t7,t8;
    Panel p1;
    age(){
        setTitle("login form");
        setBounds(100,100,300,300);
        setBackground(Color.yellow);
        p1=new Panel(new GridLayout(9,2));
        l1=new Label("Date");
        p1.add(l1);
        t1=new TextField(30);
        t1.setBackground(Color.yellow);
        p1.add(t1);
        l2=new Label("MONTH");
        p1.add(l2);
        t2=new TextField(30);
        p1.add(t2);
        t2.setBackground(Color.yellow);
        l3=new Label("YEAR");
        p1.add(l3);
        //t3.setBackground(Color.yellow);
        t3=new TextField(10);
        p1.add(t3);
        t3.setBackground(Color.yellow);
        l4=new Label("TOTAL NUMBER OF DAYS");
        p1.add(l4);
        t4=new TextField(10);
        p1.add(t4);
        t4.setBackground(Color.yellow);
        l5=new Label("YEARS");
        p1.add(l5);
        t5=new TextField(10);
        p1.add(t5);
        t5.setBackground(Color.yellow);
        l6=new Label("MONTHS");
        p1.add(l6);
        t6=new TextField(10);
        p1.add(t6);
        t6.setBackground(Color.yellow);
        l7=new Label("DAYS");
        p1.add(l7);
        t7=new TextField(10);
        p1.add(t7);
        t7.setBackground(Color.yellow);
        l8=new Label("DAY");
        p1.add(l8);
        t8=new TextField(10);
        p1.add(t8);
        t8.setBackground(Color.yellow);
        
        //add(p1);
    //    p2=new Panel(new GridLayout(1,2));
        b1=new Button("RESULT");
        p1.add(b1);
        b1.setForeground(Color.red);
        b1.setBackground(Color.blue);
        b1.addActionListener(this);
        b2=new Button("cancle");
        p1.add(b2);
        b2.setForeground(Color.red);
        b2.setBackground(Color.blue);
        add(p1);
        b2.addActionListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    static String day(int d,int m,int y){
        int year,month=0,day;
        if( (d > 31) || (m > 12) || (y < 1900 || y >= 2100) )
    {
        System.out.println("INVALID INPUT. Please enter a valid date between 1900 and 2100");
        System.exit(0);
    }

    year = y-1900;
    year = year/4;
    year = year+y-1900;
    
    switch(m)
    {
    case 1:
    case 10:
        month = 1;
        break;
    case 2:
    case 3:
    case 11:
        month = 4;
        break;
    case 7:
    case 4:
        month = 0;
        break;
    case 5:
        month = 2;
        break;
    case 6:
        month = 5;
        break;
    case 8:
        month = 3;
        break;
    case 9:
    case 12:
        month = 6;
        break;
    }
    
    year = year + month;
    year = year + d;
    /* Need to make sure extra day is not needed in leap year for dates before March */
    if(( y > 1900 ) && ( y % 4 == 0 ) && ( m < 2 ) )
    year--;
    day  = year % 7;
    
    switch(day)
    {
    case 0:
        return "SATURDAY";
    case 1:
    return "SUNDAY";
    case 2:
         return "MONDAY";
    case 3:
    return "TUESDAY";
        
    case 4:
        return "WEDNESDAY";
        
    case 5:
        return "THURSDAY";
    case 6:
          return "FRIDAY";
    
    }
    return "a";
    }
    static int findAge(int crd,int crm,int cry,int bd,int bm,int by)
{ int cd;
int cm,count=0,year;
 int cy,k;
    int month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int days ,i;
    if(((by%4==0)&&(by%100)!=0)||(by%400==0)){
    if (bd > crd) {
        k=leap(by);
        crd=crd+month[bm-1]+k;
        crm=crm-1;}
    }
    if (bm>crm) {
        cry=cry-1;
        crm=crm+12;}
    cd=crd-bd;
    cm=crm-bm;
    cy=cry-by;
    days=cy*365;
    for(i=1;i<=cm;i++){
        days+=month[i];
    }
    days+=cd;
    for(year = by;year <= cry; year++){
         if(((year%4==0)&&(year%100!=0))||(year%400==0))
             count++;
    }
    days+=count;
    return days;
    }static int findAge1(int crd,int crm,int cry,int bd,int bm,int by)
{ int cd;
int cm,count=0,year;
 int cy,k;
    int month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int days ,i;
    if(((by%4==0)&&(by%100)!=0)||(by%400==0)){
    if (bd > crd) {
        k=leap(by);
        crd=crd+month[bm-1]+k;
        crm=crm-1;}
    }
    if (bm>crm) {
        cry=cry-1;
        crm=crm+12;}
    cd=crd-bd;
    cm=crm-bm;
    cy=cry-by;
    days=cy*365;
    for(i=1;i<=cm;i++){
        days+=month[i];
    }
    days+=cd;
    for(year = by;year <= cry; year++){
         if(((year%4==0)&&(year%100!=0))||(year%400==0))
             count++;
    }
    days+=count;
    return cy;
    }
    static int findAge2(int crd,int crm,int cry,int bd,int bm,int by)
{ int cd;
int cm,count=0,year;
 int cy,k;
    int month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int days ,i;
    if(((by%4==0)&&(by%100)!=0)||(by%400==0)){
    if (bd > crd) {
        k=leap(by);
        crd=crd+month[bm-1]+k;
        crm=crm-1;}
    }
    if (bm>crm) {
        cry=cry-1;
        crm=crm+12;}
    cd=crd-bd;
    cm=crm-bm;
    cy=cry-by;
    days=cy*365;
    for(i=1;i<=cm;i++){
        days+=month[i];
    }
    days+=cd;
    for(year = by;year <= cry; year++){
         if(((year%4==0)&&(year%100!=0))||(year%400==0))
             count++;
    }
    days+=count;
    return cm;
    }
    static int findAge3(int crd,int crm,int cry,int bd,int bm,int by)
{ int cd;
int cm,count=0,year;
 int cy,k;
    int month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int days ,i;
    if(((by%4==0)&&(by%100)!=0)||(by%400==0)){
    if (bd > crd) {
        k=leap(by);
        crd=crd+month[bm-1]+k;
        crm=crm-1;}
    }
    if (bm>crm) {
        cry=cry-1;
        crm=crm+12;}
    cd=crd-bd;
    cm=crm-bm;
    cy=cry-by;
    days=cy*365;
    for(i=1;i<=cm;i++){
        days+=month[i];
    }
    days+=cd;
    for(year = by;year <= cry; year++){
         if(((year%4==0)&&(year%100!=0))||(year%400==0))
             count++;
    }
    days+=count;
    return cd;
    }
    static int leap(int year){
    int i,k=0,j=0;
    for(i=year;i<=2011;i++){
     if (((i% 4==0)&&(i%100!=0))||(i%400==0))
        k++;
    }
    return k;
}
    public void actionPerformed(ActionEvent e){
        int year,month,day;
        int x,y,z,w;
        String s;
        int hour,minute,second;
        if(e.getSource()==b1&&t1.getText().isEmpty()==false&&t2.getText().isEmpty()==false){
            GregorianCalendar date = new GregorianCalendar();
     
      day = date.get(Calendar.DAY_OF_MONTH);
      month = date.get(Calendar.MONTH);
      year = date.get(Calendar.YEAR);
         month=month+1;
      second = date.get(Calendar.SECOND);
      minute = date.get(Calendar.MINUTE);
      hour = date.get(Calendar.HOUR);
      int p,q,r;
      p=Integer.parseInt(t1.getText());
      q=Integer.parseInt(t2.getText());
      r=Integer.parseInt(t3.getText());
      x=findAge(day,month,year,p,q,r);
      y=findAge1(day,month,year,p,q,r);
      z=findAge2(day,month,year,p,q,r);
      w=findAge3(day,month,year,p,q,r);
      s=day(p,q,r);
        
            t8.setText(s);
            t4.setText(String.valueOf(x));
            t5.setText(String.valueOf(y));
            t6.setText(String.valueOf(z));
            t7.setText(String.valueOf(w));
            
        }
        else if(e.getSource()==b1&&t1.getText().isEmpty()==true&&t2.getText().isEmpty()==true){
        
            t1.setForeground(Color.red);
            t1.setText("ENTER DAY OF YOUR DOB");
            t2.setText("ENTER MONTH OF YOUR DOB");
            t3.setText("ENTER YEAR OF YOURR DOB");
        }
        else{
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            
        }
    }
    public static void main(String args[]){
        new age().setVisible(true);
    }
}


