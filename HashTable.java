package proyectofinaledd2019;

import java.util.ArrayList;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HashTable {


    static ArrayList temporal = new ArrayList();
    private int actual_size;
    private int count;
    private int actual_position;
    private final int [] positions;
    private ArrayList height;
    private double percentage;
    private final double limit;
    private HashNode[] structure;
    private boolean verify;
   
    private int Calculate(){
        return ((count*100)/actual_size);
    }
            
    public HashTable(){
        this.positions = new int[] {7,11,17,19,29,37,59,67,71,79,89,97,109,127,137,149,157,167,179,191,211,229,239,263,307,313,347,383,509};
        this.actual_position = 0;
        this.limit = 75.00;
        this.count = 0;
        this.actual_size = positions[actual_position];
        this.structure = new HashNode[actual_size];
        this.percentage = Calculate();
    }
    
    private static byte[] getSha256(String string_input) throws NoSuchAlgorithmException{
        MessageDigest message = MessageDigest.getInstance("SHA-256");
        return message.digest(string_input.getBytes(StandardCharsets.UTF_8));
    }
    
    private static String getHexString(byte[] new_hash){
        BigInteger number = new BigInteger(1,new_hash);
        StringBuilder string_hex = new StringBuilder(number.toString(16));
        while(string_hex.length() < 32){
            string_hex.insert(0,'0');
        }
        return string_hex.toString();
    }
    
    public int Code_Ascii(String name){
        int total = 0;
        for(int x = 0;x<name.length();x++){
            total += (int)name.charAt(x);
        }
        return total;
    }
    
    private String Generate_Timestamp(){
       String timestamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
       return timestamp;
    }
    
    private int Generate_Key(HashNode actualnode){
        String name = actualnode.getName();
        int get_number = Code_Ascii(name);
        int key = (get_number&0x7fffffff)%actual_size;
        return key;
    }
    
    private int Crash(HashNode actualnode, int position){
        int getkey = Generate_Key(actualnode);
        int getpow = (int) Math.pow(position+1,2);
        int newkey = getkey + getpow;
        return newkey;
    }
    
    public void Add_New(String name,String password){
        verify = false;
        String datetime = Generate_Timestamp();
        HashNode newnode = new HashNode(name,password,datetime);
        if(percentage <= limit){
            for(int x = 0; x < actual_size;x++){
                int new_position = 0;
            }
        }
    }
    
    private void Get_New_Array(){
        HashNode[] save_all = structure;
        boolean check = true;
        int actual = actual_size;
        if(actual < positions.length){
            actual += 1;
            check = true;
            if(actual == positions.length){
                System.out.println("FULL");
                check = false;
            }
        }
        
        if(check == true){
           actual_size = positions[actual];
           structure = new HashNode[actual_size];
           count = 0;
           percentage = Calculate();
           for(int x = 0; x < actual;x++){
               if(save_all[x]!= null){
                   //insertar todo
               }
           }
            System.out.println("YES");
        }  
    }
    
}
