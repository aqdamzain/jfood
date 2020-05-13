package aqdam.jfood.dao;

import aqdam.jfood.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * for query execution of table invoice in database
 */
public class DatabaseInvoicePostgre {

    /**
     * get id of invoice that latest inserted to database
     * @return id of invoice
     */
    public static int getLastInvoiceId() {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        int lastId = 0;
        try {
            statement = connection.createStatement();
            String query = "select id from invoice order by id desc limit 1";
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                lastId = result.getInt("id");
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastId;
    }

    /**
     * get all invoice object from database
     * @return list of invoice object
     * @throws SQLException throws exception if query goes wrong
     */
    public static ArrayList<Invoice> getAllInvoice() throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        Invoice invoice = null;
        ArrayList<Invoice> invoices = new ArrayList<>();
        String query = "select * from invoice";
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            switch (PaymentType.valueOf(result.getString("invoice_type"))) {
                case Cash:
                    invoice = new CashInvoice(result.getInt("id"),
                            getFoodOrder(result.getInt("id")),
                            DatabaseCustomerPostgre.getCustomerById(result.getInt("customer_id")),
                            result.getInt("delivery_fee")
                    );
                    invoice.setInvoiceStatus(InvoiceStatus.valueOf(result.getString("invoice_status")));
                    invoice.setTotalPrice();
                    invoice.setDate(result.getTimestamp("date"));
                    invoices.add(invoice);
                    break;
                case Cashless:
                    invoice = new CashlessInvoice(result.getInt("id"),
                            getFoodOrder(result.getInt("id")),
                            DatabaseCustomerPostgre.getCustomerById(result.getInt("customer_id")),
                            DatabasePromoPostgre.getPromoById(result.getInt("promo_id"))
                    );
                    invoice.setInvoiceStatus(InvoiceStatus.valueOf(result.getString("invoice_status")));
                    invoice.setTotalPrice();
                    invoice.setDate(result.getTimestamp("date"));
                    invoices.add(invoice);
                    break;
            }
        }
        statement.close();
        connection.close();
        return invoices;
    }

    /**
     * get invoice from database based on id of customer that has invoice
     * @param customerId id of the customer
     * @return list of invoice that customer has
     * @throws SQLException trows exception if query goes wrong
     */
    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        Invoice invoice = null;
        ArrayList<Invoice> invoices = new ArrayList<>();
        String query = "select * from invoice where " +
                "customer_id='" + customerId + "'";
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            switch (PaymentType.valueOf(result.getString("invoice_type"))) {
                case Cash:
                    invoice = new CashInvoice(result.getInt("id"),
                            getFoodOrder(result.getInt("id")),
                            DatabaseCustomerPostgre.getCustomerById(result.getInt("customer_id")),
                            result.getInt("delivery_fee")
                    );
                    invoice.setInvoiceStatus(InvoiceStatus.valueOf(result.getString("invoice_status")));
                    invoice.setTotalPrice();
                    invoice.setDate(result.getTimestamp("date"));
                    invoices.add(invoice);
                    break;
                case Cashless:
                    invoice = new CashlessInvoice(result.getInt("id"),
                            getFoodOrder(result.getInt("id")),
                            DatabaseCustomerPostgre.getCustomerById(result.getInt("customer_id")),
                            DatabasePromoPostgre.getPromoById(result.getInt("promo_id"))
                    );
                    invoice.setInvoiceStatus(InvoiceStatus.valueOf(result.getString("invoice_status")));
                    invoice.setTotalPrice();
                    invoice.setDate(result.getTimestamp("date"));
                    invoices.add(invoice);
                    break;
            }
        }
        statement.close();
        connection.close();
        return invoices;
    }

    /**
     * get invoice based on id that invoice has
     * @param id id of invoice
     * @return invoice object
     * @throws SQLException throws exception if query goes wrong
     */
    public static Invoice getInvoiceById(int id) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        Invoice invoice = null;
        String query = "select * from invoice where " +
                "id='" + id + "' " +
                "limit 1";
        ResultSet result = statement.executeQuery(query);
        if (result.next()) {
            switch (PaymentType.valueOf(result.getString("invoice_type"))) {
                case Cash:
                    invoice = new CashInvoice(result.getInt("id"),
                            getFoodOrder(result.getInt("id")),
                            DatabaseCustomerPostgre.getCustomerById(result.getInt("customer_id")),
                            result.getInt("delivery_fee")
                    );
                    invoice.setInvoiceStatus(InvoiceStatus.valueOf(result.getString("invoice_status")));
                    invoice.setTotalPrice();
                    invoice.setDate(result.getTimestamp("date"));
                    break;
                case Cashless:
                    invoice = new CashlessInvoice(result.getInt("id"),
                            getFoodOrder(result.getInt("id")),
                            DatabaseCustomerPostgre.getCustomerById(result.getInt("customer_id")),
                            DatabasePromoPostgre.getPromoById(result.getInt("promo_id"))
                    );
                    invoice.setInvoiceStatus(InvoiceStatus.valueOf(result.getString("invoice_status")));
                    invoice.setTotalPrice();
                    invoice.setDate(result.getTimestamp("date"));
                    break;
            }
        }
        statement.close();
        connection.close();
        return invoice;
    }

    /**
     * insert new invoice data to database
     * @param invoice invoice object
     * @throws SQLException throw exception if query goes wrong
     */
    public static void insertInvoice(Invoice invoice) throws SQLException {
        for(Invoice invoice1 : getInvoiceByCustomer(invoice.getCustomer().getId())){
            if(invoice1.getInvoiceStatus().equals(InvoiceStatus.Ongoing)){
                throw new SQLException();
            }
        }
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        PaymentType paymentType = invoice.getPaymentType();
        String query = null;
        switch (paymentType) {
            case Cash:
                query = "insert into invoice values(" +
                        "'" + invoice.getId() + "', " +
                        "'" + invoice.getPaymentType() + "', " +
                        "'" + invoice.getDate() + "', " +
                        "'" + invoice.getTotalPrice() + "', " +
                        "'" + invoice.getCustomer().getId() + "', " +
                        "'" + invoice.getInvoiceStatus() + "', " +
                        "'" + ((CashInvoice) invoice).getDeliveryFee() + "', " +
                        "" + null + " " +
                        ")";
                break;
            case Cashless:
                Promo promo = ((CashlessInvoice) invoice).getPromo();

                query = "insert into invoice values(" +
                        "'" + invoice.getId() + "', " +
                        "'" + invoice.getPaymentType() + "', " +
                        "'" + invoice.getDate() + "', " +
                        "'" + invoice.getTotalPrice() + "', " +
                        "'" + invoice.getCustomer().getId() + "', " +
                        "'" + invoice.getInvoiceStatus() + "', " +
                        "" + 0 + ", " +
                        "" + ((promo!=null) ? promo.getId() : null) + " " +
                        ")";
                break;
        }
        statement.executeUpdate(query);
        for (Food food :
                invoice.getFoods()) {
            query = "insert into food_order( food_id, invoice_id) values(" +
                    "'" + food.getId() + "', " +
                    "" + invoice.getId() + " " +
                    ");";
            statement.executeUpdate(query);
        }
        statement.close();
        connection.close();
    }

    /**
     * Change the status of the invoice in the database
     * @param id id of the invoice in database
     * @param status new status of the invoice
     * @return
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus status) {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "update invoice set invoice_status ='" +
                    status + "' where id=" +
                    +id + "";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * remove invoice from database
     * @param id id of invoice
     * @return
     */
    public static boolean removeInvoice(int id) {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            if (deleteFoodOrder(id)) {
                String query = "delete from invoice where id=" + id + "";
                statement.executeUpdate(query);
            }
            statement.close();
            connection.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * get the list of food that invoice has from database
     * @param invoiceId id of the invoice
     * @return list of food object
     */
    public static ArrayList<Food> getFoodOrder(int invoiceId) {
        Connection connection = DatabaseConnectionPostgre.connection();
        ArrayList<Food> foods = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from food_order fo inner join food f on fo.food_id=f.id where " +
                    "invoice_id='" + invoiceId + "' ";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                foods.add(new Food(result.getInt("id"),
                        result.getString("name"),
                        DatabaseSellerPostgre.getSellerById(result.getInt("seller_id")),
                        result.getInt("price"),
                        FoodCategory.valueOf(result.getString("category"))
                ));
            }
            statement.close();
            connection.close();
            return foods;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * delete the list of food that invoice has from database
     * @param invoiceId id of the invoice
     * @return true if invoice found
     */
    public static boolean deleteFoodOrder(int invoiceId) {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "delete from food_order where invoice_id=" + invoiceId + "";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
