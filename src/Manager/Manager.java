/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Objects.customer;
import Objects.order;
import Objects.product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Quang Thai
 */
public class Manager {
    private Scanner sc = new Scanner(System.in);
    public void addCustomer(ArrayList<customer> customers,int a){
        Validation checkInput = new Validation();
        String customerID = null,customerPhone,customerAddress,customerName;
        String inputCheckCont;
        boolean checkCont = true;
        while(checkCont){
            System.out.println("Enter customerID: ");
            while(checkInput.checkInputID(checkInput.getAlphaNumericString(4, 0, a), customers) == false){
                a++;
            }
            System.out.println(checkInput.getAlphaNumericString(4, 0, a));
            System.out.println("Enter customerName: ");
            customerName = sc.nextLine();
            System.out.println("Enter customerAddress: ");
            customerAddress = sc.nextLine();
            System.out.println("Enter customerPhone: ");
            customerPhone = sc.nextLine();
            customer emp = new customer(checkInput.getAlphaNumericString(4, 0, a), customerName, customerAddress, customerPhone);
            if(checkInput.checkInputCustomer(emp,customers)){

                a++;
                customers.add(emp);
                System.out.println("Add sucess");
            }
            else{
                System.out.println("Add falied");
            }
            System.out.print("Do you want continue add customer? (Y|N)");
                inputCheckCont = checkInput.checkInputAgree();
                if(inputCheckCont.charAt(0)=='N')
                    checkCont = false;
        }
    }
    public void listAllCusInf(){
        Validation valid = new Validation();
        ArrayList<customer> a = new ArrayList<>();
        try {
            FileReader fr = new FileReader("C:\\Users\\Quang Thai\\OneDrive\\Máy tính\\Code\\LAB211\\labb\\src\\File\\customers.dat");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true) {                
                line = br.readLine();
                if(line == null ) break;
                String[] txt = line.split(",");
                a.add(new customer(txt[0], txt[1], txt[2] , txt[3]));
            }
            System.out.println("﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍");
            System.out.printf("|%-7s|%-25s|%-25s|%-12s|%n","ID","Name","Address","Phone");
            System.out.println("﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍");
            for (customer o : a) {
                o.stringFormat();
            }
        } catch (Exception e) {
            System.out.println("Import file failed");
        }
    }
    public void searchCus(ArrayList<customer> customers){
        Validation checkInput = new Validation();
        String yourChoice;
        int checkValid;
        String inputCheckCont;
        boolean checkCont = true;
        while(checkCont){
            System.out.print("Enter ID: ");
            yourChoice = sc.next();
          
                checkValid = 0;
                for(customer v : customers){
                    if(v.getCustomerID().contains(yourChoice)){
                        v.stringFormat();
                        checkValid = 1;
                    }   
                }
                if(checkValid == 0){
                    System.out.println("\033[0;31m"+ "This customer does not exist" +"\033[0m");
                    for (customer v : customers) {
                        v.stringFormat();
                    }
                  
                }
            System.out.print("Do you want continue search ? (Y|N)");
            inputCheckCont = checkInput.checkInputAgree();
                if(inputCheckCont.charAt(0)=='N')
                    checkCont = false;
        }
    }
    public void saveCusToFile(ArrayList<customer> customers){
         try {
            FileWriter fw = new FileWriter("C:\\Users\\Quang Thai\\OneDrive\\Máy tính\\Code\\LAB211\\labb\\src\\File\\customers.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (customer v : customers) {
                bw.write(v.toString());
                bw.newLine();
            }
            System.out.println("Save succes!");
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.err.println("Save fail!");
        }
    }
    public void listAllProduct(){
        Validation valid = new Validation();
        ArrayList<product> a = new ArrayList<>();
        try {
            FileReader fr = new FileReader("C:\\Users\\Quang Thai\\OneDrive\\Máy tính\\Code\\LAB211\\labb\\src\\File\\products.dat");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true) {                
                line = br.readLine();
                if(line == null ) break;
                String[] txt = line.split(",");
                a.add(new product(txt[0], txt[1], txt[2] , txt[3], valid.changeToFloat(txt[4])));
            }
            System.out.println("﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍");
            System.out.printf("|%-7s|%-25s|%-25s|%-25s|%-12s|%n","ID","Name","Unit","Origin","Price");
            System.out.println("﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍﹍");
            for (product o : a) {
                o.stringFormat();
            }
        } catch (Exception e) {
            System.out.println("Import file failed");
        }
    } 
    public void updateCustomer(ArrayList<customer> customers){
        Validation checkInput = new Validation();
        String customerID;
        boolean checkContFull = true;
        int index = 0;
        while(checkContFull){
            System.out.println("Enter Customer ID: ");
            customerID = sc.next();
            index = 0;
            boolean checkValid = false;
            customer empValue = null;
            for (customer v : customers) {
                 if(v.getCustomerID().equals(customerID)){
                     checkValid = true;
                     empValue = v;
                     break;
                 }
                index++;
            }
            
            if(checkValid == false){ 
                 System.out.println("\033[0;31m"+ "Customer does not exist" +"\033[0m");
                 System.out.println("\033[0;46m"+ "========================================================================" + "\033[0m");
                 System.out.println("\033[0;31m"+ "CUSTOMER INFO" + "\033[0m");
                 System.out.printf("|%-7s|%-25s|%-25s|%-10s|%n","ID","Name","Address","Phone");
                 System.out.println("");
                 for (customer v : customers) {
                     v.stringFormat();
                 }
                 System.out.println("\033[0;46m"+ "========================================================================" + "\033[0m");
            }else{
                 boolean checkCont = true;
                 while(checkCont){
                     int yourChoice;
                     empValue.stringFormatUpdate();
                     System.out.println("Enter your choice: ");
                     yourChoice = sc.nextInt();
                     switch(yourChoice){
                         case 2: 
                             empValue = checkInput.checkValueUpdate(2, empValue);
                             break;
                         case 3: 
                             empValue = checkInput.checkValueUpdate(3, empValue);
                             break;
                         case 4: 
                             empValue = checkInput.checkValueUpdate(4, empValue);
                             break;
                         case 5:
                            checkCont = false;
                            break;
                     }
                 }
                customers.remove(index);
                customers.add(empValue);
            }
            System.out.print("Do you want continue update another customer? (Y/N)");
            String inputCheckCont;
            inputCheckCont = checkInput.checkInputAgree();
            if(inputCheckCont.charAt(0)=='N')
                checkContFull = false;
        }
    }
    
    public void addOrder(ArrayList<order> orders,ArrayList<customer> customers, ArrayList<product> products,int a){
        Validation checkInput = new Validation();
        boolean checkCont = true;
        while(checkCont){
            String orderID, customerID, productID, orderDate;
            int orderQua;
            boolean status = false;
            System.out.println("Enter orderID: ");
            while(checkInput.checkInputOrderID(checkInput.getAlphaNumericString(4, 2, a), orders) == false){
                a++;
            }
            System.out.println(checkInput.getAlphaNumericString(4, 2, a));
            System.out.println("Enter customerID: ");
            customerID = sc.nextLine();
            System.out.println("Enter productID: ");
            productID = sc.nextLine();
            System.out.println("Enter order Quantily: ");
            orderQua = sc.nextInt();
            System.out.println("Enter orderDate: ");
            orderDate = sc.next(); 
           orders.add(new order(checkInput.getAlphaNumericString(4, 2, a), customerID, productID, orderQua, orderDate, status));
            String inputCheckCont;
            System.out.println("Do you want to continue ? ");
            inputCheckCont = checkInput.checkInputAgree();
            if(inputCheckCont.charAt(0)=='N')
                checkCont = false;
        }
    }
    public void listAllOrders(){
        Validation checkInput = new Validation();
        try {
            ArrayList<order> a = new ArrayList<>();
            FileReader fr = new FileReader("C:\\Users\\Quang Thai\\OneDrive\\Máy tính\\Code\\LAB211\\labb\\src\\File\\orders.dat");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true) {                
                line = br.readLine();
                if(line == null ) break;
                String[] txt = line.split(",");
                if(txt[5].equals("false")){
                    a.add(new order(txt[0], txt[1], txt[2] ,checkInput.ChangeToInt(txt[3]), txt[4], false));
                }
                else{
                    a.add(new order(txt[0], txt[1], txt[2] ,checkInput.ChangeToInt(txt[3]), txt[4], true));
                }
            }
            for (order v : a) {
                    v.stringFormat();
            }
        }catch (Exception e) {
            System.out.println("Import file failed");
        }
    }
    public void listPendingOrder(){
        Validation checkInput = new Validation();
        try {
            ArrayList<order> a = new ArrayList<>();
            FileReader fr = new FileReader("C:\\Users\\Quang Thai\\OneDrive\\Máy tính\\Code\\LAB211\\labb\\src\\File\\orders.dat");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true) {                
                line = br.readLine();
                if(line == null ) break;
                String[] txt = line.split(",");
                if(txt[5].equals("false")){
                    a.add(new order(txt[0], txt[1], txt[2] ,checkInput.ChangeToInt(txt[3]), txt[4], false));
                }
               
            }
            for (order v : a) {
                v.stringFormat();
            }
        }catch (Exception e) {
            System.out.println("Import file failed");
        }
    }
    public void saveOrder(ArrayList<order> orders){
         try {
            FileWriter fw = new FileWriter("C:\\Users\\Quang Thai\\OneDrive\\Máy tính\\Code\\LAB211\\labb\\src\\File\\orders.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (order v : orders) {
                bw.write(v.toString());
                bw.newLine();
            }
            System.out.println("Save succes!");
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.err.println("Save fail!");
        }
    }
    public void updateOrder(ArrayList<order> orders){
        String ID;
        int check = 0;
        System.out.println("Enter ID: ");
        ID = sc.next();
        int index = 0;
        order tmp = null;
        for(order v : orders) {
            if(ID.equals(v.getOrderId())){
                check = 1;
                tmp = v;
                break;
            }
            index++;
        }
        if(check == 0){
            System.out.println("“Order does not exist");
            for (order v : orders) {
                v.stringFormat();
            }
        }else{
            System.out.println("Update success");
            tmp.setStatus(true);
            orders.add(index+1, tmp);
            orders.remove(index);
        }
    }
    
    public void delOrder(ArrayList<order> orders){
        String ID;
        int check = 0;
        System.out.println("Enter ID: ");
        ID = sc.next();
        int index = 0;
        order tmp = null;
        for(order v : orders) {
            if(ID.equals(v.getOrderId())){
                check = 1;
                tmp = v;
                break;
            }
            index++;
        }
        if(check == 0){
            System.out.println("“Order does not exist");
            for (order v : orders) {
                v.stringFormat();
            }
        }
        else{
            Validation checkInput = new Validation();
            String inputCheckCont;
            System.out.println("Do you want to continue ? ");
            inputCheckCont = checkInput.checkInputAgree();
            if(inputCheckCont.charAt(0)=='Y'){
                orders.remove(index);
                System.out.println("Delete success");
            }
        }
    }
}
