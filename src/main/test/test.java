import com.efrei.st2ee.entity.Student;
import com.efrei.st2ee.entity.Tutor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-24 17:37
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {

    @Resource
    SessionFactory sessionFactory;

    Session session;

    @Before
    public void init(){
        session = sessionFactory.openSession();
    }

    @Test
    public void test() {
        Tutor tutor = new Tutor();
        Set<Student> students = new HashSet<>();

        Student student = new Student();
        student.setAddress("112 boulevard of jk");
        student.setFirstName("Blues");
        student.setLastName("Lee");
        student.setCompanyName("Wei");
        student.setCharger("Kevein");
        student.setTutor(tutor);
        student.setEndDate(LocalDate.now());
        student.setStartDate(LocalDate.now());

        students.add(student);
        tutor.setTName("Peter");
        tutor.setStudentSet(students);

        session.save(tutor);


        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void testSerche(){

        String queryString = "from Student as student where YEAR(startDate)=:startDate";

        Query query =  session.createQuery(queryString);
        query.setParameter("startDate",2020);
        List list = query.getResultList();

        session.close();
        list.forEach(System.out::println);
    }


}
