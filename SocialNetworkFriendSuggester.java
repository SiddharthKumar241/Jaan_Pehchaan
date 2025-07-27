import java.util.*;

public class SocialNetworkFriendSuggester {
    private Map<String, Set<String>> graph = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    private String formatName(String name) {
        name = name.toLowerCase();
        if (name.equals("siddharth"))
            return "Siddharth";
        return name;
    }

    private void printWithDelay(String text, int delayMs) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println();
    }

    public void addUser(String user) {
        user = user.toLowerCase();
        graph.putIfAbsent(user, new HashSet<>());
    }

    public void addFriendship(String u1, String u2) {
        u1 = u1.toLowerCase();
        u2 = u2.toLowerCase();
        if (!graph.containsKey(u1) || !graph.containsKey(u2) || u1.equals(u2)) {
            System.out.println("\u001B[31mInvalid friendship.\u001B[0m"); // Red text
            return;
        }
        graph.get(u1).add(u2);
        graph.get(u2).add(u1);
        System.out.println(
                "\u001B[32mFriendship added between " + formatName(u1) + " and " + formatName(u2) + "\u001B[0m"); // Green
                                                                                                                  // text
    }

    public void suggestFriends(String user) {
        user = user.toLowerCase();
        if (!graph.containsKey(user)) {
            System.out.println("\u001B[31mUser " + formatName(user) + " does not exist.\u001B[0m");
            return;
        }
        Set<String> friends = graph.get(user);
        Map<String, Integer> mutuals = new HashMap<>();
        for (String other : graph.keySet()) {
            if (other.equals(user) || friends.contains(other))
                continue;
            Set<String> otherFriends = graph.get(other);
            Set<String> common = new HashSet<>(friends);
            common.retainAll(otherFriends);
            int c = common.size();
            if (c > 0)
                mutuals.put(other, c);
        }
        if (mutuals.isEmpty()) {
            printWithDelay("\u001B[33mNo friend suggestions found for " + formatName(user)
                    + ". Try adding more friends!\u001B[0m", 40);
            return;
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mutuals.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        printWithDelay("\u001B[34mFriend suggestions for " + formatName(user) + ":\u001B[0m", 40);
        for (var e : list) {
            printWithDelay(" - " + formatName(e.getKey()) + " (" + e.getValue() + " common friend(s))", 30);
        }
    }

    void menu() {
        System.out.println(
                "\n\u001B[36m1. Add user\n2. Add friendship\n3. Suggest friends\n4. Show users\n5. Show friends\n0. Exit\u001B[0m");
        System.out.print("\u001B[35mChoose: \u001B[0m");
    }

    void showUsers() {
        System.out.println("\u001B[33mUsers:\u001B[0m");
        for (String u : graph.keySet())
            System.out.println(" - " + formatName(u));
    }

    void showFriends(String user) {
        user = user.toLowerCase();
        if (!graph.containsKey(user)) {
            System.out.println("\u001B[31mUser " + formatName(user) + " does not exist.\u001B[0m");
            return;
        }
        Set<String> f = graph.get(user);
        if (f.isEmpty()) {
            System.out.println(formatName(user) + " has no friends.");
            return;
        }
        System.out.println("Friends of " + formatName(user) + ":");
        for (String fr : f)
            System.out.println(" - " + formatName(fr));
    }

    public void run() {
        System.out.println("\u001B[32mWelcome Siddharth! Let's manage your friend network.\u001B[0m");
        while (true) {
            menu();
            String ch = scanner.nextLine().trim();
            switch (ch) {
                case "1":
                    System.out.print("New user: ");
                    addUser(scanner.nextLine().trim());
                    break;
                case "2":
                    System.out.print("First user: ");
                    String u1 = scanner.nextLine().trim();
                    System.out.print("Second user: ");
                    String u2 = scanner.nextLine().trim();
                    addFriendship(u1, u2);
                    break;
                case "3":
                    System.out.print("Suggest friends for: ");
                    suggestFriends(scanner.nextLine().trim());
                    break;
                case "4":
                    showUsers();
                    break;
                case "5":
                    System.out.print("Show friends of: ");
                    showFriends(scanner.nextLine().trim());
                    break;
                case "0":
                    System.out.println("\u001B[31mGoodbye! Stay connected.\u001B[0m");
                    return;
                default:
                    System.out.println("\u001B[31mInvalid choice\u001B[0m");
            }
        }
    }

    public static void main(String[] a) {
        SocialNetworkFriendSuggester s = new SocialNetworkFriendSuggester();
        s.addUser("siddharth");
        s.addUser("yash");
        s.addUser("aditya");
        s.addUser("varnika");
        s.addUser("ananya");
        s.addUser("vedansh");
        s.addUser("lakshya");
        s.addUser("aditi");
        s.addUser("ayushi");
        s.addUser("manya");

        s.addFriendship("siddharth", "yash");
        s.addFriendship("aditya", "varnika");
        s.addFriendship("ananya", "vedansh");
        s.addFriendship("lakshya", "aditi");
        s.addFriendship("ayushi", "manya");
        s.addFriendship("siddharth", "aditya");
        s.addFriendship("varnika", "ayushi");
        s.addFriendship("manya", "vedansh");

        s.run();
    }
}
