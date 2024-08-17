package day1;
import java.util.Scanner;
//Electricity bill
public class ElectricityBill{
    public static void main(String...args){
        Consumer ob=new Consumer();
        ob.getData();
        ob.calculate_bill();
        ob.display();
    }//End of main method
}//End of main class

//customer definition class
class Consumer{
    //*required onjects and variables 
    Scanner sc=new Scanner(System.in);
    int customer_number;
    String customer_name,type_of_conn;
    double pre_reading,curr_reading,unit_consumed,total_bill;
    
    //Getting data from user
    
    void getData(){
        System.out.println("type of connection(domestic/commercial):");
        type_of_conn=sc.nextLine();
        System.out.println("Enter customer no:");
        customer_number=sc.nextInt();
        System.out.println("customer_name:");
        customer_name=sc.next();
        System.out.println("Enter pre month reading:");
        pre_reading=sc.nextDouble();
        System.out.println("Enter current month reading:");
        curr_reading= sc.nextDouble();
    }

    //calculating the amount to be paid

    void calculate_bill(){
        unit_consumed=curr_reading-pre_reading;
        if(type_of_conn.contains("domestic")){
            total_bill=(unit_consumed<=100)?unit_consumed:
            (unit_consumed>100 && unit_consumed<=200)?2.5*unit_consumed:
            (unit_consumed>200 && unit_consumed<=500)?4*unit_consumed:6*unit_consumed;
        }
        else if(type_of_conn.contains("commercial")){
            total_bill=(unit_consumed<=100)?2*unit_consumed:
            (unit_consumed>100 && unit_consumed<=200)?4.5*unit_consumed:
            (unit_consumed>200 && unit_consumed<=500)?6*unit_consumed:7*unit_consumed;
        }
        sc.close();//closing scanner
    }

    //producing output 

    void display(){
        System.out.println("***********************************************");
        System.out.println("Customer number: "+customer_number+
        "\n Customer name: "+customer_name+
        "\n number of units consumed: "+unit_consumed+
        "\nBill to be paid: "+total_bill);
        System.out.println("***********************************************");
    }
}