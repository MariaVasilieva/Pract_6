package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Клас {@code Table} описує реляційну таблицю бази даних.
 * Таблиця містить ім’я та набір полів із типами даних.
 * Об’єкти створюються за допомогою внутрішнього класу {@link Builder}.
 */
class Table {
    private String name;
    private Map<String, String> fields;
    /**
     * Приватний конструктор таблиці, викликається з Builder.
     *
     * @param builder білдер, який містить параметри таблиці
     */
    private Table(Builder builder) {
        this.name = builder.name;
        this.fields = builder.fields;
    }
    /**
     * Виводить у консоль структуру таблиці:
     * ім’я таблиці та список полів із типами.
     */
    public void showTable() {
        System.out.println("  Таблиця: " + name);
        for (var f : fields.entrySet()) {
            System.out.println("    " + f.getKey() + " : " + f.getValue());
        }
    }
    /**
     * Внутрішній клас {@code Builder} для побудови об’єкта {@link Table}.
     */
    public static class Builder {
        private String name;
        private Map<String, String> fields = new LinkedHashMap<>();
        /**
         * Встановлює ім’я таблиці.
         *
         * @param name назва таблиці
         * @return поточний Builder
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        /**
         * Додає нове поле до таблиці.
         *
         * @param name ім’я поля
         * @param type тип даних поля
         * @return поточний Builder
         */
        public Builder addField(String name, String type) {
            fields.put(name, type);
            return this;
        }
        /**
         * Створює об’єкт {@link Table} з усіма заданими параметрами.
         *
         * @return готова таблиця
         */
        public Table build() {
            return new Table(this);
        }
    }
}