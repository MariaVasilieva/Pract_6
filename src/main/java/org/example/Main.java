package org.example;


public class Main {
    public static void main(String[] args) {
        Table users = new Table.Builder()
                .setName("users")
                .addField("id", "INTEGER")
                .addField("username", "VARCHAR(100)")
                .addField("email", "VARCHAR(255)")
                .build();

        Table orders = new Table.Builder()
                .setName("orders")
                .addField("order_id", "INTEGER")
                .addField("user_id", "INTEGER")
                .addField("total", "DECIMAL(10,2)")
                .build();

        DatabaseSchema schema = new DatabaseSchema.Builder()
                .setName("ShopDB")
                .setVersion("1.1")
                .setDescription("База даних інтернет-магазину")
                .addTable(users)
                .addTable(orders)
                .build();

        schema.showSchema();
    }
}