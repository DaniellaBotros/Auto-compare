import java.io.*; 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.*;


class listObj {
        private String listname;
        private int value;
        public listObj(String listname ,int value){
            this.listname=listname;
            this.value=value;
        }

        @Override
        public boolean equals(Object o){
            if (o == this) {
            return true;
        }
        if (!(o instanceof listObj)) {
            return false;
        }

        listObj c = (listObj) o;
     return (c.value == this.value);
    }

    @Override
    public String toString(){
        return this.listname;

    }

    public int getValue(){
        return this.value;
    }
}


public class AutoCompare 
{


    public static ArrayList<Integer> getIntList(String text, String listname){

    ArrayList<Integer> list=new ArrayList<Integer>() ;
    String temp="";
    char[] charList=text.toCharArray();
    for(int i=0; i<charList.length;i++){
        if(charList[i]!='\n' && charList[i]!=','&& charList[i]!='\t' && charList[i]!=' '){
            temp=temp+charList[i];
           
        }
         else if(charList[i]==',' && i!=0 && list.contains(Integer.parseInt(temp)) && temp!=""){
            temp="";
         }
        else if(charList[i]==',' && i!=0 && !list.contains(Integer.parseInt(temp)) && temp!="" ){
            list.add(Integer.parseInt(temp));
            temp="";
        }
    }
    return list;

    }




    public static void main (String[] args){
        ArrayList<Integer> list= new ArrayList<Integer>();
        ArrayList<Integer> list1= new ArrayList<Integer>();
        ArrayList<listObj> repeated= new ArrayList<listObj>();
        ArrayList<listObj> unique= new ArrayList<listObj>();
        String text="";
        String text1="";
        String listname="";
        String listname1="";


       try{
    Scanner reader = new Scanner(new File ("input List1.txt"));
    Scanner reader1 = new Scanner(new File ("input list2.txt"));
    
    listname=reader.nextLine();//listname
    listname1=reader1.nextLine();//listname1

  
    while(reader.hasNextLine()){
        text=text+reader.nextLine();//list
    }
    while(reader1.hasNextLine()){
        text1=text1+reader1.nextLine();//list1
    }
      
    list=getIntList(text,listname);
    Collections.sort(list);
    list1=getIntList(text1,listname1);
    Collections.sort(list1);

    Comparator<listObj> c = new Comparator<listObj>() {
      public int compare(listObj a, listObj b) {
        return ((a.getValue()==b.getValue())?1:0);
      }
   };
    //Collections. binarySearch();
        //(Collections.binarySearch(repeated, new listObj(listname, ent), c)<0)

    for(Integer ent : list) {
     if(list1.contains(ent) && !repeated.contains(new listObj(listname, ent))){
        repeated.add(new listObj(listname, ent));
     }
     else if(!list1.contains(ent) && !unique.contains(new listObj(listname, ent)) ){
        unique.add(new listObj(listname, ent));
     }

    }

        for(Integer ent : list1) {
     if(list.contains(ent) && !repeated.contains(new listObj(listname1, ent))){
        repeated.add(new listObj(listname1, ent));
     }
     else if(!list.contains(ent) && !unique.contains(new listObj(listname1, ent)) ){
        unique.add(new listObj(listname1, ent));
     }

    }




    File rep = new File("Repeated.txt");
    FileWriter fwOb=new FileWriter(rep);    
    PrintWriter pwOb = new PrintWriter(fwOb, false);
    String str = "Repeated in "+listname+" and "+listname1+":"+'\n';

    for(listObj s: repeated){
        str=str+s.getValue()+",";
    }
    pwOb.write(str);


    pwOb.flush();
    pwOb.close();
    fwOb.close();  

    str="Unique in "+listname+":"+'\n';
    String str1="Unique in "+listname1+":"+'\n';
    
    File uniq = new File("Unique.txt");


    FileWriter fwOb1=new FileWriter(uniq);    
    
    PrintWriter pwOb1 = new PrintWriter(fwOb1, false);
    for(listObj s: unique){
        if((s.toString()).equals(listname)){
             str=str+s.getValue()+",";
        }
        else{
             str1=str1+s.getValue()+",";
        }
       
    }
    str=str+str1;
    
    pwOb1.write(str);

    pwOb1.flush();
    pwOb1.close();
    fwOb1.close(); 

    System.out.println("Auto compare is complete!!");

    



       }
catch(FileNotFoundException e){
System.out.println("No input file found!");
e.printStackTrace();
} 
catch (IOException e) {
    
    e.printStackTrace();
}
}
}
        

