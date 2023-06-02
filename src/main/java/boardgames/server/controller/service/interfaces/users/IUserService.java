package boardgames.server.controller.service.interfaces.users;

import boardgames.server.model.users.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserService {

    void updateUser(User updatedUser, Integer id);
}
