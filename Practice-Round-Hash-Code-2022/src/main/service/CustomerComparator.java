package dz.hashcode2022.one_pizza.onepizzahashcode2022.service;

import dz.hashcode2022.one_pizza.onepizzahashcode2022.model.Customer;
import java.util.Comparator;

/**
 *
 * @author sohail mahmud
 */
public class CustomerComparator implements Comparator<Customer>{
    
    @Override
    public int compare(Customer customer1, Customer customer2) {

        if(customer1.getDislikedIngredients().size() == customer2.getDislikedIngredients().size()){
            return customer1.getLikedIngredients().size()-customer2.getLikedIngredients().size();
        }
        
       return customer1.getDislikedIngredients().size() - customer2.getDislikedIngredients().size();
    }
}
