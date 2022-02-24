package dz.hashcode2022.one_pizza.onepizzahashcode2022;

import dz.hashcode2022.one_pizza.onepizzahashcode2022.service.Helper;
import dz.hashcode2022.one_pizza.onepizzahashcode2022.service.LocalScoreBoardSimulator;
import dz.hashcode2022.one_pizza.onepizzahashcode2022.model.Customer;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//Submission scoreboard:

//a_an_example -> Approach 3 -> gives score 5
//b_basic -> Approach 3 -> gives score 5
//c_coarse -> Approach 3 -> gives score 5
//d_difficult -> Approach 3 -> gives score 1706
//e_elaborate -> Approach 4 -> gives score 1471

public class Main {

    public static void main(String args[]) throws IOException {
        Helper helper = new Helper();
        String firstGroup[] = { "a_an_example.in.txt", "b_basic.in.txt" };

        for (String input : firstGroup) {
            // getting input from file
            List<Customer> customers = helper.getInputFromFile(input);

            Map<String, Integer> allIngredient = helper.getAllIngredient();
            Map<String, Integer> choosedIngredient = helper.algorithm_1(customers, allIngredient);

            List<String> choosedIngredientList = helper.toArrayList(choosedIngredient);

            helper.writeIntoFile(choosedIngredientList, input);
            LocalScoreBoardSimulator localScoreBoardSimulator = new LocalScoreBoardSimulator(customers,
                    choosedIngredient);

            System.out.println("Score of" + input + " algo1 : " + localScoreBoardSimulator.getScore());

            Map<String, Integer> map = helper.algorithm_3(customers);

            LocalScoreBoardSimulator newsimulator = new LocalScoreBoardSimulator(customers, map);
            System.out.println("Score of" + input + " algo3 : " + newsimulator.getScore());

        }

        String secondGroup[] = { "c_coarse.in.txt", "d_difficult.in.txt", "e_elaborate.in.txt" };

        for (String input : secondGroup) {// 3 1441 1658
            List<Customer> customers = helper.getInputFromFile(input);
            Map<String, Integer> choosedIngredient = helper.algorithm_2(customers);
            List<String> choosedIngredientList = helper.toArrayList(choosedIngredient);
            helper.writeIntoFile(choosedIngredientList, input);
            LocalScoreBoardSimulator localScoreBoardSimulator = new LocalScoreBoardSimulator(customers,
                    choosedIngredient);
            System.out.println("Score of" + input + " algo2 : " + localScoreBoardSimulator.getScore());

            Map<String, Integer> map = helper.algorithm_3(customers);
            LocalScoreBoardSimulator newsimulator = new LocalScoreBoardSimulator(customers, map);
            System.out.println("Score of" + input + " algo3 : " + newsimulator.getScore());

        }
    }
}
