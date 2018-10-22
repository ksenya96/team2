package dev.java.db.daos;

import dev.java.db.model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillDao extends AbstractDao<Skill> {
    private final String SQL_INSERT =
            "INSERT INTO skill " +
                    "(name) " +
                    "VALUES (?)";

    private final String SQL_UPDATE =
            "UPDATE skill " +
                    "SET name=? " +
                    "WHERE name=?";

    private final String SQL_SELECT_BY_NAME = "SELECT * FROM skill AS s WHERE s.name=?";

    private final String SQL_SELECT_ALL = "SELECT * FROM skill";

    public SkillDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean createEntity(Skill entity) throws SQLException {
        try (PreparedStatement insertPrepareStatement = connection.prepareStatement(SQL_INSERT)) {
            setValuesForInsertIntoPrepareStatement(insertPrepareStatement, entity);
            int status =  insertPrepareStatement.executeUpdate();
            return status > 0;
        }
    }

    @Override
    public boolean updateEntity(Skill entity) throws SQLException {
        try (PreparedStatement updatePrepareStatement = connection.prepareStatement(SQL_UPDATE)) {
            setValuesForUpdateIntoPrepareStatement(updatePrepareStatement, entity);
            return updatePrepareStatement.executeUpdate() > 0;
        }
    }

    public Skill getEntityByName(String name) throws SQLException {
        try (PreparedStatement getByIdPrepareStatement = connection.prepareStatement(SQL_SELECT_BY_NAME)) {
            getByIdPrepareStatement.setString(1, name);
            ResultSet entity = getByIdPrepareStatement.executeQuery();
            if (entity.next()) {
                Skill skill = setEntityFields(entity);
                entity.close();
                return skill;
            }
            return null;
        }
    }

    @Override
    protected void setValuesForInsertIntoPrepareStatement(PreparedStatement prepareStatement, Skill skill)
            throws SQLException {
        prepareStatement.setString(1, skill.getName());
    }

    @Override
    protected void setValuesForUpdateIntoPrepareStatement(PreparedStatement prepareStatement, Skill skill)
            throws SQLException {
        setValuesForInsertIntoPrepareStatement(prepareStatement, skill);
        prepareStatement.setString(2, skill.getName());

    }

    @Override
    protected Skill setEntityFields(ResultSet candidateTableRow) throws SQLException {
        Skill skill = new Skill();
        skill.setName(candidateTableRow.getString("name"));
        return skill;
    }
}
