import java.util.*;

class Payment {
    private int num;
    private int type;
    private double cost;
    private String selectedTrainNumber;
    
    // Constructor
    Payment(String selectedTrainNumber,int num,int type) {
        this.selectedTrainNumber=selectedTrainNumber;
        this.num=num;
        this.type=type;
        
        // Initialize the price HashMap
        HashMap<Integer,Double> price=new HashMap<Integer,Double>();
        if (selectedTrainNumber.equals("123")){
            price.put(1,1105.25);
            price.put(2,910.75);
            price.put(3,720.35);
        }
        else if (selectedTrainNumber.equals("124")){
            price.put(1,1205.25);
            price.put(2,960.75);
            price.put(3,820.35);
        }
        else if (selectedTrainNumber.equals("125")){
            price.put(1,1305.25);
            price.put(2,1060.75);
            price.put(3,920.35);
        }
        else if (selectedTrainNumber.equals("126")){
            price.put(1,985.25);
            price.put(2,840.75);
            price.put(3,690.35);
        }
        else if (selectedTrainNumber.equals("127")){
            price.put(1,1065.25);
            price.put(2,890.75);
            price.put(3,705.35);
        }

        // Calculate the cost based on the type
        if (type==1)
            cost=price.get(1)*num;
        else if (type==2)
            cost=price.get(2)*num;
        else
            cost=price.get(3)*num;
    }
    
    void get_amt(int mode) {
        if (mode==1)
            System.out.println("Amount to be paid: " + (cost+0.1*cost));
        else if (mode==2)
            System.out.println("Amount to be paid: " + cost);
        else
            System.out.println("Invalid mode specified!");
    }
}