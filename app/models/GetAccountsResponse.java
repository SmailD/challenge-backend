package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class GetAccountsResponse {

    @JsonProperty("resources")
    public List<Account> accounts;

    public double totalAmountByType(AccountType... params){
        Predicate<Account> predicates = createAccountTypePredicatesOf(params);
        return accounts.stream()
                .filter(predicates)
                .mapToDouble(account -> account.balance)
                .sum();
    }

    private Predicate<Account> createAccountTypePredicatesOf(AccountType... params) {
        return Stream.of(params)
                .map(AccountType::getType)
                .map(s -> (Predicate<Account>) account -> account.type.equals(s))
                .reduce(p -> false, Predicate::or);
    }
}
