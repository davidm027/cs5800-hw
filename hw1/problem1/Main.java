package problem1;

public class Main {
    public static void main(String[] args) {
        Employee jjones = new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500);
        Employee ssmith = new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25, 32);
        Employee mquinn = new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19, 47);
        Employee ndior = new CommisionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000);
        Employee rchanel = new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700);
        Employee mdavenport = new BaseEmployee("Michael", "Davenport", "666-66-6666", 95000);
        Employee mvaziri = new CommisionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40000);

        System.out.println(jjones);
        System.out.println(ssmith);
        System.out.println(mquinn);
        System.out.println(ndior);
        System.out.println(rchanel);
        System.out.println(mdavenport);
        System.out.println(mvaziri);
    }
}
