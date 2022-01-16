package program;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String strConn = "jdbc:mariadb://localhost:3308/vpu911java";
        //InsertIntoDB(strConn);
        List<Product> list = SelectFromDB(strConn);
        PrintProductList(list);
        //UpdateForDB(strConn);
        DeleteFromDB(strConn);
        list = SelectFromDB(strConn);
        PrintProductList(list);

    }

    private static void PrintProductList(List<Product> prods) {
        for (Product p : prods) {
            System.out.println(p.toString());
        }
    }
    private static  void InsertIntoDB(String strConn) {
        try(Connection con = DriverManager.getConnection(strConn, "root", "")) {
            System.out.println("Successful connection");
            String query = "INSERT INTO `products` (`name`, `price`, `description`) " +
                    "VALUES (?, ?, ?);";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                String name, description;
                double price;
                System.out.print("Enter name: ");
                name = in.nextLine();
                System.out.print("Enter price: ");
                price = Double.parseDouble(in.nextLine());
                System.out.print("Enter description: ");
                description = in.nextLine();

                stmt.setString(1, name);
                stmt.setBigDecimal(2, new BigDecimal(price));
                stmt.setString(3, description);

                int rows = stmt.executeUpdate();
                System.out.println("Update rows: " +rows);

            }
            catch (Exception ex) {
                System.out.println("Error statements: " + ex.getMessage());
            }

        } catch (Exception ex) {
            System.out.println("Error connection: " + ex.getMessage());
        }

    }
    private static List<Product> SelectFromDB(String strConn) {
        try(Connection con = DriverManager.getConnection(strConn, "root", "")) {
            String selectSql = "SELECT * FROM products";
            try {
                PreparedStatement ps = con.prepareStatement(selectSql);
                ResultSet resultSet = ps.executeQuery();
                List<Product> products = new ArrayList<>();
                while (resultSet.next()) {
                    Product p = new Product(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getBigDecimal("price"),
                            resultSet.getString("description"));
                    products.add(p);
                }
                return products;
            } catch (Exception ex) {
                System.out.println("Error executeQuery: " + ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("Error connection: " + ex.getMessage());
        }
        return null;
    }

    private static void UpdateForDB(String strConn) {
        try(Connection con = DriverManager.getConnection(strConn, "root", "")) {
            String query = "UPDATE products SET name = ? WHERE id = ?";
            try(PreparedStatement stmt = con.prepareStatement(query)) {
                System.out.print("\nEnter id: ");
                int id = in.nextInt();
                System.out.print("Enter new name: ");
                in.nextLine();
                String name = in.nextLine();
                stmt.setString(1, name);
                stmt.setInt(2, id);

                int rows = stmt.executeUpdate();

                System.out.println("Successful update "+ rows);
            }
            catch (Exception ex) {
                System.out.println("Error update:" + ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("Error connection: " + ex.getMessage());
        }
    }

    private static void DeleteFromDB(String strConn) {
        SelectFromDB(strConn);
        try(Connection con = DriverManager.getConnection(strConn, "root", "")) {
            String query = "DELETE FROM products WHERE id = ?";
            try(PreparedStatement stmt = con.prepareStatement(query)) {
                System.out.print("Enter Id: ");
                int id = in.nextInt();
                stmt.setInt(1, id);
                int rows = stmt.executeUpdate();
                System.out.println("Successful delete " + rows);

            } catch (Exception ex) {
                System.out.println("Error delete: " + ex.getMessage());
            }

        } catch (Exception ex) {
            System.out.println("Error connection: " + ex.getMessage());
        }

    }
}
