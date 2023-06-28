import java.util.*;
import java.io.*;

class Mmenu
{
  public void menu()
  {
    System.out.println("\n--------EMPLOYEE MANAGEMENT SYSTEM-----------");
    System.out.println("\nPress 1 : To Add Employee Details");
    System.out.println("Press 2 : To See Employee Details ");
    System.out.println("Press 3 : To Remove an Employee");
    System.out.println("Press 4 : To Update Employee Details");
    System.out.println("Press 5 : To Exit the EMS Portal");

  }
}


class EmployeeAdd
{
    public void createFile()
    {
        Scanner sc=new Scanner(System.in);

        EmployDetail emp=new EmployDetail();
        emp.getInfo();
        try{
            File f1=new File("file"+emp.employ_id+".txt");
            if(f1.createNewFile()){
                FileWriter myWriter = new FileWriter("file"+emp.employ_id+".txt");
                myWriter.write("Employee ID:"+emp.employ_id+"\n"+"Employee Name     :"+emp.name+"\n"+
                "Father's Name     :"+emp.last_name+"\n"+"Employee Contact  :"+emp.employ_contact+"\n"+
                "Email Information :"+emp.email+"\n"+"Employee position :"+emp.position+"\n"+
                "Employee Salary   :"+emp.employ_salary);
                myWriter.close();
                System.out.println("\nEmployee has been Added :)\n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
            else {
                System.out.println("\nEmployee already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}


class EmployDetail
{
    String name;
    String last_name;
    String email;
    String position;
    String employ_id;
    String employ_salary;
    String employ_contact;
    public void getInfo()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Employee's First name : ");
        name=sc.nextLine();
        System.out.print("Enter Employee's Last name : ");
        last_name=sc.nextLine();
        System.out.print("Enter Employee's ID : ");
        employ_id=sc.nextLine();
        System.out.print("Enter Employee's Email ID : ");
        email=sc.nextLine();
        System.out.print("Enter Employee's Position : ");
        position=sc.nextLine();
        System.out.print("Enter Employee contact Info : ");
        employ_contact=sc.nextLine();
        System.out.print("Enter Employee's Salary : ");
        employ_salary=sc.nextLine();
    }
}


class EmployeeShow
{
  public void viewFile(String s) throws Exception
  {
    File file = new File("file"+s+".txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine())
     {
       System.out.println(sc.nextLine());
     }
   }
}


class EmployeeRemove
{
    public void removeFile(String ID)
    {

    File file = new File("file"+ID+".txt");
      if(file.exists())
       {
         if(file.delete());
         {
           System.out.println("\nEmployee has been removed Successfully");
         }
       }
      else
       {
            System.out.println("\nEmployee does not exists :( ");
       }
     }
}


class EmployeeUpdate
{
  public void updateFile(String s,String o,String n) throws IOException
  {
   File file = new File("file"+s+".txt");
   Scanner sc = new Scanner(file);
   String fileContext="";
   while (sc.hasNextLine())
       {
         fileContext =fileContext+"\n"+sc.nextLine();
       }
   FileWriter myWriter = new FileWriter("file"+s+".txt");
   fileContext = fileContext.replaceAll(o,n);
   myWriter.write(fileContext);
   myWriter.close();

  }
}


class Exit
{
  public void out()
  {
    System.out.println("\n Exit Successfully ");
    System.exit(0);
  }
}


class EMS
{
  public static void main(String arv[])
  {
    System.out.print("\033[H\033[2J");

    Scanner sc=new Scanner(System.in);
    EmployeeShow epv =new EmployeeShow();

    int i=0;

    Mmenu obj1 = new Mmenu();
    obj1.menu();

    while(i<6)
    {

      System.out.print("\nPlease Enter choice :");
      i=Integer.parseInt(sc.nextLine());

      switch(i)
      {
        case 1:
        {
        EmployeeAdd ep =new EmployeeAdd();
        ep.createFile();

        System.out.print("\033[H\033[2J");
        obj1.menu();
        break;
        }
        case 2:
        {
          System.out.print("\nPlease Enter Employee's ID :");
          String s=sc.nextLine();
          try
          {
            epv.viewFile(s);}
            catch(Exception e){System.out.println(e);}


            System.out.print("\nPress Enter to Continue...");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            obj1.menu();
            break;
          }

        case 3:
        {
          System.out.print("\nPlease Enter Employee's ID :");
          String s=sc.nextLine();
          EmployeeRemove epr =new EmployeeRemove();
          epr.removeFile(s);

          System.out.print("\nPress Enter to Continue...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }
        case 4:
        {
            System.out.print("\nPlease Enter Employee's ID :");
            String I=sc.nextLine();
            try
            {
              epv.viewFile(I);
            }
            catch(Exception e)
            {
              System.out.println(e);
            }
            EmployeeUpdate epu = new EmployeeUpdate();
            System.out.print("Please Enter the detail you want to Update :");
    	      System.out.print("\nFor Example :\n");
            System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
            String s=sc.nextLine();
            System.out.print("Please Enter the Updated Info :");
            String n=sc.nextLine();
            try
            {
              epu.updateFile(I,s,n);

              System.out.print("\nPress Enter to Continue...");
              sc.nextLine();
              System.out.print("\033[H\033[2J");
              obj1.menu();
              break;
            }
            catch(IOException e)
            {
              System.out.println(e);
            }
        }
        case 5:
        {
          Exit obj = new Exit();
          obj.out();
        }
      }
    }
  }
}

