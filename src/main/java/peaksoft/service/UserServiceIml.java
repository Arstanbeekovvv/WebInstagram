package peaksoft.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Favorite;
import peaksoft.entities.User;
import peaksoft.repository.UserRepository;

import java.util.List;

/**
 * @author Mukhammed Asantegin
 */
@Service
@RequiredArgsConstructor
public class UserServiceIml implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> search(String keyword) {
        return userRepository.search("%"+keyword+"%");
    }

    @Override
    public void save(User user) {
        user.setFavorite(new Favorite());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void favorite(Long loginId, Long favoriteUserId) {

        User urmat = userRepository.findById(loginId).orElseThrow();

        Favorite favorite = urmat.getFavorite();

        List<Long> favoriteUsersIds = favorite.getFavoriteUsersId();

        boolean foundFavId = false;


        for (Long id : favoriteUsersIds) {
            if (id.equals(favoriteUserId)){
                favoriteUsersIds.remove(favoriteUserId);
                foundFavId = true;
                break;
            }
        }
        if (!foundFavId) favoriteUsersIds.add(favoriteUserId);
    }
}
