import com.greektrust.constants.Gender;
import com.greektrust.structure.Family;
import com.greektrust.structure.Person;

public class Geektrust {
    public static void main(String[] args) {
        Family family = new Family(new Person("Shan", Gender.MALE));
        family.addPartner("Shan", new Person("Anga", Gender.FEMALE));
        Person child = new Person("Ish", Gender.MALE);
        family.addChild("Anga", child);
    }
}
