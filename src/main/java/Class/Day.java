package Class;

public enum Day {
    SUNDAY(0, "Sunday"),
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday");

    private final int key;
    private final String value;

    // Constructor to initialize the key and value
    Day(int key, String value) {
        this.key = key;
        this.value = value;
    }

    // Method to get the key
    public int getKey() {
        return key;
    }

    // Method to get the value
    public String getValue() {
        return value;
    }

    // Method to find an enum constant by key
    public static Day fromKey(int key) {
        for (Day day : Day.values()) {
            if (day.getKey() == key) {
                return day;
            }
        }
        throw new IllegalArgumentException("No day with key: " + key);
    }

    // Method to find an enum constant by value
    public static Day fromValue(String value) {
        for (Day day : Day.values()) {
            if (day.getValue().equalsIgnoreCase(value)) {
                return day;
            }
        }
        throw new IllegalArgumentException("No day with value: " + value);
    }

    // Override toString to return the value (e.g., "Sunday")
    @Override
    public String toString() {
        return this.value;
    }
}
