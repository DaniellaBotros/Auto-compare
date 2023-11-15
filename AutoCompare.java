import java.io.*; 
import java.util.*;  
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

    public int getIntegerValue(){
        return this.value;
    }
     @Override
    public int hashCode() 
    { 
        return this.value; 
    } 

}


public class AutoCompare 
{
    public static String[] getstrNumbers(String text){
        //Assuming list may begin and end with ',' we remove ','
         String str=text;
        if(text.charAt(0)==','){
            str=str.substring(1, text.length());// end = inputed end index-1
        }
        if(text.charAt(text.length()-1)==','){
            str=str.substring(0, text.length()-1);// end = inputed end index-1
        }
        return str.split(",");

        

    }
    public static ArrayList<listObj> getListOfObjects(String[] text, String name){
        ArrayList<listObj> list= new ArrayList<listObj>();
       for (int i=0; i< text.length; i++){
        list.add(new listObj(name, Integer.parseInt(text[i])));

       }

        return list;
    }


    public static void getEntries (HashMap <listObj,Integer> entries, ArrayList<listObj>list ){
            for (listObj lo : list) {
                if(entries.isEmpty() ||(entries.getOrDefault(lo,-1)==-1) ){
                    entries.putIfAbsent(lo,0);
                }
                else{
                    entries.replace(lo,(entries.get(lo)+1));
                }
                
            }
      
    }

    public static void writeToFile(String Filename,String str) throws IOException{
        ///////////////////////Write to output files///////////////////////////
        FileWriter fwOb=new FileWriter(new File(Filename));    
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        
        pwOb.write(str);

        pwOb.flush();
        pwOb.close();
        fwOb.close(); 

    }


    public static void main (String[] args){
       HashMap<listObj,Integer> entries = new HashMap <listObj,Integer>(); 
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

     ArrayList<listObj>list=getListOfObjects(getstrNumbers(text),listname);
     ArrayList<listObj>list1=getListOfObjects(getstrNumbers(text1),listname1);
    getEntries(entries,list);//get entries from list
    getEntries(entries,list1);//get entries from list1

    String strRepeated= "Repeated in "+listname+" and "+listname1+":"+'\n';;
    String strUnique="Unique in "+listname+":"+'\n';
    String strUnique1="Unique in "+listname1+":"+'\n';

    for(Map.Entry<listObj, Integer> m : entries.entrySet()){
        if(m.getValue()>0){
            strRepeated=strRepeated+m.getKey().getIntegerValue()+",";
        }
        else if ((m.getValue()==0)&& (m.getKey().toString().equals(listname))) {
            strUnique=strUnique+m.getKey().getIntegerValue()+",";
        }
        else if((m.getValue()==0)&& (m.getKey().toString().equals(listname1))){
            strUnique1=strUnique1+m.getKey().getIntegerValue()+",";
        }   
    }
    strUnique=strUnique+'\n'+strUnique1;

    
    writeToFile("Repeated.txt",strRepeated);

    writeToFile("Unique.txt",strUnique);


      
   
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
        

