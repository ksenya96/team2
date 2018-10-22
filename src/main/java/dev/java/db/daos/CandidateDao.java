package dev.java.db.daos;

import dev.java.db.model.Candidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateDao extends AbstractDao<Candidate> {

    private static String SQL_SELECT_BY_ID = "SELECT * FROM candidate AS c WHERE c.id=?";

    private final String SQL_SELECT_SORTED_FILTERING_PAGE = "SELECT * FROM candidate AS c WHERE ?=? " +
            "ORDER BY ? ASC LIMIT ?, ?";

    public CandidateDao(Connection connection) {
        super(connection);
        SQL_SELECT_SORTED_PAGE = "SELECT * FROM candidate AS c ORDER BY ? ASC LIMIT ?, ?";
        SQL_INSERT = "INSERT INTO candidate " +
                "(name, surname, birthday, salary_in_dollars, candidate_state) " +
                "VALUES (?, ?, ?, ?, ?)";
        SQL_UPDATE = "UPDATE candidate " +
                "SET name=?, surname=?, birthday=?, salary_in_dollars=?, candidate_state=? " +
                "WHERE id=?";
    }


    public Candidate getEntityById(long id) throws SQLException {
        try (PreparedStatement getByIdPrepareStatement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            getByIdPrepareStatement.setLong(1, id);
            ResultSet entity = getByIdPrepareStatement.executeQuery();
            if (entity.next()) {
                Candidate candidate = setEntityFields(entity);
                entity.close();
                return candidate;
            }
            return null;
        }
    }


    @Override
    protected void setValuesForInsertIntoPrepareStatement(PreparedStatement prepareStatement, Candidate candidate)
            throws SQLException {
        prepareStatement.setString(1, candidate.getName());
        prepareStatement.setString(2, candidate.getSurname());
        prepareStatement.setDate(3, candidate.getBirthday());
        prepareStatement.setFloat(4, candidate.getSalaryInDollars());
        prepareStatement.setString(5, candidate.getCandidateState());
    }

    @Override
    protected void setValuesForUpdateIntoPrepareStatement(PreparedStatement prepareStatement, Candidate candidate)
            throws SQLException {
        setValuesForInsertIntoPrepareStatement(prepareStatement, candidate);
        prepareStatement.setLong(6, candidate.getId());

    }

    @Override
    protected Candidate setEntityFields(ResultSet candidateTableRow) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(candidateTableRow.getLong("id"));
        candidate.setName(candidateTableRow.getString("name"));
        candidate.setSurname(candidateTableRow.getString("surname"));
        candidate.setBirthday(candidateTableRow.getDate("birthday"));
        candidate.setSalaryInDollars(candidateTableRow.getFloat("salary_in_dollars"));
        candidate.setCandidateState(candidateTableRow.getString("candidate_state"));
        return candidate;
    }
}
