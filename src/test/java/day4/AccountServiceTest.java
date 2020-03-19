package day4;

import junit.framework.TestCase;

import static org.mockito.Mockito.*;

public class AccountServiceTest extends TestCase {

    public void testShouldReadSalaryDetails() {
        AccountRepository mockAccountRepo = mock(AccountRepository.class);
        User mockUser = mock(User.class);

        when(mockAccountRepo.canReadSalaryDetails(mockUser)).thenReturn(true);

        AccountService accountService = new AccountService(mockAccountRepo);
        accountService.canReadSalaryDetails(mockUser);

        assertTrue("Should be able to read Salary Details", accountService.canReadSalaryDetails(mockUser));
    }

    public void testShouldFailReadingSalaryDetails() {
        AccountRepository mockAccountRepo = mock(AccountRepository.class);
        User mockUser = mock(User.class);

        when(mockAccountRepo.canReadSalaryDetails(mockUser)).thenReturn(false);

        AccountService accountService = new AccountService(mockAccountRepo);
        accountService.canReadSalaryDetails(mockUser);

        assertFalse("Should not be able to read Salary Details", accountService.canReadSalaryDetails(mockUser));
    }

    public void testShouldReadSalaryDetailsUsingStub() {
        AccountRepoStub accountRepoStub = new AccountRepoStub(true);

        AccountService accountService = new AccountService(accountRepoStub);

        User user = new User("dummy@email.com");
        assertTrue("Should be able to read Salary Details", accountService.canReadSalaryDetails(user));
    }

    public void testShouldFailReadingSalaryDetailsUsingStub() {
        AccountRepoStub accountRepoStub = new AccountRepoStub(false);

        AccountService accountService = new AccountService(accountRepoStub);

        User user = new User("dummy@email.com");
        assertFalse("Should fail reading Salary Details", accountService.canReadSalaryDetails(user));
    }

    private class AccountRepoStub extends AccountRepository {

        boolean shouldAbleToReadSalaryDetails;

        AccountRepoStub(boolean shouldAbleToReadSalaryDetails) {
            this.shouldAbleToReadSalaryDetails = shouldAbleToReadSalaryDetails;
        }

        @Override
        public Boolean canReadSalaryDetails(User user) {
            return shouldAbleToReadSalaryDetails;
        }
    }


    public void testCanReadSalaryDetailsWithUserDomain() {

        User normalUser = new User("dummy@email.com");

        AccountRepository mock = mock(AccountRepository.class);
        //If User implemented account then we don't need to pass new UserAccount(), we could have used User obj itself
        when(mock.getUserAccount(normalUser)).thenReturn(new UserAccount());

        AccountService accountService = new AccountService(mock);

        assertFalse("User should not be able to read salary details",
                accountService.canReadSalaryDetailsWithDomain(normalUser));
    }

    public void testCanReadSalaryDetailsWithAdminDomain() {

        User adminUser = new User("dummy@email.com");
        AccountRepository mock = mock(AccountRepository.class);
        when(mock.getUserAccount(adminUser)).thenReturn(new AdminAccount());

        AccountService accountService = new AccountService(mock);

        assertTrue("Admin should be able to read salary details",
                accountService.canReadSalaryDetailsWithDomain(adminUser));
    }

}