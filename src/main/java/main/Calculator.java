package main;

import additives.Model;

public class Calculator {

    public Calculator() {
    }

    public int getMinimalBudget(){
        int result = Integer.MAX_VALUE;
        for (Model model: Model.values()){
            if (result > model.getPrice()){
                result = model.getPrice();
            }
        }
        return result;
    }
}
