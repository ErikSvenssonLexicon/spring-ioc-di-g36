package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.model.entity.ApplicationRole;
import se.lexicon.model.entity.Person;
import se.lexicon.service.interfaces.PersonService;

import java.util.stream.Stream;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);


        PersonService personService = context.getBean(PersonService.class);


        Person person = personService.create(
                "nisse",
                "123",
                ApplicationRole.APP_USER,
                "Nils",
                "Svensson",
                "nisse@gmail.com");

        System.out.println(person);
        System.out.println(person.getUserCredentials());


        context.close();
    }
}
