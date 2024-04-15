package com.redoz.onclassuser.domain.api.usecase;

import com.redoz.onclassuser.domain.api.IUserServicePort;
import com.redoz.onclassuser.domain.constant.ExceptionConstants;
import com.redoz.onclassuser.domain.exception.EmailAlreadyExistsException;
import com.redoz.onclassuser.domain.exception.NoDataFoundException;
import com.redoz.onclassuser.domain.exception.UserAlreadyExistsException;
import com.redoz.onclassuser.domain.model.User;
import com.redoz.onclassuser.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        if (userPersistencePort.findUserByDocumentNumber(user.getDocumentNumber()).isPresent()){
            throw new UserAlreadyExistsException(user.getDocumentNumber());
        }

        if (userPersistencePort.findUserByEmail(user.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException(user.getEmail());
        }

        userPersistencePort.saveUser(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userPersistencePort.findUserByEmail(email)
                .orElseThrow(() -> new NoDataFoundException(ExceptionConstants.NO_DATA_FOUND_USER_EXCEPTION_MESSAGE));
    }
}
