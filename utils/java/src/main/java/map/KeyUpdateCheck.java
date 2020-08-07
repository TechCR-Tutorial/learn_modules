package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class KeyUpdateCheck {

    public static void main(String[] args) {
        Person personOne = new Person("Chamly", "36");
        Person personTwo = new Person("Idunil", "30");

        Map<Person, String> map = new HashMap<>();
        map.put(personOne, "ONE");
        map.put(personTwo, "TWO");

        personOne.setAge("35");
        String value = map.get(personOne);
        System.out.println(value);

        Person keyPerson = map.entrySet().stream().map(entry -> entry.getKey())
            .filter(person -> Objects.equals(person, personOne)).findFirst().get();
        keyPerson.setAge("45");
        value = map.get(keyPerson);
        System.out.println(value);

        map.forEach((key, value1) -> System.out.println(key.toString()));
    }


    public static class Person {
        String name;
        String age;

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Person person = (Person) o;

            if (name != null ? !name.equals(person.name) : person.name != null) {
                return false;
            }
            return age != null ? age.equals(person.age) : person.age == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (age != null ? age.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
        }
    }

}
