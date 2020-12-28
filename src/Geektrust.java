import com.greektrust.constants.Gender;
import com.greektrust.structure.Family;

public class Geektrust {
    public static void main(String[] args) {
        Family family = new Family("Shan", Gender.MALE);
        family.addPartner("Shan", "Anga", Gender.FEMALE);
        family.addChild("Anga", "Ish", Gender.MALE);
    }
}
