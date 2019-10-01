package main;

public class Client {
    private String name;
    private int budget = 0;

    public Client() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getName() {
        if (name == null){
            return "";
        }
        return name;
    }

    public int getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        StringBuffer client = new StringBuffer();
        client.append("Witaj");
        if (name != null && name != ""){
            client.append(" ").append(name);
        }
        if (budget > 0){
            client.append(", dysponujesz budżetem: ").append(budget). append("zł");
        }
        return client.toString();
    }
}
