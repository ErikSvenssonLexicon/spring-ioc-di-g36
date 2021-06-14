package se.lexicon;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.model.entity.Person;

public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        PersonDAO personDAO = context.getBean(PersonDAO.class);

        System.out.println(personDAO.persist(new Person(
                1, "Erik", "Svensson", "erik.svensson@lexicon.se", null
        )));



        context.close();
    }
}
