package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.model.entity.Person;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        PersonDAO personDAO = context.getBean(PersonDAO.class);

        System.out.println(personDAO.persist(new Person(1, "Erik", "Svensson", "erik.svensson@lexicon.se", null)));

        context.close();
    }
}
