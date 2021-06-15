package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ApplicationConfig;
import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.model.entity.Person;

import java.util.stream.Stream;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.scan("se.lexicon.config");



        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

        PersonDAO personDAO = context.getBean(PersonDAO.class);

        System.out.println(
                personDAO.persist(new Person(1, "Erik", "Svensson", "erik.svensson@lexicon.se", null))
        );

        context.close();
    }
}
