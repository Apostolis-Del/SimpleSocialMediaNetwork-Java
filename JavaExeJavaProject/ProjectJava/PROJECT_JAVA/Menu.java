
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Scanner;
import static java.lang.System.exit;
import java.util.List;
import java.util.ArrayList;



public class Menu extends User
{   

    Scanner scanchoice = new Scanner(System.in);
     
     public Menu(String username){
        
        //print to menu
         
        System.out.println("----------------");
        System.out.println("|1.See your wall|");
        System.out.println("|2.See friend's wall|");
        System.out.println("|3.Send friend request|");
        System.out.println("|4.Accept/Reject friend request|");
        System.out.println("|5.See my friends|");
        System.out.println("|6.Back|");
        System.out.println("|7.Logout|");
        System.out.println("|8.Exit|");
        System.out.println("|Please , choose an option|");
        System.out.println("-----------------");
     
        int inpu = scanchoice.nextInt();

    
        if(inpu == 1){
            
            //prwta emfanizetai to wall tou user, epeita twn filwn tou (friendlist)
            
            System.out.println("-----------------");
            System.out.println("|This is your wall|");
            System.out.println("-----------------");
            
            try{    
                
            Wall poi = new Wall(username);
            
            }catch(Exception e){}
            
            System.out.println("--------------------------------");
            System.out.println("|These are your friends' walls|\n");
            System.out.println("--------------------------------");
            
            User u = new User();
            u.FriendList(username);
            List<String> list = u.getList();
            int size = list.size();
            
            for(int k=1;k<size;k++){
                
                Wall poio=new Wall(list.get(k)); 
                System.out.println("\n");
                
            }
            
            

            System.out.println("-----------------");
            System.out.println("|1.Write a new post|");
            System.out.println("|2.Answer to a post|");
            System.out.println("|3.Like a post|");
            System.out.println("|4.Go back to main menu|");
            System.out.println("|Choose an option");
            System.out.println("----------------");
            
            int input1 = scanchoice.nextInt();
            
            if(input1==4){
                
                Menu m =new Menu(username);
                
            }else if(input1==1){
                
                Wall k = new Wall();
                Scanner s1=new Scanner(System.in);
                String context="";
                
                System.out.println("___________________________");
                System.out.println("|Please write your new post|");
                System.out.println("---------------------------");
                
                context=s1.nextLine();
                k.WriteToWall(username,context);
            }
            Menu m =new Menu(username);
            
        }
        else if(inpu==2){
            
            String fname="";
            
            try{
                
                //ektypwnei to friendlist kai epeita grafei to onoma tou filou tou opoiou
                //thelei na dei to wall tou kai na grapsei ston toixo tou
               
                
                Scanner s1=new Scanner(System.in);
                s1=new Scanner(new FileInputStream("usersdata.txt"));
                
                System.out.println("________________________________");
                System.out.println("|Here is a list of your friends:|");
                System.out.println("--------------------------------");
                             
                User u = new User();            
                u.FriendListprint(username);
                 
                System.out.println("________________________________________________________");
                System.out.println("|Please enter a friends name in order to see their wall|");
                System.out.println("--------------------------------------------------------");
                
                Scanner s2=new Scanner(System.in);
                fname=s2.nextLine();
                Wall w =new Wall(fname);
            
            }catch(Exception e){}
        
            System.out.println("\n  ");
            System.out.println("_________________");
            System.out.println("|1.Post a message|");
            System.out.println("|2.Reply to a message|");
            System.out.println("|3.Like a post|");
            System.out.println("|4.Go back to main menu|");
            System.out.println("|Choose an option|");
            System.out.println("_________________");
            int input1 = scanchoice.nextInt();
            
            if(input1==4){
                
                Menu m =new Menu(username);
                
            }else if(input1==1){
                
                Wall k = new Wall();
                Scanner s1=new Scanner(System.in);
                String context="";
                               
                System.out.println("_________________________________________________");
                System.out.println("|Please write your new post to your friend's wall|");
                System.out.println("-------------------------------------------------");
                
                context=s1.nextLine(); 
                k.WriteToFriendsWall(fname,context);
                
            }
                Menu m =new Menu(username);
        }
        else if(inpu==3){
            
            //proboli listas mi filwn ,scanner gia deutero username kai apostoli friend request
            
            System.out.println("________________________________________________________");
            System.out.println("|Here is a list of users that you can send friend request|");
            System.out.println("________________________________________________________");
            
            User u = new User();
            u.Userminusfriend(username);      
            
            System.out.println("_____________________________________________________________");
            System.out.println("|Enter the name of the user you want to send a friend request|");
            System.out.println("_____________________________________________________________");
            
            Scanner s2=new Scanner(System.in);
            String fname=s2.nextLine();
            FriendRequest f = new FriendRequest();            
            f.FriendRequestAddTxt(fname,username);
            //f.FriendRequestAddTxt(username,fname);
            
                                         
            Menu m =new Menu(username);
        }
               
        
        else if(inpu==4){
            
            //proboli twn friend requests kai apodoxi i arnisi tous
            
            System.out.println("________________________________________");
            System.out.println("|Here is a list of your friend requests:|");
            System.out.println("----------------------------------------");
            
            FriendRequest f = new FriendRequest();
            f.readFriendRequest(username);
            
            List<String> list = f.getReqs();
            int frsSize=list.size();

            for(int k=0;k<frsSize;k++){
                
            System.out.println("________________________________________________________");
            System.out.println("|Do you want to accept "+ list.get(k) +"'s friend request?|");
            System.out.println("|If yes , press 1, otherwise, press 2 in order to reject it.|");
            System.out.println("________________________________________________________");
            
            Scanner sc= new Scanner(System.in);
            int schoice=sc.nextInt();
            
            if(schoice==1){
                
                User u =new User();
                u.FriendAdd(username,list.get(k));
                f.FriendRequestDelTxt(username,list.get(k));
                
            }else if (schoice==2){
                
                f.FriendRequestDelTxt(username,list.get(k));
                f.FriendRequestDelTxt(list.get(k),username);
                
            }else{  
                
                System.out.println("Please enter a valid number");
               //  schoice=sc.nextInt();
            }
            Menu m =new Menu(username);
        }   
            
               
        }
        else if(inpu==5){
            
            //proboli listas filwn kai epistrofi ksana sto menu
            
            User u = new User();
            u.FriendListprint(username);
            Menu m =new Menu(username);
        }
        else if(inpu==6){
            
            //na thimithw na to xrisimopoihsw se kathe if
            
            Scanner menuscan= new Scanner(System.in);
            int mscan=menuscan.nextInt();
            
            if (mscan==6)  {        
                Menu m =new Menu(username);}
            else{
                System.out.println("You can only press the number 6");}
            
                  }
        else if(inpu==7){
             
             //login kapoiou xristi
            
             System.out.println("__________________________________");
             System.out.println("|Login,please enter your username|");
             System.out.println("----------------------------------");
             
             String n;
             Scanner s2=new Scanner(System.in);
             n=s2.nextLine();
             
             Main.Login(n);
                 
        }
        else if(inpu==8){
             
             //eksodos tou programmatos
            
             exit(0);        
                }
        else{
            
               System.out.println("____________________________________________");
               System.out.println("|Please press the numbers depicted in screen|");
               System.out.println("--------------------------------------------");
               
        }
   
    }
}
