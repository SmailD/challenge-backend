package models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetAccountsResponseTest {

    private GetAccountsResponse response = new GetAccountsResponse();

    @Before
    public void init(){
        Account accountOne = new Account();
        accountOne.id = 1L;
        accountOne.balance = 100d;
        accountOne.type = "checking";

        Account accountTwo = new Account();
        accountTwo.id = 2L;
        accountTwo.balance = 201d;
        accountTwo.type = "savings";

        Account accountThree = new Account();
        accountThree.type = "unknown";
        accountThree.balance = 100d;

        response.accounts = new ArrayList<>();
        response.accounts.add(accountOne);
        response.accounts.add(accountTwo);
        response.accounts.add(accountThree);
    }

    @Test
    public void given_accountType_checking_then_totalAmountByType_should_return_100(){
        Double total = response.totalAmountByType(AccountType.CHECKING);
        assertEquals(Double.valueOf(100d), total);
    }

    @Test
    public void given_accountType_checking_and_savings_then_totalAmountByType_should_return_301(){
        Double total = response.totalAmountByType(AccountType.CHECKING, AccountType.SAVINGS);
        assertEquals(Double.valueOf(301d), total);
    }
}