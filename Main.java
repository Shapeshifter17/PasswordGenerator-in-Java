import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int length = getLength();
        String pass = randomizeStr(length);
        System.out.println(pass);
        storePassword(pass);

    }

    //function to give a random String
    private static String randomizeStr(int length){

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] digits ={'0','1','2','3','4','5','6','7','8','9'};
        char[] symbols = "`~!@#$%^&*()_+=-[]{}|;:9<>?/".toCharArray();
        String password = "";
        Random r = new Random();

        for (int i = 0; i < length; i++) {

            int result = r.nextInt(3);
            switch (result){
                case 0:
                    int randIndex = r.nextInt(alphabet.length-1);
                    password += alphabet[randIndex];
                    break;
                case 1:
                    randIndex = r.nextInt(digits.length-1);
                    password += digits[randIndex];
                    break;
                case 2:
                    randIndex = r.nextInt(symbols.length-1);
                    password += symbols[randIndex];
                    break;
            }
        }
        return password;
    }

    //function to retrieve desired length of Password
    private static int getLength(){
        System.out.println("Welcome to Password generator and storer");
        System.out.println("Please enter the desired length of the password");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()){
            String input = scan.nextLine();
            System.out.println("Input is not valid, try again monke");

        }
        return scan.nextInt();
    }

    //function to store the password
    private static void storePassword(String pass){
        System.out.println("It will be stored in a file called passwords.txt");

        BufferedWriter output = null;

        try {
            File file = new File("passwords.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(pass);
        }

        catch (IOException e ) {
            e.printStackTrace();
        }

        finally {
            if ( output != null ) {
                try {
                    output.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

    }



