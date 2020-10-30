package com.efrei.st2ee.dao.impl;
import com.efrei.st2ee.dto.*;
import com.efrei.st2ee.dao.StudentDao;
import com.efrei.st2ee.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-24 21:57
 **/

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void insertStudent(Student student) {
        session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public int updateStudent(Student student) throws RuntimeException {
        session = sessionFactory.getCurrentSession();
        String queryString = "update Student set firstName=:firstName, lastName=:lastName, startDate=:startDate,endDate=:endDate,companyName=:companyName,charger=:charger,address=:address,noteCom=:noteCom,noteTech=:noteTech,studentGroup=:studentGroup,description=:description,comment=:comment where studentId=:studentId and tutor.tId=:tId";
        Query query = session.createQuery(queryString);
        query.setParameter("firstName", student.getFirstName());
        query.setParameter("lastName", student.getLastName());
        query.setParameter("startDate", student.getStartDate());
        query.setParameter("endDate", student.getEndDate());
        query.setParameter("companyName", student.getCompanyName());
        query.setParameter("charger", student.getCharger());
        query.setParameter("address", student.getAddress());
        query.setParameter("noteCom", student.getNoteCom());
        query.setParameter("noteTech", student.getNoteTech());
        query.setParameter("studentGroup", student.getStudentGroup());
        query.setParameter("description", student.getDescription());
        query.setParameter("comment", student.getComment());
        query.setParameter("studentId", student.getStudentId());
        query.setParameter("tId", student.getTutor().getTId());
        return query.executeUpdate();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public int updateStudentInternship(StudentInternshipExecution internshipExecution) {
        session = sessionFactory.getCurrentSession();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update Student set ");
        for (int i = 0; i < internshipExecution.getCheckedList().size(); i++){
            stringBuilder.append(internshipExecution.getNameList().get(i));
            stringBuilder.append("=");
            stringBuilder.append(internshipExecution.getCheckedList().get(i));
            if (i != internshipExecution.getCheckedList().size()-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" where studentId=");
        stringBuilder.append(internshipExecution.getStudentId());
        String queryString = stringBuilder.toString();
        Query query = session.createQuery(queryString);
        return query.executeUpdate();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class, readOnly = true)
    public List<Student> selectAllStudents(Integer tId) {
        session = sessionFactory.getCurrentSession();
        String queryString = "from Student where tutor.tId=?1";
        Query query = session.createQuery(queryString).setParameter(1, tId);
        List list = query.getResultList();
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class, readOnly = true)
    public Student selectStudent(Integer studentId, Integer tId) {
        session = sessionFactory.getCurrentSession();
        String queryString = "from Student where tutor.tId=?1 and studentId=?2";
        Query query = session.createQuery(queryString);
        query.setParameter(1, tId);
        query.setParameter(2, studentId);
        List<Student> studentList = (List<Student>) query.getResultList();
        return studentList.isEmpty()?null:studentList.get(0);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class, readOnly = true)
    public List<Student> selectStudentsByKeyWord(String keyWord, Integer tId) {
        session = sessionFactory.getCurrentSession();
        String queryString = "from Student where tutor.tId = :tId and (lower(lastName) like lower(:keyWord)  or lower(firstName ) like lower(:keyWord) or studentGroup=:group)";
        Query query = session.createQuery(queryString).setParameter("keyWord", '%' + keyWord + '%').setParameter("tId", tId).setParameter("group", keyWord);
        List list = query.getResultList();

        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class, readOnly = true)
    public List<Student> selectStudentsByYear(Integer year, Integer tId) {
        session = sessionFactory.getCurrentSession();
        String queryString = "from Student as student where tutor.tId = :tId and YEAR(startDate)=:startDate";
        Query query = session.createQuery(queryString).setParameter("startDate", year).setParameter("tId", tId);
        List list = query.getResultList();
        return list;
    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class, readOnly = true)
//    public List<Student> selectStudentsByGroup(String group, Integer tId) {
//        session = sessionFactory.getCurrentSession();
//        String queryString = "from Student where tutor.tId = :tId and studentGroup=:group";
//        Query query = session.createQuery(queryString).setParameter("group", group).setParameter("tId", tId);
//        List list = query.getResultList();
//        return list;
//    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteStudent(Integer studentId, Integer tId) {
        session = sessionFactory.getCurrentSession();
        String queryString = "delete from Student where tutor.tId=?1 and studentId=?2";
        Query query = session.createQuery(queryString).setParameter(1, tId).setParameter(2, studentId);
        int res = query.executeUpdate();
        return res;
    }


}
