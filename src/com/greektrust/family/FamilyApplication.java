package com.greektrust.family;

import com.greektrust.constants.Gender;
import com.greektrust.constants.Relationship;
import com.greektrust.constants.Status;
import com.greektrust.io.FileScanner;
import com.greektrust.io.Printer;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyApplication {
    private final Printer printer;
    private final FileScanner scanner;
    private Family family;

    public FamilyApplication(Printer printer, FileScanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void initialise() {
        Person shan = new Person("Shan", Gender.MALE);
        this.family = new Family(shan);
        Person anga = new Person("Anga", Gender.FEMALE);
        this.family.addPartner("Shan", anga);

        this.family.addChild("Anga", new Person("Chit", Gender.MALE));
        this.family.addChild("Anga", new Person("Ish", Gender.MALE));
        this.family.addChild("Anga", new Person("Vich", Gender.MALE));
        this.family.addChild("Anga", new Person("Aras", Gender.MALE));
        this.family.addChild("Anga", new Person("Satya", Gender.FEMALE));

        this.family.addPartner("Chit", new Person("Amba", Gender.FEMALE));
        this.family.addPartner("Vich", new Person("Lika", Gender.FEMALE));
        this.family.addPartner("Aras", new Person("Chitra", Gender.FEMALE));
        this.family.addPartner("Satya", new Person("Vyan", Gender.MALE));

        this.family.addChild("Amba", new Person("Dritha", Gender.FEMALE));
        this.family.addChild("Amba", new Person("Tritha", Gender.FEMALE));
        this.family.addChild("Amba", new Person("Vritha", Gender.MALE));

        this.family.addChild("Lika", new Person("Vila", Gender.FEMALE));
        this.family.addChild("Lika", new Person("Chika", Gender.FEMALE));

        this.family.addChild("Chitra", new Person("Jnki", Gender.FEMALE));
        this.family.addChild("Chitra", new Person("Ahit", Gender.MALE));

        this.family.addChild("Satya", new Person("Asva", Gender.MALE));
        this.family.addChild("Satya", new Person("Vyas", Gender.MALE));
        this.family.addChild("Satya", new Person("Atya", Gender.FEMALE));

        this.family.addPartner("Dritha", new Person("Jaya", Gender.MALE));

        this.family.addPartner("Jnki", new Person("Arit", Gender.MALE));

        this.family.addPartner("Asva", new Person("Satvy", Gender.FEMALE));
        this.family.addPartner("Vyas", new Person("Krpi", Gender.FEMALE));

        this.family.addChild("Dritha", new Person("Yodhan", Gender.MALE));

        this.family.addChild("Jnki", new Person("Laki", Gender.MALE));
        this.family.addChild("Jnki", new Person("Lavanya", Gender.FEMALE));

        this.family.addChild("Satvy", new Person("Vasa", Gender.MALE));

        this.family.addChild("Krpi", new Person("Kriya", Gender.MALE));
        this.family.addChild("Krpi", new Person("Krithi", Gender.MALE));
    }

    public void execute() {
        while (this.scanner.hasNext()) {
            String currentCommand = this.scanner.nextLine();
            this.parseAndExecute(currentCommand);
        }
    }

    private void parseAndExecute(String command) {
        String[] arguments = command.split(" ");
        if (arguments[0].equals("ADD_CHILD")) {
            String mother = arguments[1];
            String childName = arguments[2];
            Gender gender = Gender.valueOf(arguments[3].toUpperCase());
            Person child = new Person(childName, gender);
            Status status = this.family.addChild(mother, child);
            this.showResult(status);
        }
        if (arguments[0].equals("GET_RELATIONSHIP")) {
            String relationValue = arguments[2].replace("-", "_").toUpperCase();
            Relationship relationship = Relationship.valueOf(relationValue);
            String personName = arguments[1];
            List<Person> relatives = this.family.findRelatives(personName, relationship);
            this.showResult(relatives);
        }
    }

    private void showResult(Status status) {
        this.printer.print(status.toString());
    }

    private void showResult(List<Person> relatives) {
        if (relatives.size() <= 0) {
            this.printer.print("NONE");
        }
        List<String> relativeNames = relatives.stream().map(Person::toString).collect(Collectors.toList());
        String relativesList = String.join(" ", relativeNames);
        this.printer.print(relativesList);
    }
}
