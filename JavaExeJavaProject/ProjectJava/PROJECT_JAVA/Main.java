import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.io.FileWriter;
import java.util.ArrayList;


class Main  {
public static void main(String[] args){
 
    System.out.println("_________________________________");
    System.out.println("|Login,please enter your username|");
    System.out.println("---------------------------------");
    
    String n;
    Scanner s2=new Scanner(System.in);
    n=s2.nextLine();
  
    Login(n);
  
    
}

public static void Login(String k){
       
        //Dimiourgia kai elegxos yparksis tou userdata.txt(tou txt pou periexei tous xristes
        
        
        try{
            File temp_file_1=new File("usersdata.txt");
            boolean file_exists=temp_file_1.exists();
            FileInputStream file_input=new FileInputStream("usersdata.txt");
        }catch(FileNotFoundException fnfe){
            System.out.println("The file \"usersdata.csv\" wasn't found in this directory.");
            System.exit(0);
        }
            
        //elegxos ean o xristis yparxei idi sto sto systima. ean den yparxei 
        //tote dimiourgei kainourgio xristi kai ton prosthetei sta katallila txt files
        
        boolean flag=false;
        
          try{
              
                Scanner s1;
                s1=new Scanner(new FileInputStream("usersdata.txt"));
                String name,n;
                n=k;

                
                while(s1.hasNext()) {
                    name=s1.next();

                    if(n.equals(name) ) {
                        
                        System.out.println("____________________");
                        System.out.println("|You are logged in.|");
                        System.out.println("____________________");
                        
                        flag=true;
                        
                        User us=new User();
                        us.setName(n);
                        
                        break;
                    }        
                   
                }
                    s1.close();

                     
                     if(!flag){
                        User us=new User();
                        us.setName(n);
                        us.UserList(n);
                        us.FriendList(n);
                        
                        System.out.println("____________________");
                        System.out.println("|Creating new user.|");
                        System.out.println("--------------------");
                        
                        BufferedWriter writer = null;
                        writer = new BufferedWriter(new FileWriter("usersdata.txt",true));
                        writer.write(n);
                        writer.newLine();    
                        writer.close();
                        
                        writer = new BufferedWriter(new FileWriter("usersfriends.txt",true));
                        writer.write(n);
                        writer.newLine();    
                        writer.close();
                        
                        writer = new BufferedWriter(new FileWriter("usersposts.txt",true));
                        writer.write(n);
                        writer.newLine();    
                        writer.close();
                        
                        writer = new BufferedWriter(new FileWriter("friendrequests.txt",true));
                        writer.write(n);
                        writer.newLine();    
                        writer.close();
                
                }
                  Menu m = new Menu(k);

        }catch(Exception e){}

}
        

    
 }
