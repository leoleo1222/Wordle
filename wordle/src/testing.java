import java.io.*;
import java.util.*;
public class testing {

    static String contain = ""  ;
    static String uncontain = "";
    static int idxcontain = 0, idxuncontain = 0;
    public static void main(String[] arg){
        System.out.println("Data check:");
        /*char j = 'k' - 32;
        System.out.println(j);*/
        int i = 0;
        char[] arr = {'_','_','_','_','_'};
        
        
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("End game(y/n)");
            while(!sc.nextLine().equals("y")){
                System.out.println("Fill The Word");
            print(arr);
            fill(arr, sc);
            
            System.out.println("Filled Word");
            print(arr);
            System.out.println();
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    boolean flag = true;
                    if(data.length() == 5 ){
                        for(int j =0; j < 5;j++){
                            char c = Character.toUpperCase(data.charAt(j));
                            
                            if(arr[j] == '_')
                                continue;
                            if(c != arr[j]){
                                flag = false;
                                break;
                            }
                            
                            flag = checkcontain(contain,data);
                           
                        }
                        
                        if(flag)
                            flag = checkuncontain(uncontain,data);
                            
                        if(flag){
                            System.out.print(data + "\t");
                            i++;
                            if(i % 5 == 0)
                                System.out.println();
                        }
                            
                    }

                }


                System.out.println();
                System.out.println("Word amount: " + i);
                i = 0;
                myReader.close();
            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
    static boolean checkcontain(String contain,String data){
        boolean flag = true;
        data = data.toUpperCase();
        for(int i = 0; i<contain.length();i++){
            char c = contain.charAt(i);
            String C = Character.toString(c);
            if(!data.contains(C)){
                flag = false;
                break;
            }
        }
        return flag;
    }
    static boolean checkuncontain(String uncontain,String data){
        boolean flag = true;
        data = data.toUpperCase();
        for(int i = 0; i < uncontain.length();i++){
            char c = uncontain.charAt(i);
            String C = Character.toString(c);
            if(data.contains(C)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static void print(char[] arr){
        for(char word : arr){
            System.out.print(word + " ");
        }
        System.out.println();
    }

    private static void fill(char[] arr, Scanner sc) {
        String in;
        while(true){
            System.out.println("Character Position:");
            int pos = sc.nextInt();
            sc.nextLine();
            System.out.println("Character");
            char word = sc.nextLine().charAt(0);
            arr[pos] = Character.toUpperCase(word);
            
            System.out.println("Contain charactor");
            in = sc.next();

            contain +=  in.toString().toUpperCase();

            System.out.println("Uncontain charactor");
            in = sc.next();

            uncontain += in.toUpperCase() ;

            System.out.println("Finished?(y/n)");
            if(sc.next().equals("y"))
                break;
        }


    }
}
