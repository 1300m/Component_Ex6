/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;
import model.StudentTable;

/**
 *
 * @author 64050355 Jirapat Pichai
 */
public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Student std1 = new Student(1, "Jirapat", 3.5);
        //Student std2 = new Student(2, "Tanapat", 3.25);
        //StudentTable.insertStudent(std1);
        //StudentTable.insertStudent(std2);
        Student std;
        std = StudentTable.findStudentById(2);
        if (std != null) {
            std.setName("Pichai");
            StudentTable.updateStudent(std);
        }
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
