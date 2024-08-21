package torn.ando.budgetmaster;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String name;
    double mensualBudget;
    List<Expense> expenseList;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Double.compare(mensualBudget, user.mensualBudget) == 0 && Objects.equals(name, user.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mensualBudget);
    }

    public User(String name, double mensualBudget) {
        this.name = name;
        this.mensualBudget = mensualBudget;
        this.expenseList = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        if(expense.getAmount()<=0){
            throw new IllegalArgumentException("Expense amount must be greater than zero");
        }else expenseList.add(expense);
    }

    public List<Expense> getAllByDate(){
        Collections.sort(expenseList, Comparator.comparing(expense -> expense.getExpenseDate()));
        return expenseList;
    }

    public double getExpenseByCategory(Category category){
        double sum = 0;
        for(Expense expense : expenseList){
            if(expense.getCategory().equals(category)){
               sum += expense.getAmount();
            }
        }
        return sum;
    }

    public double getTotalSpentThisMonth(){
        double totalSpent = 0;
        Month thisMonth = LocalDate.now().getMonth();
        for(Expense expense : expenseList){
            if(expense.getExpenseDate().getMonth()==thisMonth){
                totalSpent += expense.getAmount();
            }
        }
        return totalSpent;
    }

    public double getRemainingBudget(){
        return getMensualBudget() - getTotalSpentThisMonth();
    }

    public void getTopCategories(){
        Map<Category,Double> orderByCategory = new HashMap<>();
        for (Expense expense : expenseList) {
            for (Category category : Category.values()) {
                if (expense.getCategory() == category){
                    orderByCategory.put(category, expense.getAmount());
                }
            }
        }
    }

}
