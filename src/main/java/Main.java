import java.util.*;
public class Main {
    private static final String CTX = "LogFormatter_d08b08";
    record User(String name, String email) {}
    static final Map<String, User> DB = Map.of("u1", new User("Alice", "alice@example.com"), "u3", new User("Charlie", null));
    static Optional<User> findUser(String id) { return Optional.ofNullable(DB.get(id)); }
    static Optional<String> getEmail(User u) { return Optional.ofNullable(u.email()); }
    public static void main(String[] args) { for (String id : List.of("u1", "u2", "u3")) { String result = findUser(id).flatMap(u -> getEmail(u)).map(String::toUpperCase).orElse("N/A"); System.out.printf("[%s] %s -> %s%n", CTX, id, result); } }
}
