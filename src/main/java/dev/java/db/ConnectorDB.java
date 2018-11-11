package dev.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class ConnectorDB {
    private ConnectorDB() {

    }

    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        return DriverManager.getConnection(url, user, pass);
    }

    public static void main(String[] args) throws SQLException {
        /*Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Candidate candidate = new Candidate();
        candidate.setName("Sergey");
        candidate.setSurname("Zyazyulkin");
        CandidateExperience candidateExperience = new CandidateExperience();
        CandidateExperience.CandidateExperiencePK id = candidateExperience.new CandidateExperiencePK();
        id.setDateFrom(new Date(3918, 11, 10));
        id.setDateTo(new Date(3919, 11, 11));
        candidateExperience.setId(id);
        List<CandidateExperience> candidateExperienceList = new ArrayList<>();
        candidateExperienceList.add(candidateExperience);
        candidate.setExperiences(candidateExperienceList);

        session.save(candidate);
        session.getTransaction().commit();

        HibernateSessionFactory.shutdown();*/

    }
}

