package com.redoz.onclassuser.domain.api.usecase;
import com.redoz.onclassuser.domain.exception.EmailAlreadyExistsException;
import com.redoz.onclassuser.domain.exception.NoDataFoundException;
import com.redoz.onclassuser.domain.exception.UserAlreadyExistsException;
import com.redoz.onclassuser.domain.model.Role;
import com.redoz.onclassuser.domain.model.User;
import com.redoz.onclassuser.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userUseCase = new UserUseCase(userPersistencePort);
    }

    @Test
    void shouldSaveUserWhenUserDoesNotExist() {
        User user = getUser();
        user.setEmail("test@test.com");
        user.setDocumentNumber("123456789");

        when(userPersistencePort.findUserByDocumentNumber(user.getDocumentNumber())).thenReturn(Optional.empty());
        when(userPersistencePort.findUserByEmail(user.getEmail())).thenReturn(Optional.empty());

        userUseCase.saveUser(user);

        verify(userPersistencePort, times(1)).saveUser(user);
    }

    @Test
    void shouldThrowUserAlreadyExistsExceptionWhenUserWithSameDocumentNumberExists() {
        User user = getUser();
        user.setDocumentNumber("123456789");

        when(userPersistencePort.findUserByDocumentNumber(user.getDocumentNumber())).thenReturn(Optional.of(user));

        assertThrows(UserAlreadyExistsException.class, () -> userUseCase.saveUser(user));
    }

    @Test
    void shouldThrowEmailAlreadyExistsExceptionWhenUserWithSameEmailExists() {
        User user = getUser();
        user.setEmail("test@test.com");

        when(userPersistencePort.findUserByEmail(user.getEmail())).thenReturn(Optional.of(user));

        assertThrows(EmailAlreadyExistsException.class, () -> userUseCase.saveUser(user));
    }

    @Test
    void shouldReturnUserWhenUserIsFoundByEmail() {
        String email = "john@doe.com";
        User user = getUser();
        user.setEmail(email);

        when(userPersistencePort.findUserByEmail(email)).thenReturn(Optional.of(user));

        User result = userUseCase.findUserByEmail(email);

        assertEquals(user, result);
    }

    @Test
    void shouldThrowNoDataFoundExceptionWhenNoUserIsFoundByEmail() {
        String email = "john@doe.com";

        when(userPersistencePort.findUserByEmail(email)).thenReturn(Optional.empty());

        assertThrows(NoDataFoundException.class, () -> userUseCase.findUserByEmail(email));
    }

    User getUser() {
        return new User.Builder()
                .documentNumber("123456789")
                .email("johndoe@email.com")
                .name("John")
                .lastName("Doe")
                .telephone("123456789")
                .role(Role.ADMIN)
                .password("password")
                .build();
    }
}