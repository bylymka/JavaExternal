package epam.task7.web.jdbc.dao;

import epam.task7.web.model.City;
import epam.task7.web.jdbc.enum_queries.CitySQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO implements DAO<City, Integer>
{
    private  final Connection connection;

    public CityDAO(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public void createRecord(final City city)
    {
        try(PreparedStatement statement = connection.prepareStatement(CitySQLQueries.INSERT_RECORD.getQuery());)
        {
            statement.setString(1, city.getName());
            statement.setString(2, city.getFoundationYear());
            statement.setInt(3, city.getSquare());
            statement.setInt(4, city.getPopulation());
            statement.setString(5, city.getCountry());
            statement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public City readRecord(Integer id)
    {
        City city = null;
        try(PreparedStatement statement = connection.prepareStatement(CitySQLQueries.GET_RECORD.getQuery()))
        {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                city = new City();
                city.setId(rs.getInt("ID"));
                city.setName(rs.getString("Name"));
                city.setFoundationYear(rs.getString("FoundationYear"));
                city.setSquare(rs.getInt("Square"));
                city.setPopulation(rs.getInt("Population"));
                city.setCountry(rs.getString("Country"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return city;
    }

    @Override
    public void updateRecord(Integer id)
    {
        City city = new City();

        try(PreparedStatement statement = connection.prepareStatement(CitySQLQueries.UPDATE_RECORD.getQuery()))
        {
            statement.setString(1, city.getName());
            statement.setString(2, city.getFoundationYear());
            statement.setInt(3, city.getSquare());
            statement.setInt(4, city.getPopulation());
            statement.setString(5, city.getCountry());
            statement.setInt(6, id);
            statement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRecord(Integer id)
    {
        try(PreparedStatement statement = connection.prepareStatement(CitySQLQueries.DELETE_RECORD.getQuery()))
        {
            statement.setInt(1, id);
            statement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
