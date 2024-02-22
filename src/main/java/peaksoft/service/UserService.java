package peaksoft.service;


import peaksoft.entities.User;

import java.util.List;

/**
 * @author Mukhammed Asantegin
 */
public interface UserService {

    List<User> findAll();

    List<User> search(String keyword);

    void save(User user);

    void favorite(Long loginId, Long favoriteUserId);
}
