package Tests_Refactorizat;

import Database.DatabaseConnection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectionTest {

    @Test
    public void databaseConnectionTest() throws Exception {

        try (Connection connection = DatabaseConnection.getConnection()) {

            Assert.assertNotNull(
                    connection,
                    "Conexiunea la MySQL trebuie să funcționeze."
            );

            System.out.println("Conectare la MySQL reușită!");
        }
    }

    @Test
    public void verifyProductsExistTest() throws Exception {

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT * FROM Products"
             )) {

            Assert.assertTrue(
                    resultSet.next(),
                    "Tabelul Products trebuie să conțină cel puțin un produs."
            );

            System.out.println(
                    "Primul produs: "
                            + resultSet.getString("product_name")
            );
        }
    }

    @Test
    public void verifyProductPriceTest() throws Exception {

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT product_name, price FROM Products WHERE price > 100"
             )) {

            Assert.assertTrue(
                    resultSet.next(),
                    "Trebuie să existe cel puțin un produs cu prețul peste 100."
            );

            do {
                String productName = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");

                Assert.assertTrue(
                        price > 100,
                        "Prețul produsului trebuie să fie peste 100."
                );

                System.out.println(
                        "Produs: " + productName + " | Preț: " + price
                );

            } while (resultSet.next());
        }
    }

    @Test
    public void verifyCustomerExistsTest() throws Exception {

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT first_name, last_name, email FROM Customers"
             )) {

            Assert.assertTrue(
                    resultSet.next(),
                    "Trebuie să existe cel puțin un client în baza de date."
            );

            do {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                System.out.println(
                        "Client: " + firstName + " " + lastName
                                + " | Email: " + email
                );

            } while (resultSet.next());
        }
    }

    @Test
    public void verifyOrdersExistTest() throws Exception {

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT order_id, customer_id, product_id, quantity FROM Orders"
             )) {

            Assert.assertTrue(
                    resultSet.next(),
                    "Trebuie să existe cel puțin o comandă în baza de date."
            );

            do {
                int orderId = resultSet.getInt("order_id");
                int customerId = resultSet.getInt("customer_id");
                int productId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");

                Assert.assertTrue(
                        quantity > 0,
                        "Cantitatea comandată trebuie să fie mai mare decât zero."
                );

                System.out.println(
                        "Comanda: " + orderId
                                + " | Client ID: " + customerId
                                + " | Produs ID: " + productId
                                + " | Cantitate: " + quantity
                );

            } while (resultSet.next());
        }
    }

    @Test
    public void verifyOrderDetailsWithJoinTest() throws Exception {

        String sql = "SELECT Customers.first_name, Customers.last_name, " +
                "Products.product_name, Products.price, Orders.quantity " +
                "FROM Orders " +
                "JOIN Customers ON Orders.customer_id = Customers.customer_id " +
                "JOIN Products ON Orders.product_id = Products.product_id";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            Assert.assertTrue(
                    resultSet.next(),
                    "Comanda trebuie să aibă un client și un produs asociat."
            );

            do {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String productName = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                Assert.assertNotNull(firstName);
                Assert.assertNotNull(productName);
                Assert.assertTrue(price > 0);
                Assert.assertTrue(quantity > 0);

                System.out.println(
                        "Client: " + firstName + " " + lastName
                                + " | Produs: " + productName
                                + " | Preț: " + price
                                + " | Cantitate: " + quantity
                );

            } while (resultSet.next());
        }
    }

    @Test
    public void verifyOrderTotalTest() throws Exception {

        String sql = "SELECT Products.product_name, Products.price, " +
                "Orders.quantity, (Products.price * Orders.quantity) AS total " +
                "FROM Orders " +
                "JOIN Products ON Orders.product_id = Products.product_id";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            Assert.assertTrue(
                    resultSet.next(),
                    "Trebuie să existe cel puțin o comandă."
            );

            do {
                String productName = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                double total = resultSet.getDouble("total");

                Assert.assertEquals(
                        total,
                        price * quantity,
                        0.01,
                        "Totalul comenzii trebuie să fie corect."
                );

                System.out.println(
                        "Produs: " + productName
                                + " | Preț: " + price
                                + " | Cantitate: " + quantity
                                + " | Total: " + total
                );

            } while (resultSet.next());
        }
    }


    @Test
    public void verifyAllOrderQuantitiesTest() throws Exception {

        String sql = "SELECT COUNT(*) AS invalid_orders " +
                "FROM Orders WHERE quantity <= 0";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            Assert.assertTrue(
                    resultSet.next(),
                    "Interogarea trebuie să returneze un rezultat."
            );

            int invalidOrders = resultSet.getInt("invalid_orders");

            Assert.assertEquals(
                    invalidOrders,
                    0,
                    "Nu trebuie să existe comenzi cu o cantitate mai mică sau egală cu zero."
            );

            System.out.println(
                    "Număr comenzi cu cantitate invalidă: " + invalidOrders
            );
        }
    }



}
