import com.greektrust.constants.Gender;
import com.greektrust.structure.Family;
import com.greektrust.structure.Person;

public class Geektrust {
    public static Family initialSetup() {
        Person shan = new Person("Shan", Gender.MALE);
        Family family = new Family(shan);
        Person anga = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", anga);

        family.addChild("Anga", new Person("chit", Gender.MALE));
        family.addChild("Anga", new Person("Ish", Gender.MALE));
        family.addChild("Anga", new Person("Vich", Gender.MALE));
        family.addChild("Anga", new Person("Aras", Gender.MALE));
        family.addChild("Anga", new Person("Satya", Gender.FEMALE));

        family.addPartner("Chit", new Person("Amba", Gender.FEMALE));
        family.addPartner("Vich", new Person("Lika", Gender.FEMALE));
        family.addPartner("Aras", new Person("Chitra", Gender.FEMALE));
        family.addPartner("Satya", new Person("Vyan", Gender.MALE));

        family.addChild("Amba", new Person("Dritha", Gender.FEMALE));
        family.addChild("Amba", new Person("Tritha", Gender.FEMALE));
        family.addChild("Amba", new Person("Vritha", Gender.MALE));

        family.addChild("Lika", new Person("Vila", Gender.FEMALE));
        family.addChild("Lika", new Person("Chika", Gender.FEMALE));

        family.addChild("Chitra", new Person("Jnki", Gender.FEMALE));
        family.addChild("Chitra", new Person("Ahit", Gender.MALE));

        family.addChild("Satya", new Person("Asva", Gender.MALE));
        family.addChild("Satya", new Person("Vyas", Gender.MALE));
        family.addChild("Satya", new Person("Atya", Gender.FEMALE));

        family.addPartner("Dritha", new Person("Jaya", Gender.MALE));

        family.addPartner("Jnki", new Person("Arit", Gender.MALE));

        family.addPartner("Asva", new Person("Satvy", Gender.FEMALE));
        family.addPartner("Vyas", new Person("Krpi", Gender.FEMALE));

        family.addChild("Dritha", new Person("Yodhan", Gender.MALE));

        family.addChild("Jnki", new Person("Laki", Gender.MALE));
        family.addChild("Jnki", new Person("Lavanya", Gender.FEMALE));

        family.addChild("Satvy", new Person("Vasa", Gender.MALE));

        family.addChild("Krpi", new Person("Kriya", Gender.MALE));
        family.addChild("Krpi", new Person("Krithi", Gender.MALE));

        return family;
    }

    public static void main(String[] args) {
        Family family = Geektrust.initialSetup();
    }
}
