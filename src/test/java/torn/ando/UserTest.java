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
        Expense expense1 = new Expense("mofogasy 100",5_000, Category.FOOD_RESTAURANT, LocalDate.now());
        Expense expense2 = new Expense("ramanonaka 10",500, Category.FOOD_RESTAURANT, LocalDate.of(2024,6,1));

        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(expense1);
        expenseList.add(expense2);
        user.addExpense(expense1);

        user.addExpense(expense2);
        Assertions.assertEquals(user.getExpenseList(), expenseList);
        Assertions.assertEquals(user.getTotalSpentThisMonth(),5_000);
    }
}
