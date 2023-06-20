class Employee {
    private String name;
    private List<Employee> subordinates;

    public Employee(String name) {
        this.name = name;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String getName() {
        return name;
    }
}

public class EfficientHierarchyTraversalExample {
    public static void main(String[] args) {
        Employee ceo = new Employee("John (CEO)");
        
        Employee manager1 = new Employee("Mike (Manager 1)");
        Employee manager2 = new Employee("Lisa (Manager 2)");
        
        Employee employee1 = new Employee("Alice (Employee 1)");
        Employee employee2 = new Employee("Bob (Employee 2)");
        Employee employee3 = new Employee("Eve (Employee 3)");
        
        ceo.addSubordinate(manager1);
        ceo.addSubordinate(manager2);
        
        manager1.addSubordinate(employee1);
        manager1.addSubordinate(employee2);
        
        manager2.addSubordinate(employee3);
        
        // Traversing the hierarchy
        traverseHierarchy(ceo);
    }
    
    public static void traverseHierarchy(Employee root) {
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Employee employee = queue.poll();
                System.out.println(employee.getName());
                
                for (Employee subordinate : employee.getSubordinates()) {
                    queue.offer(subordinate);
                }
            }
        }
    }
}
