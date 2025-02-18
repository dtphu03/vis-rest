package vis.restsocial.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vis.restsocial.DTO.UserDTO;
import vis.restsocial.Mapper.UserMapper;
import vis.restsocial.model.User;
import vis.restsocial.repo.UserRepo;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepo userRepo;
    public List<UserDTO> getUsers(){
        log.info("Get all users");
        return userRepo.findAll()
                .stream()
                .map(UserMapper::toUserDTO)
                .toList();
    }

}
