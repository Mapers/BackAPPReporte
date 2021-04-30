package com.cloudsrcsoft.reportes.repository.jdbc;

import com.cloudsrcsoft.reportes.security.model.UserModel;

public interface UserCustomRepository {

	UserModel findByUsername(String username);

}
