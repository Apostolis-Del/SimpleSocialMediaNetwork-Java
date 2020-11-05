import java.util.Date;
import java.text.SimpleDateFormat;
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




public class FriendRequest extends User
{
  
    ArrayList<String> friendreqsend = new ArrayList<String>();
    
    //methodos gia apostoli friendrequest se enan user
    
    public static void FriendRequestAddTxt(String user1,String user2){
        
        File temp_file_1=new File("friendrequests.txt");
        List<String> friendreq = new ArrayList<String>();
        
         try{
             
            String newLineChar = System.getProperty("line.separator");

            BufferedReader buf = new BufferedReader(new FileReader("friendrequests.txt"));
            ArrayList<String> words = new ArrayList<>();    
            
            String line = null;
            String[] wordsArray;

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("friendrequests.txt", true))); 
            StringBuffer inputBuffer = new StringBuffer();

            String inputStr="";
            
            while(true){
                
                int k=0;
                line = buf.readLine();
                
                if(line == null){  
                    
                    break; 
                    
                }else{
                    
                    inputBuffer.append(line);                    
                    wordsArray = line.split(",");

                    for(String helper : wordsArray){
                        
                        if( wordsArray[0].contains(user1)){

                                                inputBuffer.append(user2 +",");
                           
                        }
                    }
                    
                    inputBuffer.append(newLineChar);
                }             
            }
            
            buf.close();
            inputStr = inputBuffer.toString();

            File file = new File("friendrequests.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(inputStr);
            bufferedWriter.close();
            inputBuffer.setLength(0);
         
        }catch(Exception e){} 

    }
    
    //methodos gia diagrafi kapoiou friendrequest
    
    public static void FriendRequestDelTxt(String user1,String user2){
        
        File temp_file_1=new File("friendrequests.txt");
        List<String> friendreq = new ArrayList<String>();
        
         try{
             
            String newLineChar = System.getProperty("line.separator");

            BufferedReader buf = new BufferedReader(new FileReader("friendrequests.txt"));
            ArrayList<String> words = new ArrayList<>(); 
            
            String line = null;
            String[] wordsArray;

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("friendrequests.txt", true)));
            
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
                         }
                        else{
                              inputBuffer.append(line);
                            }
                             
                    inputBuffer.append(newLineChar);
                    
                }             
            }
            
            buf.close();
            inputStr = inputBuffer.toString();
            System.out.println("----------------------------------\n" + inputStr);
          
            
            
            File file = new File("friendrequests.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(inputStr);
            bufferedWriter.close();
            inputBuffer.setLength(0);
      
        }catch(Exception e){} 

    } 
    
    //methodos gia diabasma enos friendrequest, paromoia me tin apo panw
    
    public void readFriendRequest(String user1){
        
         try{
             
            BufferedReader buf = new BufferedReader(new FileReader("friendrequests.txt"));        
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
                   
                        if( wordsArray[0].contains(user1)){
                            
                            friendreqsend.add(helper);
                           
                        }
                     
                        
                    }

                }
                  
            }
            
            friendreqsend.remove(user1);
            
            Iterator<String> it = friendreqsend.iterator(); 
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }catch(Exception e){} 

    }
    
    
    
    public List<String> getReqs() {
           return friendreqsend;
    }
        
    

    
    
  public void showDate(){
      
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
    String formattedDate = sdf.format(date);
    System.out.println(formattedDate); 

    }
    
   
}
