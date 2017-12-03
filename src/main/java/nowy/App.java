package nowy;

import searchengine.dao.UsersRepositoryDaoRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Hello world!
 *
 */


public class App 
{

    public static void main( String[] args ) throws NamingException {

        System.out.println( "Hello World!" );

        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", "true");
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        properties.put(Context.SECURITY_PRINCIPAL, "Stachu80");
        properties.put(Context.SECURITY_CREDENTIALS, "Piwo#1234");
        Context context = new InitialContext(properties);


        UsersRepositoryDaoRemote generator =
                (UsersRepositoryDaoRemote)
                        context.lookup("search-engine/UsersRepositoryDaoBean!searchengine.dao.UsersRepositoryDaoRemote");


        for (int i = 0; i < generator.getUsersName().size(); i++) {
            System.out.println(generator.getUsersName().get(i));
        }
        System.out.println(generator.getUsersName());
    }
}
