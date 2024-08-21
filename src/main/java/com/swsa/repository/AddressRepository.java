package com.swsa.repository;

import com.swsa.model.Address;
import com.swsa.service.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class AddressRepository {
        private static Connection connection=null;
        /*
        private Connection connection;

        public AddressRepository() {
            try {
                // Assuming you're using MySQL
                Class.forName("com.mysql.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystems", "root", "Prakash@123");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
*/
        private void initConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                connection = new ConnectionService().getConnection();
            }
        }

        public boolean insertAddress(Address address) throws SQLException {
            this.initConnection();

            String query = "INSERT INTO address VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setLong(1, address.getId());
                preparedStatement.setString(2, address.getStreet());
                preparedStatement.setString(3, address.getCity());
                preparedStatement.setString(4, address.getState());
                preparedStatement.setString(5, address.getCountry());
                preparedStatement.setLong(6, address.getPostalCode());

                System.out.println("inserting address object to address table: " + address);

                int rowsInserted = preparedStatement.executeUpdate();

                return rowsInserted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        public List<Address> retrieveAddress() {
            System.out.println("Inside retrieve address repo layer");
            List<Address> addresses = new ArrayList<>();
            // Use the connection to execute SQL queries and interact with the database
            try {
                this.initConnection();

                // Your database operations here...
                Statement statement = connection.createStatement();
                System.out.println("Inside retrieve address repo layer before db call");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM address");
                System.out.println("Inside retrieve address repo after db call layer"+ resultSet);

                // Iterate over the result set
                while (resultSet.next()) {
                    long id = resultSet.getLong("id"); // Replace "id" with your actual column name
                    String city = resultSet.getString("city"); // Replace "city" with your actual column name
                    String street = resultSet.getString("street");
                    String state = resultSet.getString("state");
                    String country = resultSet.getString("country");
                    long postal_code = resultSet.getLong("postal_code");

                    // Do something with the data, e.g., print it
                    Address address = new Address(id, street, city,  state,  country, postal_code);
                    addresses.add(address);
                }
            } catch (SQLException e) {
                System.err.println("SQL error: " + e.getMessage());
            } finally {
                // Close the connection when done
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.err.println("Error closing connection: " + e.getMessage());
                    }
                }
            }
            System.out.println("Inside retrieve address repo layer before return" + addresses);
            return addresses;
        }
    }

