package day2.lineage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {

    static class PersonException extends Exception {
        PersonException(String msg) {
            super(msg);
        }
    }

    static class AlreadyMarriedException extends PersonException {
        AlreadyMarriedException() {
            super("AlreadyMarriedException");
        }
    }

    static class SameGenderMarriageException extends PersonException {
        SameGenderMarriageException() {
            super("SameGenderMarriageException");
        }
    }

    static class NoSpouseFoundException extends PersonException {
        NoSpouseFoundException() {
            super("NoSpouseFoundException");
        }
    }

    static class AlreadyBornException extends PersonException {
        AlreadyBornException() {
            super("AlreadyBornException");
        }
    }

    static class NoParentFoundException extends PersonException {
        NoParentFoundException() {
            super("NoParentFoundException");
        }
    }

    enum Gender {MALE, FEMALE;}

    private String name;
    private Gender gender;

    private Person parent;
    private Person spouse;

    private List<Person> children = new ArrayList<>();

    static Person newMale(String name) {
        return new Person(name, Gender.MALE);
    }

    static Person newFemale(String name) {
        return new Person(name, Gender.FEMALE);
    }

    Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }


    public void getMarried(Person spouse) throws PersonException {
        if (null != this.spouse)
            throw new AlreadyMarriedException();

        if (spouse.gender == gender) {
            throw new SameGenderMarriageException();
        }

        this.spouse = spouse;
        spouse.spouse = this;
    }

    public void giveBirth(Person child) throws PersonException {
        if (this.spouse == null) throw new NoSpouseFoundException();
        if (child.parent != null) throw new AlreadyBornException();

        children.add(child);
        spouse.children.add(child);

        child.parent = this;
    }

    public List<Person> getSiblings() throws NoParentFoundException {
        if (parent == null) throw new NoParentFoundException();
        List<Person> children = new ArrayList<>(parent.getChildren());
        children.remove(this);
        return children;
    }

    public List<Person> getSons() {
        return children.stream().filter(Person::isMale).collect(Collectors.toList());
    }

    public List<Person> getDaughters() {
        return children.stream().filter(Person::isFemale).collect(Collectors.toList());
    }

    public List<Person> getBrothers() throws PersonException {
        return getSiblings().stream().filter(Person::isMale).collect(Collectors.toList());
    }

    public List<Person> getSisters() throws PersonException {
        return getSiblings().stream().filter(Person::isFemale).collect(Collectors.toList());
    }


    public Gender getGender() {
        return gender;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Person getParent() {
        return parent;
    }

    public Person getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return gender == Gender.MALE;
    }

    public boolean isFemale() {
        return gender == Gender.FEMALE;
    }

}