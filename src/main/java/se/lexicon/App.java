package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.model.dto.UserCredentialsDTO;
import se.lexicon.model.entity.ApplicationRole;
import se.lexicon.model.entity.Person;
import se.lexicon.service.interfaces.PersonService;
import se.lexicon.service.interfaces.UserCredentialsService;

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


        UserCredentialsDTO dto = context.getBean(UserCredentialsService.class).findByUsername("nisse");
        System.out.println(dto.getUsername());


        context.close();
    }
}
