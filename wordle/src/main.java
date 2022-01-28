import java.io.*;
import java.util.*;
public class main {
    static String uncontain = "";
    public static void main(String[] arg){
        System.out.println("Wordle Start:");
        int i = 0;
        char[] arr = {'_','_','_','_','_'};
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("End game(y/n)");
            do{
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
                    boolean valid = true;
                    if(data.length() == 5 ){
                        for(int j =0; j < 5;j++){
                            char c = Character.toUpperCase(data.charAt(j));
                            if(arr[j] == '_')
                                continue;
                            if(c != arr[j]){
                                valid = false;
                                break;
                            }
                        }
                        for(int j = 0; j < uncontain.length(); j++){
                            data = data.toUpperCase();
                            if(data.contains(Character.toString(Character.toUpperCase(uncontain.charAt(j)))))
                                valid = false;
                            data = data.toLowerCase();
                        }
                        if(valid){
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
                System.out.println("Continue?(y/n)");
            }while (!sc.nextLine().equals("n"));


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }


    private static void print(char[] arr){
        for(char word : arr){
            System.out.print(word + " ");
        }
        System.out.println();
    }

    private static void fill(char[] arr, Scanner sc) {
        while(true){
            System.out.println("Position:");
            int pos = sc.nextInt();
            sc.nextLine();
            System.out.println("Character");
            char word = sc.nextLine().charAt(0);
            arr[pos] = Character.toUpperCase(word);
            System.out.println("Not contained word");
            String ncontain = sc.nextLine();
            uncontain += ncontain;
            System.out.println("Finished?(y/n)");
            if(sc.nextLine().equals("y"))
                break;
        }


    }
}