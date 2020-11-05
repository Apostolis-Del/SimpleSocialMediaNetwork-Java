import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.io.*;
import java.util.*; 

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class User
{   
    
    //axriasto to override
    
    @Override
    public int hashCode() {
        return 1;
    }
    
    //dimiourgia arraylists gia kathe methodo pou xreiazomaste
    
    ArrayList<String> friend = new ArrayList<String>(); 
    ArrayList<String> userslist = new ArrayList<String>();
    ArrayList<String> notfriendlist = new ArrayList<String>();
                
    private String Name;

    //axriasto constructor
    
    public void User(String k){
           // userarray.add(new User());
           //this.Name=k;
    }
    
    //to userlist periexei olous tous xristes
    
    public void UserList(String name){  
         try{
             BufferedReader abc = new BufferedReader(new FileReader("usersdata.txt"));
             
            String s;
            while((s=abc.readLine())!=null) {
                userslist.add(s);
                //userslist.remove(name);
                //System.out.println(s);
            }
            abc.close();
        }catch(Exception e){}
    
    }
   
      public void Userminusfriend(String name){
          
          //afairesei userlist-friendlist gia na blepei poious xristes dn exei filous
          
            UserList(name);
            FriendList(name);
            userslist.remove(name);
            userslist.removeAll(friend);
            notfriendlist.addAll(userslist);
            notfriendlist.remove(notfriendlist.get(0));
            
            
            Iterator<String> it = notfriendlist.iterator();
             while(it.hasNext()){
                System.out.println(it.next());
             } 
         
        
    }
     
    //boithiko get gia tin menu
    
    public List<String> getList() {
           return friend;
    }
    
    //methodos gia printing tou friendlist
    
    public void FriendListprint(String name ){
        
        List<String> friendlist = new ArrayList<String>();
        
         try{
             
            BufferedReader buf = new BufferedReader(new FileReader("usersfriends.txt"));
            ArrayList<String> words = new ArrayList<>();
            
            String line = null;
            String[] wordsArray;

            while(true){

                line = buf.readLine();
                
                if(line == null){  
                    
                    break; 
                    
                }else{
                    
                    wordsArray = line.split(",");
                 
                    for(String helper : wordsArray){

                        if( wordsArray[0].contains(name)){
                            
                             friend.add(helper);
                             
                        }
       
                    }

                }

            }
            
                 friend.remove(name);
                
                 System.out.println("___________________");
                 System.out.println("|Your friends are:|");
                 System.out.println("-------------------");
                
                 Iterator<String> it = friend.iterator();
                 while(it.hasNext()){
                    System.out.println(it.next());
                 }
                 
        }catch(Exception e){} 

    }
    
    //dimiourgia tou friendlist tou kathe xristi
    
    public void FriendList(String name ){
        
        List<String> friendlist = new ArrayList<String>();
        
         try{
             
            BufferedReader buf = new BufferedReader(new FileReader("usersfriends.txt"));           
            ArrayList<String> words = new ArrayList<>();
            
            String line = null;
            String[] wordsArray;

            while(true){

                line = buf.readLine();
                
                if(line == null){  
                    
                    break; 
                    
                }else{
                    wordsArray = line.split(",");
                 
                    for(String helper : wordsArray){

                        if( wordsArray[0].contains(name)){
                    
                             friend.add(helper);
                             
                        }
                        
                    }

                }

            }
            
            //isws thelei sxolio to remove
            
            friend.remove(name);
       
        }catch(Exception e){} 

    }
    
    //methodos gia to an dyo users einai filoi
    
    public boolean Friends(String user1, String user2){

        FriendList( user1);
        
        if(friend.contains(user2)){
            return true;
        }else{
            return false;}
            
        
        
    }
    
    //methodos gia prosthiki filwn kai apothikeusi sto usersfriends.txt
    
    public void FriendAdd(String user1,String context){
        
        File temp_file_1=new File("usersfriends.txt");

        List<String> friendreq = new ArrayList<String>();
        
         try{
             
             String newLineChar = System.getProperty("line.separator");

            BufferedReader buf = new BufferedReader(new FileReader("usersfriends.txt"));
            
            ArrayList<String> words = new ArrayList<>();           
            String line = null;
            String[] wordsArray;


            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("usersfriends.txt", true)));
            
            StringBuffer inputBuffer = new StringBuffer();

            String inputStr="";
            
            while(true){
                

                
                line = buf.readLine();
                if(line == null){  
                    
                    break; 
                    
                }else{
                    
                    inputBuffer.append(line);
                    wordsArray = line.split(",");
                        
                        if( wordsArray[0].contains(user1)){

                                                inputBuffer.append("," + context + "," );
                           
                        }

                    inputBuffer.append(newLineChar);
                    
                }             
            }
            
            buf.close();
            
            inputStr = inputBuffer.toString();
            //System.out.println("----------------------------------\n" + inputStr);
           
            
            File file = new File("usersfriends.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(inputStr);
            bufferedWriter.close();
            inputBuffer.setLength(0);
        
        }catch(Exception e){} 

        
        
        
    }
    
    //methodos gia diagrafi filou apo to usersfriends.txt ,pou den to zitaei sto programma alla itan stin klasi user
    
    public void DeleteFriend(String user1,String user2){
          

          File temp_file_1=new File("usersfriends.txt");
          List<String> friendreq = new ArrayList<String>();
        
         try{
             String newLineChar = System.getProperty("line.separator");

            BufferedReader buf = new BufferedReader(new FileReader("usersfriends.txt"));
            ArrayList<String> words = new ArrayList<>();    
            
            String line = null;
            String[] wordsArray;

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("usersfriends.txt", true)));
            
            StringBuffer inputBuffer = new StringBuffer();
            
            boolean bool=false;
            
            String kappa=" ";
            String inputStr="";
            
            while(true){
                int k=0;
                line = buf.readLine();
                if(line == null){  
                    
                    break; 
                    
                }else{
                    
                    wordsArray = line.split(",");

                        if( wordsArray[0].equals(user1)){
                                           
                                    kappa=line.replace(user2+",","");
                                    bool=true;

                        }

                        if(bool==true){
                                          
                           inputBuffer.append(kappa);
                           bool=false;
                                       
                          }else{
                              inputBuffer.append(line);
                           }
                                        
                        inputBuffer.append(newLineChar);
                        
                }             
            }
            
                buf.close();
                inputStr = inputBuffer.toString();
                //System.out.println("----------------------------------\n" + inputStr);
          
            
        
                File file = new File("usersfriends.txt");
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(inputStr);
                bufferedWriter.close();
                inputBuffer.setLength(0);
      
        }catch(Exception e){} 

    }
          
    public String getName(){
        return this.Name;
    }
    
    public void setName(String newname){
     this.Name=newname;
    }
   
}
