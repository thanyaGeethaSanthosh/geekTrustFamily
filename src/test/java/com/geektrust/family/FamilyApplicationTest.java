package com.geektrust.family;

import com.geektrust.io.FileScanner;
import com.geektrust.io.Printer;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class FamilyApplicationTest {

    @Test
    public void shouldExecuteAndPrintResultForValidChildAddition() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("ADD_CHILD Satya Ketu Male");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("CHILD_ADDITION_SUCCEEDED");
    }

    @Test
    public void shouldExecuteAndPrintResultForPersonNotFound() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("ADD_CHILD Deepthi Ketu Male");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("PERSON_NOT_FOUND");
    }

    @Test
    public void shouldExecuteAndPrintResultForFailedChildAddition() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("ADD_CHILD Vich Ketu Male");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("CHILD_ADDITION_FAILED");
    }

    @Test
    public void shouldFindAndPrintSiblingsList() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Ish Siblings");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Chit Vich Aras Satya");
    }

    @Test
    public void shouldFindAndPrintSonsListForFatherName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Shan Son");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Chit Ish Vich Aras");
    }

    @Test
    public void shouldFindAndPrintDaughtersListForMotherName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Anga Daughter");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Satya");
    }

    @Test
    public void shouldFindAndPrintPaternalUncleForGivenPersonName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Kriya Paternal-Uncle");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Asva");
    }

    @Test
    public void shouldFindAndPrintMaternalUncleForGivenPersonName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Asva Maternal-Uncle");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Chit Ish Vich Aras");
    }

    @Test
    public void shouldFindAndPrintPaternalAuntForGivenPersonName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Vasa Paternal-Aunt");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Atya");
    }

    @Test
    public void shouldFindAndPrintMaternalAuntForGivenPersonName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Yodhan Maternal-Aunt");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Tritha");
    }

    @Test
    public void shouldFindAndPrintSistersOfHusbandAsSisterInLawForGivenPersonName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Lika Sister-In-Law");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Satya");
    }

    @Test
    public void shouldFindAndPrintWifeOfBrothersAsSisterInLawForGivenPersonName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Satya Sister-In-Law");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Amba Lika Chitra");
    }

    @Test
    public void shouldFindAndPrintBrothersOfWifeAsBrotherInLawForGivenPersonName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Vyan Brother-In-Law");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Chit Ish Vich Aras");
    }

    @Test
    public void shouldFindAndPrintBrothersOfHusbandAsBrotherInLawForGivenPersonName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Lika Brother-In-Law");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Chit Ish Aras");
    }

    @Test
    public void shouldFindAndPrintHusbandOfSistersAsBrotherInLawForGivenPersonName() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Vich Brother-In-Law");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("Vyan");
    }

    @Test
    public void shouldGiveNoneForBrotherInLawForGivenPersonNameWhoDoesNotHaveBrotherInLaw() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Yodhan Brother-In-Law");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("NONE");
    }

    @Test
    public void shouldGivePersonNotFoundForBrotherInLawForGivenPersonNameWhoDoesNotExistInFamilyTree() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("GET_RELATIONSHIP Yaan Brother-In-Law");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("PERSON_NOT_FOUND");
    }

    @Test
    public void shouldExecuteAndPrintResult() {
        Printer printer = mock(Printer.class);
        FileScanner scanner = mock(FileScanner.class);
        when(scanner.hasNext()).thenReturn(true, true, true, false);
        when(scanner.nextLine()).thenReturn("ADD_CHILD Satya Ketu Male", "GET_RELATIONSHIP Kriya Paternal-Uncle", "GET_RELATIONSHIP Satvy Brother-In-Law");
        FamilyApplication familyApplication = new FamilyApplication(printer, scanner);
        familyApplication.initialise();

        familyApplication.execute();

        verify(printer).print("CHILD_ADDITION_SUCCEEDED");
        verify(printer).print("Asva Ketu");
        verify(printer).print("Vyas Ketu");
    }
}