package day2.lineage;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class LineageTest {

    Person person = null;

    Random random = new Random();

    @Before
    public void setup() {
        person = Person.newMale("King shan");
    }

    @Test
    public void testGetMarried() {
        try {
            Person queen = Person.newFemale("Queen");
            person.getMarried(queen);
            assertEquals(person.getSpouse(), queen);
            assertEquals(queen.getSpouse(), person);
        } catch (Person.PersonException ex) {
            fail(ex.getMessage());
        }
    }


    @Test(expected = Person.SameGenderMarriageException.class)
    public void testGetMarriedSameGenderCase() throws Person.PersonException {
        person.getMarried(Person.newMale("King"));
    }

    @Test(expected = Person.AlreadyMarriedException.class)
    public void testGetMarriedAlreadyMarriedCase() throws Person.PersonException {
        person.getMarried(Person.newFemale("Queen1"));
        person.getMarried(Person.newFemale("Queen2"));
    }

    @Test
    public void testGiveBirth() {
        try {
            Person queen = Person.newFemale("Queen");
            Person jack = Person.newMale("Jack");

            int beforeCount = person.getChildren().size();

            person.getMarried(queen);
            person.giveBirth(jack);

            assertEquals(person.getChildren().size(), beforeCount + 1);
            assertEquals(queen.getChildren().size(), beforeCount + 1);

            assertNotNull(jack.getParent());
        } catch (Person.PersonException ex) {
            fail(ex.getMessage());
        }
    }

    @Test(expected = Person.NoSpouseFoundException.class)
    public void testGiveBirthWithoutSpouse() throws Person.PersonException {
        person.giveBirth(Person.newMale("Jack"));
    }

    @Test(expected = Person.AlreadyBornException.class)
    public void testGiveBirthToAlreadyBornChildCase() throws Person.PersonException{
        person.getMarried(Person.newFemale("Queen"));

        Person jack = Person.newMale("Jack");
        person.giveBirth(jack);

        person.giveBirth(jack);
    }

    @Test
    public void testGiveBirthTo2Children() throws Person.PersonException {
        person.getMarried(Person.newFemale("Queen"));
        person.giveBirth(Person.newMale("Jack"));
        person.giveBirth(Person.newFemale("Jill"));

        assertEquals("Children count mismatch",person.getChildren().size(),2);
        assertEquals("Spouse Children count mismatch",person.getSpouse().getChildren().size(),2);
    }

    @Test
    public void testGetSiblings() throws Person.PersonException {
        person.getMarried(Person.newFemale("Queen"));
        Person jack = Person.newMale("Jack");

        person.giveBirth(jack);
        for (int i = 0; i < 100; i++) person.giveBirth(getRandomPerson());

        List<Person> siblings = jack.getSiblings();
        for (Person child: siblings)  {
            assertNotEquals("Jack should not be included in siblings", child, jack);
            assertEquals("Parent mismatch", child.getParent(), person);
        }
    }

    @Test(expected = Person.NoParentFoundException.class)
    public void testGetSiblingsNoParent() throws Person.NoParentFoundException {
        getRandomPerson().getSiblings();
    }

    @Test
    public void testGetBrothers() throws Person.PersonException {
        person.getMarried(Person.newFemale("Queen"));
        Person jack = Person.newMale("Jack");

        person.giveBirth(jack);
        for (int i = 0; i < 100; i++) person.giveBirth(getRandomPerson());

        List<Person> siblings = jack.getBrothers();
        for (Person child: siblings)  {
            assertNotEquals("Jack should not be included in siblings", child, jack);
            assertEquals("Parent mismatch", child.getParent(), person);
            assertTrue("Gender mismatch", child.isMale());
        }
    }

    @Test
    public void testGetSisters() throws Person.PersonException {
        person.getMarried(Person.newFemale("Queen"));
        Person jill = Person.newMale("Jill");

        person.giveBirth(jill);
        for (int i = 0; i < 100; i++) person.giveBirth(getRandomPerson());

        List<Person> siblings = jill.getSisters();
        for (Person child: siblings)  {
            assertNotEquals("Jill should not be included in siblings", child, jill);
            assertEquals("Parent mismatch", child.getParent(), person);
            assertTrue("Gender mismatch", child.isFemale());
        }
    }

    @Test
    public void testGetSons() throws Person.PersonException {
        person.getMarried(Person.newFemale("Queen"));
        for (int i = 0; i < 100; i++) person.giveBirth(getRandomPerson());
        for (Person child: person.getSons())  assertEquals("Gender mismatch", child.getGender(), Person.Gender.MALE);
    }

    @Test
    public void testGetDaughters() throws Person.PersonException {
        person.getMarried(Person.newFemale("Queen"));
        for (int i = 0; i < 100; i++) person.giveBirth(getRandomPerson());
        for (Person child: person.getDaughters())  assertEquals("Gender mismatch", child.getGender(), Person.Gender.FEMALE);
    }


    @Test
    public void testGetBrotherInLaws() throws Person.PersonException {
        person.getMarried(Person.newFemale("Queen"));



        for (int i = 0; i < 100; i++) person.giveBirth(getRandomPerson());
        for (Person child: person.getDaughters())  assertEquals("Gender mismatch", child.getGender(), Person.Gender.FEMALE);
    }

    @Test
    public void testGetSisterInLaws() throws Person.PersonException {
        person.getMarried(Person.newFemale("Queen"));
        for (int i = 0; i < 100; i++) person.giveBirth(getRandomPerson());
        for (Person child: person.getDaughters())  assertEquals("Gender mismatch", child.getGender(), Person.Gender.FEMALE);
    }


    private Person getRandomPerson(){
        String name = "Name" + random.nextInt(100);
        return random.nextBoolean() ? Person.newMale(name) : Person.newFemale(name);
    }

    private Person getTestData() throws Person.PersonException{
        Person kingShan = Person.newMale("King shan");
        Person queenAnga = Person.newFemale("Queen Anga");

        kingShan.getMarried(queenAnga);

        Person chit = Person.newMale("Chit");
        Person amba = Person.newFemale("Amba");
        Person ish = Person.newMale("Ish");
        Person vich = Person.newMale("Vich");
        Person lika = Person.newFemale("Lika");
        Person aras = Person.newMale("Aras");
        Person chitra = Person.newFemale("Chitra");
        Person satya = Person.newFemale("Satya");
        Person vyan = Person.newMale("Vyan");

        kingShan.giveBirth(chit);
        kingShan.giveBirth(ish);
        kingShan.giveBirth(aras);
        kingShan.giveBirth(vich);
        kingShan.giveBirth(satya);

        chit.getMarried(amba);
        vich.getMarried(lika);
        aras.getMarried(chitra);
        satya.getMarried(vyan);

        Person dritha = Person.newFemale("Dritha");
        Person jaya = Person.newMale("Jaya");
        Person tritha = Person.newFemale("Tritha");
        Person vritha = Person.newMale("Vritha");
        Person vila = Person.newFemale("Vila");
        Person chika = Person.newFemale("Chika");
        Person arit = Person.newMale("Arit");
        Person jnki = Person.newFemale("Jnki");
        Person ahit = Person.newMale("Ahit");
        Person salvi = Person.newFemale("Salvi");
        Person asva = Person.newMale("Asva");
        Person krpi = Person.newFemale("Krpi");
        Person vyas = Person.newMale("Vyas");
        Person atya = Person.newFemale("Atya");

        chit.giveBirth(dritha);
        chit.giveBirth(tritha);
        chit.giveBirth(vritha);

        vich.giveBirth(vila);
        vich.giveBirth(chika);

        Person yodhan = Person.newMale("Yodhan");
        Person laki = Person.newMale("Laki");
        Person lavanya = Person.newFemale("Lavanya");
        Person vasa = Person.newMale("Vasa");
        Person kriya = Person.newMale("Kriya");
        Person krithi = Person.newFemale("Krithi");

        return kingShan;

    }

}
