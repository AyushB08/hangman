import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    //all code needs classes, one class per file
    //oop = object-orientated programming (JAVA)
    public static void main(String[] args) throws Exception {
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        ArrayList<String> l = new ArrayList<String>();

        
       
        
 

        String[] words = getWords();
        String answer = words[r.nextInt(words.length)];
        String[] letters = answer.split("");
        String[] display = new String[answer.length()];
        for (int m = 0; m < answer.length(); m++) {
            display[m] = "_";

        }
        int lives = 6;
        
        while (lives > 0 && !check(display)) {
            System.out.println(answer);
            boolean correct = false;
        
            printboard(lives, display);
            System.out.println(letters.length);
            System.out.println("Here is your word bank: " + (l));
            System.out.print("Enter a letter: ");
            String input = s.nextLine();
            l.add(input);

            for (int n = 0; n < answer.length(); n++) {

                if (letters[n].equals(input)) {
                display[n]=input;
                correct=true;
                }
              
            }
            if (!correct) {
                lives--;
            }
        }

        if (lives == 0){
            System.out.println("You have lost the game.");
        }
        else {
            System.out.println("");
            System.out.println("The word was " + answer + ". You won!!");
        }

 
    }
    public static void printboard(int lives, String[] word) {
        String[] person = new String[]{"O", "|", "/", "\\", "/", "\\"};

        String[] temp = new String[] {"", "", "", "", "", ""};

        for (int i = 0; i < (6 - lives); i++)
            temp[i] = person[i];
        
        System.out.println("----------");
        System.out.println("         |");
        System.out.println("         " + temp[0]);
        System.out.println("        " + temp[2] + temp[1] + temp[3]);
        System.out.println("        " + temp[4] + " " + temp[5]);
        System.out.println();
        System.out.println(String.join(" ", word));

     
        
    }

    public static String[] getWords () throws Exception{
        BufferedReader b = new BufferedReader(new FileReader("src/words.txt"));
        String[] words = new String[10947];
        int i = 0;
        String s=b.readLine();
        while (s != null) {
            words[i] = s;
            i++;
            s=b.readLine();
            
        }
        return words;
    }

    public static boolean check(String[] display) {
        for(String s: display) {
            if (s.equals("_")) {
                return false;
            }
        }
        return true;
    }
    
}

