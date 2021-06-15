package se.lexicon;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.model.entity.ApplicationRole;
import se.lexicon.model.entity.Person;
import se.lexicon.service.interfaces.PersonService;

import java.util.stream.Stream;

public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        PersonService personService = context.getBean(PersonService.class);

        System.out.println(
                personService.create("nisse", "nisse123", ApplicationRole.APP_USER, "Nils", "Nilsson", "nils@gmail.com")
        );

        context.close();
    }
}
