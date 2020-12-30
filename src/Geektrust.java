import com.greektrust.family.FamilyApplication;
import com.greektrust.io.FileScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Geektrust {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        FileScanner fileScanner = new FileScanner(scanner);
        FamilyApplication familyApplication = new FamilyApplication(System.out::println, fileScanner);
        familyApplication.initialise();
        familyApplication.execute();
    }
}
