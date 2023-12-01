package com.tecsup.ferreteria.users;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    final UserRepository userRepository;

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public UserModel getUser(Long id) {
        try {
            UserModel user = userRepository.findById(id).orElse(null);
            if (user != null) {
                // Elimina la contraseña por razones de seguridad
                user.setPassword(null);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error para fines de depuración
        }
        return null;
    }

    public UserModel updateUser(Long id, UserModel updatedUser) {
        try {
            UserModel user = userRepository.findById(id).orElse(null);
            if (user != null) {
                // Actualiza los campos relevantes de user con los datos de updatedUser
                // Implementa la lógica de actualización según tus requisitos
                user.setFirstname(updatedUser.getFirstname());
                user.setLastname(updatedUser.getLastname());
                // Actualiza otros campos aquí
                UserModel updatedUserResult = userRepository.save(user);
                updatedUserResult.setPassword(null); // Elimina la contraseña por razones de seguridad
                return updatedUserResult;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error para fines de depuración
        }
        return null;
    }

    public UserModel deleteUser(Long id) {
        try {
            UserModel user = userRepository.findById(id).orElse(null);
            if (user != null) {
                userRepository.delete(user); // Elimina el usuario
                user.setPassword(null); // Elimina la contraseña por razones de seguridad
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
