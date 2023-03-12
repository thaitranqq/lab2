/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Manager.Manager;
import Manager.Validation;
import Objects.customer;
import Objects.order;
import Objects.product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quang Thai
 */
public class Menu {
//    public 
     public void Menu(){
        System.out.printf(" %-21s %-16s %n"," ","ORDER MANAGEMENT"); 
        System.out.printf("%-5s %n"," ____________________________________________________________");
        System.out.printf("%-21s %-37s %-5s %n","│ 1.","List all Products","│"); 
        System.out.printf("%-20s %-38s %-5s %n","│ 2.","List all Customers","│"); 
        System.out.printf("%-21s %-37s %-5s %n","│ 3.","Search a Customer","│");
        System.out.printf("%-22s %-36s %-5s %n","│ 4.","Add a Customer","│"); 
        System.out.printf("%-21s %-37s %-5s %n","│ 5.","Update a Customer","│");
        System.out.printf("%-22s %-36s %-5s %n","│ 6.","Save Customers","│"); 
        System.out.printf("%-22s %-36s %-5s %n","│ 7.","List all Orders","│");
        System.out.printf("%-19s %-39s %-5s %n","│ 8.","List all pending Orders","│"); 
        System.out.printf("%-24s %-34s %-5s %n","│ 9.","Add an Order","│");
        System.out.printf("%-22s %-36s %-5s %n","│ 10.","Update an Order","│"); 
        System.out.printf("%-19s %-39s %-5s %n","│ 11.","Save Orders to file","│");
        System.out.printf("%-28s %-30s %-5s %n","│ 12.","Quit","│");
        System.out.println("│___________________________________________________________│");
    }
      public boolean checkInputMenu(int a){
        return (a >= 1 && a <= 12);
    }
     public void display(){
         int cusCheck = 1;
         int orderCheck = 1;
         Validation valid = new Validation();
         ArrayList<product> products = new ArrayList<>();
         ArrayList<order> orders = new ArrayList<>();
         ArrayList<customer> customers = new ArrayList<>();
         ArrayList<customer> a = new ArrayList<>();
         Manager appRun = new Manager();
         Scanner sc = new Scanner(System.in);
         ArrayList<product> b = new ArrayList<>();
        try {
            FileReader fr = new FileReader("C:\\Users\\Quang Thai\\OneDrive\\Máy tính\\Code\\LAB211\\labb\\src\\File\\products.dat");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true) {                
                line = br.readLine();
                if(line == null ) break;
                String[] txt = line.split(",");
                b.add(new product(txt[0], txt[1], txt[2] , txt[3], valid.changeToFloat(txt[4])));
            }
        }catch (Exception e) {
            System.out.println("Import file failed");
        }
        products = b;
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
        } catch (Exception e) {
                    System.out.println("Import file failed");
        }
        customers = a;
         while(true){
            
            int choice;
            Menu();
            System.out.printf("%s","Enter your choice: ");
            choice = valid.checkInputInt();
            while(!checkInputMenu(choice)){
                System.err.println("Pls enter from 1 to 12!");
                System.out.printf("%s","Enter your choice: ");
                choice = valid.checkInputInt();
            }
           
            if(choice == 1 ){
                appRun.listAllProduct();
            }
            if(choice == 2 ){
                appRun.listAllCusInf();
            }
            if(choice == 3){
                appRun.searchCus(customers);
            }
            if(choice == 4){
                appRun.addCustomer(customers,cusCheck);
            }
             if(choice == 5){
                appRun.updateCustomer(customers);
            }
            if(choice == 6){
                appRun.saveCusToFile(customers);
            }
            if(choice == 7){
                appRun.listAllOrders();
            }
            if(choice == 8){
                appRun.listPendingOrder();
            }
            if(choice == 9 ){
                appRun.addOrder(orders, customers, products,orderCheck);
            }
            if(choice == 10 ){
                int subchoice;
                System.out.println("1. Update order information");
                System.out.println("2. Delete order");
                subchoice = sc.nextInt();
                if(subchoice == 1) appRun.updateOrder(orders);
                else appRun.delOrder(orders);
            }
            if(choice == 11 ){
                appRun.saveOrder(orders);
            }
            if(choice == 12) break;
        }
     }
}
