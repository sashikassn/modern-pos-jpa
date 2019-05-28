package lk.ijse.pos.db;

import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.entity.OrderDetail;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAUtil {

    private static EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){

        File propFile = new File("resources/application.properties");
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader(propFile);
            properties.load(fileReader);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit1", properties);
            fileReader.close();

            return emf;

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger("lk.ijse.pos.db").log(Level.SEVERE, null, e);
            System.exit(0);
            return null;
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

}
