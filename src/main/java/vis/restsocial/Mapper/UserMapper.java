package vis.restsocial.Mapper;

import vis.restsocial.DTO.UserDTO;
import vis.restsocial.model.User;

public class UserMapper {
    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setDate(user.getDate());
        userDTO.setPhone(user.getPhone());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
