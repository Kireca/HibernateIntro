import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school_db");


        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student("Kiro");
        entityManager.persist(student);


       final Student found = entityManager.find(Student.class, 1);

        System.out.println(found.getId() + " " + found.getName());

        entityManager.remove(found);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
