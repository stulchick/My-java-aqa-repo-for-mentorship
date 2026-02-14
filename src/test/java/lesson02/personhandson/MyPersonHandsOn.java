package lesson02.personhandson;

import com.lesson02.models.Person;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyPersonHandsOn {

    @Test
    public void setPersonData() {

        Person myPersonEmptyConstractor = new Person(); // all data need to be filled with set
        Person myPersonFullConstractor = new Person("Vlad", 12, "email@email.com"); // all data prefilled, but easy to forgot smth
        Person myPersonFromBuilder = Person.builder().name("John").age(13).email("john@email.com").build(); // readability, all data dreaven by @builder


        myPersonEmptyConstractor.setName("Danylo");
        myPersonEmptyConstractor.setEmail("email@email.com");
        myPersonEmptyConstractor.setAge(12);

        boolean result = myPersonEmptyConstractor.equals(myPersonFromBuilder);
        Assert.assertTrue(result, "Not same"); // cannot use once @Data removed from Person Class, so no getters, no setters, no equals, no hashCode, no toString, no requiredArgsConstructor
        String name = myPersonEmptyConstractor.getName();

    }
}
