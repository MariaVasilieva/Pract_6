package org.example;

import java.util.*;

/**
 * Клас {@code DatabaseSchema} представляє структуру бази даних.
 * Його об'єкти створюються виключно за допомогою внутрішнього класу {@link Builder}.
 * Містить інформацію про ім’я бази даних, версію, опис та список таблиць.
 */
public class DatabaseSchema {
    private String name;
    private String version;
    private String description;
    private List<Table> tables;

    /**
     * Приватний конструктор. Створюється лише через Builder.
     *
     * @param builder об'єкт-білдер, що містить параметри для створення схеми бази даних.
     */
    private DatabaseSchema(Builder builder) {
        this.name = builder.name;
        this.version = builder.version;
        this.description = builder.description;
        this.tables = builder.tables;
    }
    /**
     * Виводить у консоль повну структуру бази даних:
     * ім’я, версію, опис і список таблиць.
     */
    public void showSchema() {
        System.out.println("База даних: " + name + " (v" + version + ")");
        System.out.println("Опис: " + description);
        System.out.println("Таблиці:");
        for (Table t : tables) {
            t.showTable();
        }
    }
    /**
     * Внутрішній клас {@code Builder} реалізує шаблон Builder
     * для поетапного створення об’єкта {@link DatabaseSchema}.
     */
    public static class Builder {
        private String name;
        private String version;
        private String description;
        private List<Table> tables = new ArrayList<>();
        /**
         * Встановлює назву бази даних.
         *
         * @param name ім’я бази
         * @return поточний об’єкт Builder (для ланцюгового виклику)
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        /**
         * Встановлює версію бази даних.
         *
         * @param version номер версії
         * @return поточний об’єкт Builder
         */
        public Builder setVersion(String version) {
            this.version = version;
            return this;
        }
        /**
         * Встановлює опис бази даних.
         *
         * @param description текстовий опис
         * @return поточний об’єкт Builder
         */
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        /**
         * Додає таблицю до схеми бази даних.
         *
         * @param table об’єкт таблиці
         * @return поточний об’єкт Builder
         */
        public Builder addTable(Table table) {
            this.tables.add(table);
            return this;
        }
        /**
         * Створює об’єкт {@link DatabaseSchema} з накопиченими параметрами.
         *
         * @return готовий екземпляр DatabaseSchema
         */
        public DatabaseSchema build() {
            return new DatabaseSchema(this);
        }
    }
}