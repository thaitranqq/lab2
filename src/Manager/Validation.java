/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Objects.customer;
import Objects.order;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quang Thai
 */
public class Validation {
      public int checkInputInt(){
        Scanner sc = new Scanner(System.in);
        int a = 0;
        try{
            a = sc.nextInt();           
        }
        catch(Exception e){
            System.err.println("Pls enter integer!");
            System.out.print("Enter again:");
            a = checkInputInt();
        }
        return a;
    }
      public String checkInputAgree(){
        Scanner sc = new Scanner(System.in);
        String a="";
        a = sc.nextLine();
        while(a.charAt(0)!='N' && a.charAt(0)!='Y'){
            System.err.println("Pls enter character 'N' to stop and 'Y' to continue");
            System.out.print("Do you want continue? Y|N");
            a = sc.nextLine();
        }
        return a;
    }
      public boolean checkInputID(String a,ArrayList<customer> customers){
        for(customer v : customers){
              if(v.getCustomerID().equals(a))
                  return false;
        }
        return true;
      }
      public boolean checkInputCustomer(customer a,ArrayList<customer> customers){
          //checkID
          for(customer v : customers){
              if(v.getCustomerID().equals(a.getCustomerID()))
                  return false;
          }
          //checkPhone
          if(a.getCustomerPhone().length()<10 || a.getCustomerPhone().length() > 12)
          {
              System.out.println("\033[0;31m"+ "The customer’s Phone has length from 10 to 12 characters" +"\033[0m");
              return false;
          }
          return true;
      }
     static String getAlphaNumericString(int n,int different,int value){
        if(different == 0){
            StringBuilder sb = new StringBuilder(n);
            sb.append("C");
            String tmp = "";
            while(value > 0){
                tmp = (char)(value%10+48) + tmp;
                value/=10;
            }
            while(tmp.length()<3){
                tmp = "0"+tmp;
            }
            sb.append(tmp);
            return sb.toString();
        }
        if( different == 1){
            StringBuilder sb = new StringBuilder(n);
            sb.append("P");
            String tmp = "";
            while(value > 0){
                tmp = (char)(value%10+48) + tmp;
                value/=10;
            }
            while(tmp.length()<3){
                tmp = "0"+tmp;
            }
            sb.append(tmp);
            return sb.toString();
        }
         if( different == 2){
            StringBuilder sb = new StringBuilder(n);
            sb.append("D");
            String tmp = "";
            while(value > 0){
                tmp = (char)(value%10+48) + tmp;
                value/=10;
            }
            while(tmp.length()<3){
                tmp = "0"+tmp;
            }
            sb.append(tmp);
            return sb.toString();
        }  
       return "12";
    }
     
      public float changeToFloat(String a){
        float val = (float) 0.0;
        char tmp[] = a.toCharArray();
        int lengthNumber = a.length();
        int i=0, check = 0;
        float k = (float) 0.1;
        while(i < lengthNumber){
            if(tmp[i] == '.'){
                check = 1;
            }
            else{
                if(check == 0){
                    val = val*10 + (int)(tmp[i]-48);
                }else
                {
                    val = (float)val + (float)(k*(int)(tmp[i]-48));
                    k = ((float)0.1* k);
                }
            }
            
            i++;
        }
        return (float)Math.floor(val *1000)/1000;
     }
       public customer checkValueUpdate(int i,customer a){
        Scanner sc = new Scanner(System.in);
        if(i == 2){
            String tmp;
            customer valueUpdate;
            System.out.println("Enter Customer Name:");
            tmp = sc.nextLine();
            valueUpdate = new customer(a.getCustomerID(),tmp,a.getCustomerAddress(),a.getCustomerPhone());
            return valueUpdate;
        }
        if(i == 3){
            String tmp;
            customer valueUpdate;
            System.out.println("Enter Customer Address:");
            tmp = sc.nextLine();
            valueUpdate = new customer(a.getCustomerID(),a.getCustomerName(),tmp,a.getCustomerPhone());
            return valueUpdate;
        }
        if(i == 4){
            String tmp;
            customer valueUpdate;
            do{
                System.out.print("Enter Customer Phone:");
                tmp = sc.nextLine();
                valueUpdate = new customer(a.getCustomerID(), a.getCustomerName(),a.getCustomerAddress(), tmp);
            }while(tmp.length()<10 || tmp.length()>12);
            return valueUpdate;
        }
        return a;
    }
    public boolean checkInputOrderID(String a, ArrayList<order> orders){
        for (order v : orders) {
            if(v.getOrderId().equals(a)) return false;
        }
        return true;
    }
    public int ChangeToInt(String a){
        int val=0;
        char tmp[] = a.toCharArray();
        int lengthNumber = a.length();
        int i=0;
        while(i<lengthNumber){
            val = val*10+(int)(tmp[i]-48);
            i++;
        }
        return val;
    }
}
