package ma.ensa.services;

import ma.ensa.OrderSync.Order;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private static final String INPUT_FILE = "resources/data/input.json";
    private static final String OUTPUT_FILE = "resources/data/output.json";
    private static final String ERROR_FILE = "resources/data/error.json";

    public void parseJsonThread() {
        new Thread(() -> {
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
                
                List<Order> orders = mapper.readValue(new File(INPUT_FILE), new TypeReference<List<Order>>(){});

                for (Order order : orders) {
                    processOrder(order, mapper);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void processOrder(Order order, ObjectMapper mapper) {
        try (Connection conn = DatabaseService.getConnection()) {
            String query = "SELECT id FROM customer WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, order.getCustomerId());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                addOrderToDatabase(order, conn);
                appendToJsonFile(order, OUTPUT_FILE);
            } else {
                appendToJsonFile(order, ERROR_FILE);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addOrderToDatabase(Order order, Connection conn) throws SQLException {
        String checkQuery = "SELECT id FROM `order` WHERE id = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
        checkStmt.setInt(1, order.getId());
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            System.out.println("Order with ID " + order.getId() + " already exists.");
        } else {
            String insertQuery = "INSERT INTO `order` (id, date, amount, customer_id) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, order.getId());
            insertStmt.setString(2, String.valueOf(System.currentTimeMillis()));
            insertStmt.setDouble(3, order.getAmount());
            insertStmt.setInt(4, order.getCustomerId());
            insertStmt.executeUpdate();
        System.out.println("Order with ID " + order.getId() + " added to database.");
    }
}
    private void appendToJsonFile(Order order, String filePath) throws IOException {
        File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        List<Order> orders;

        if (file.exists() && file.length() > 0) {
            orders = mapper.readValue(file, new TypeReference<List<Order>>(){});
        } else {
            orders = new ArrayList<>();
        }

        orders.add(order);

        mapper.writeValue(file, orders);
    }

}
