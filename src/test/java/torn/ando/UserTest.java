package torn.ando;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import torn.ando.budgetmaster.Category;
import torn.ando.budgetmaster.Expense;
import torn.ando.budgetmaster.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void createExpense(){
        User user = new User("john",500_000);
        Expense expense = new Expense("mofogasy 100",5_000, Category.FOOD_RESTAURANT, LocalDate.now());
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(expense);
        user.addExpense(expense);
        Assertions.assertEquals(user.getExpenseList(), expenseList);
    }
}
